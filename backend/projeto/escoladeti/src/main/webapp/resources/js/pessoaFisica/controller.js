'use strict';
var controllers = angular.module('controllers');

function PessoaFisicaController($scope, $routeParams, pessoaFisicaService, paisService, estadoService, cidadeService, BuscaCepFactory) {
    $scope.select2 = 'one';
    console.log('Carregando controller');
    $scope.info = {};

    $scope.modificarPais = function(paisId) {
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        if (!paisId || paisId == null)
            return;
        estadoService.buscaEstadosPorPais(paisId)
                .success(function(data, status) {
                    $scope.unidadesFederativas = data;
                });
    };

    $scope.validaCpf = function(cpf) {
        if (!ValidarCPF(cpf)) {
            toastr.warning("CPF inválido.");
            $scope.pessoaFisica.cpf = $scope.pessoaFisica.c;
        }
    };

    $scope.buscaCep = function() {
        var cepStr = JSON.stringify($scope.endereco.cep);
        var cep = cepStr.replace('.','');
        
        var cepp = JSON.parse(cep);
        
        console.log(cepp);
        
        var parametro = {
            cep: cepp
        };
        BuscaCepFactory.get(parametro,
                function(data) {
                    console.log(data);
                },
                function(status){
                    console.log(status);
                }
        );
    };

    $scope.modificarEstado = function(estadoId) {
        if (!$scope.endereco.cidade)
            $scope.cidade = {};
        if (!estadoId || estadoId == null)
            return;
        cidadeService.buscaCidadesPorEstado(estadoId)
                .success(function(data, status) {
                    $scope.cidades = data;
                });
    }

    var buscarSelecionado = function() {

        var selecionados = $.grep($scope.endereco.paises, function(item) {
            return item.id == $scope.idPais;
        });

        console.log(selecionados[0]);

        $scope.pais = selecionados[0];
    };

    $scope.deletar = function(pessoa) {
        console.log('deletando pessoa ' + JSON.stringify(pessoa));

        BootstrapDialog.confirm('Deseja realmente deletar o Pessoa Fisica: <b>' + pessoa.nome + '</b>?', function(result) {
            if (result) {
                pessoaFisicaService.deletar(pessoa)
                        .success(function(data, status) {
                            $scope.getTodos(1);
                            console.log('Pessoa Fisica deletada');
                            toastr.success(pessoa.nome + " deletado com sucesso.");
                        })
                        .error(function(data, status) {
                            console.log('erro ao deletar pessoa ' + data);
                            console.log(data.messageDeveloper);
                            toastr.error(data.message);
                        });
            }
        });

    };

    $scope.novo = function() {
        $scope.pessoaFisica = getNovaPessoaFisica();
        window.location = '#/pessoafisica';
    };

    $scope.carregarPessoa = function() {
        console.log('carregando pessoa fisica');

        if (!$routeParams.pessoaFisicaId) {
            $scope.pessoaFisica = getNovaPessoaFisica();
            return;//se não tiver id não buscar
        }

        pessoaFisicaService.buscar($routeParams.pessoaFisicaId)
                .success(function(p, status) {
                    $scope.pessoaFisica = p;
                });
    };

    var carregaPaises = function() {
        console.log('carregando pais');
        paisService.buscarTodos()
                .success(function(listaPaises) {
                    console.log(listaPaises);
                    $scope.paises = listaPaises;
                })
                .error(function(data) {
                    console.log('erro ao buscar paises ' + data);
                });
    };

    $scope.editar = function(p) {
        window.location = '#/pessoafisica/' + p.id;
    };

    $scope.init = function() {
        $scope.endereco = {};
        $scope.enderecos = [];
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        carregaPaises();
    }

    $scope.buscaPessoaFisicaContendoNome = function() {
        console.log($scope.busca);
        pessoaFisicaService.buscarPorNome($scope.busca)
                .then(function(retorno) {
                    console.log(retorno.data.list);
                    $scope.pessoasFisicas = retorno.data;
                });
    };

    $scope.salvar = function() {
        pessoaFisicaService.salvar($scope.pessoaFisica)
                .success(function(pf, status) {
                    $scope.pessoaFisica = getNovaPessoaFisica();
                    toastr.success('Pessoa Fisica ' + pf.nome + ' salvo com sucesso.');
                })
                .error(function(data, status) {
                    console.log('Pessoa fisica não salva ', data);
                    toastr.warning(data.message);
                    console.log(data.messageDeveloper);
                });
    };

    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        pessoaFisicaService.listar(numeroPagina)
                .success(function(listaPessoasFisicas, status) {
                    $scope.pessoasFisicas = listaPessoasFisicas;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar paises ' + data);
                });
    };

    function getNovaPessoaFisica() {
        return {
            id: null,
            nome: null,
            sobrenome: null,
            sexo: null,
            rg: null,
            cpf: null,
            dataNascimento: null,
            email: null,
            telefones: [],
            enderecos: []
        };
    }

    $scope.select2Options = {
    };

    $scope.voltar = function() {
        $scope.pessoaFisica = getNovaPessoaFisica();
        window.location = '#/listapessoafisica';
    };

//Novo telefone

    $scope.novoTelefone = function() {
        $scope.telefone = getNovoTelefone();
    }

    $scope.salvarTelefone = function() {
        if ($scope.indiceTelefone >= 0) {
            var indice = $scope.indiceTelefone;
            $scope.pessoaFisica.telefones.splice(indice, 1);
        }
        $scope.pessoaFisica.telefones.push($scope.telefone);
        console.log($scope.pessoaFisica.telefones);
        toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
        $scope.telefone = getNovoTelefone();
        $scope.indiceTelefone = {};
    };

    $scope.editarTelefone = function(indice) {
        $scope.indiceTelefone = indice;
        $scope.telefone = $scope.pessoaFisica.telefones[indice];
        console.log($scope.telefone);
    };

    $scope.delTelefone = function(index) {
        toastr.warning("Telefone removido  " + $scope.pessoaFisica.telefones[index].numero + "!");
        $scope.pessoaFisica.telefones.splice(index, 1);
    };


// Endereco    

    $scope.modificarCidade = function(cidadeId) {
        /*    	if($scope.endereco.cidade && $scope.indiceEndereco >= 0)
         return;*/
        cidadeService.buscar(cidadeId)
                .success(function(c, status) {
                    $scope.endereco.cidade = c;
                });
    };

    $scope.salvarEndereco = function() {

        $scope.endereco.logradouro = angular.uppercase($scope.endereco.logradouro);
        $scope.endereco.bairro = angular.uppercase($scope.endereco.bairro);
        if ($scope.endereco.complemento)
            $scope.endereco.complemento = angular.uppercase($scope.endereco.complemento);
        if ($scope.indiceEndereco >= 0) {
            $scope.pessoaFisica.enderecos.splice($scope.indiceEndereco, 1);
        }
        $scope.pessoaFisica.enderecos.push($scope.endereco);
        toastr.success("Endereço adicionado !");
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.indiceEndereco = {};
    };

    $scope.editarEndereco = function(indice) {
        $scope.indiceEndereco = indice;
        $scope.endereco = angular.copy($scope.pessoaFisica.enderecos[indice]);

        console.log($scope.endereco);

        $scope.pais = $scope.endereco.cidade.unidadeFederativa.pais;

        $scope.modificarPais($scope.pais.id);

        $scope.unidadeFederativa = $scope.endereco.cidade.unidadeFederativa;

        $scope.cidade = $scope.endereco.cidade;

        $scope.modificarCidade($scope.cidade.id);

        console.log($scope.cidade);
    };

    $scope.delEndereco = function(index) {
        toastr.warning("Endereço removido !");
        $scope.pessoaFisica.enderecos.splice(index, 1);
    };

    $scope.novoEndereco = function() {
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.cidades = [];
        $scope.unidadesFederativas = [];
        $scope.pais = {};
    }

    function getNovoEndereco() {
        return {
            tipoEndereco: 'RUA'
        };
    }

    function getNovoTelefone() {
        return {
            numero: $scope.c,
            tipo: 'RESIDENCIAL'
        };
    }
}

controllers.controller('PessoaFisicaController', ['$scope', '$routeParams', 'pessoaFisicaService', 'paisService', 'estadoService', 'cidadeService', 'BuscaCepFactory', PessoaFisicaController]);