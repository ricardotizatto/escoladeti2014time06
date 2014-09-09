var controllers = angular.module('controllers');

function PessoaController($scope, $location, $log, $routeParams, $http, Pessoa) {
    $scope.select2 = 'one';
    console.log('Carregando controller');
    
    $scope.init = function() {
        $scope.tipoPessoa = 'F';
        $scope.filtroPessoaFisica(1);
    };
//
//    $scope.modificarPais = function(paisId) {
//        $scope.unidadeFederativa = {};
//        $scope.cidade = {};
//        if (!paisId || paisId === null)
//            return;
//        estadoService.buscaEstadosPorPais(paisId)
//                .success(function(data, status) {
//                    $scope.unidadesFederativas = data;
//                });
//    };

    $scope.validaCpf = function(cpf) {
        if (!ValidarCPF(cpf)) {
            toastr.warning("CPF inválido!");
            $scope.pessoa.cpf = $scope.pessoa.c;
        }
    };

    $scope.validaCnpj = function(cnpj) {
        if (!ValidarCNPJ(cnpj) && $scope.pessoa.aluno !== 'true') {
            toastr.warning("CNPJ inválido!");
            $scope.pessoa.cnpj = $scope.pessoa.c;
        }
    };
    
    $scope.validaEmail = function() {
        if(ValidaEmail($scope.pessoa.email) === false)
           toastr.warning("E-mail inválido!"); 
    };

//    $scope.modificarEstado = function(estadoId) {
//        if (!$scope.endereco.cidade)
//            $scope.cidade = {};
//        if (!estadoId || estadoId === null)
//            return;
//        cidadeService.buscaCidadesPorEstado(estadoId)
//                .success(function(data, status) {
//                    $scope.cidades = data;
//                });
//    };

//    var buscarSelecionado = function() {
//
//        var selecionados = $.grep($scope.endereco.paises, function(item) {
//            return item.id === $scope.idPais;
//        });
//
//        console.log(selecionados[0]);
//
//        $scope.pais = selecionados[0];
//    };

    $scope.novo = function() {
        console.log('Nova Pessoa');
        window.location = '#/pessoa';
    };
    
    $scope.carregarPessoa = function() {
        console.log('carregando pessoa:');

        if (!$routeParams.pessoaId) {
            $scope.novaPessoa("F"); 
            $log.debug('criando pessoa');
            return;
        }
        
        $log.debug('buscando pessoa');
        Pessoa.get({id: $routeParams.pessoaId, tipo: $routeParams.pessoaTipo}, function(pessoa) {
            
            $scope.pessoa = pessoa;
            $scope.telefone = pessoa.telefones[0];
            if(pessoa.tipo !== 'J'){
               $scope.pessoa.aluno = String(pessoa.aluno); 
            }
        });
    };


//    var carregaPaises = function() {
//        console.log('carregando pais');
//        paisService.buscarTodos()
//                .success(function(listaPaises) {
//                    console.log(listaPaises);
//                    $scope.paises = listaPaises;
//                })
//                .error(function(data) {
//                    console.log('erro ao buscar paises ' + data);
//                });
//    };


    $scope.editar = function(p) {
        window.location = '#/pessoa/' + p.id + '/' + p.tipo;
    };

    $scope.buscaPessoaContendoNome = function(tipoPessoa) {
        $scope.busca = $scope.busca.toUpperCase();
        if (tipoPessoa === 'F') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarFisica({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.pagina = pagina;
                });
            } else {
                $scope.filtroPessoaFisica(1);
            }
        }
        if (tipoPessoa === 'J') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarJuridica({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.pagina = pagina;
                });
            } else {
                $scope.filtroPessoaJuridica(1);
            }
        }
        if (tipoPessoa === 'A') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarAluno({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.pagina = pagina;
                });
            } else {
                $scope.filtroAluno(1);
            }
        }
    };
    
    $scope.getTodos = function(numeroPagina){
        if ($scope.tipoPessoa === 'J') {
            $scope.filtroPessoaJuridica(numeroPagina);
        }else if ($scope.tipoPessoa === 'A') {
            $scope.filtroAluno(numeroPagina);
        }else {
            $scope.filtroPessoaFisica(numeroPagina);
        }
    };    


    $scope.filtroPessoaJuridica = function(numeroPagina) {
        Pessoa.paginarJuridica({pagina: numeroPagina}, function(pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.filtroPessoaFisica = function(numeroPagina) {
        Pessoa.paginarFisica({pagina: numeroPagina}, function(pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.filtroAluno = function(numeroPagina) {
        Pessoa.paginarAluno({pagina: numeroPagina}, function(pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.novaPessoa = function(tipo){
        if ($scope.tipo === "J") {
            $scope.pessoa = new Pessoa({
                tipo: "J",
                email: "",
                telefones: []
            });
        } else {
            $scope.pessoa = new Pessoa({
                tipo:  "F",
                email: "",
                aluno: "false",
                sexo:  "MASCULINO",
                telefones: []
            });
        }
    };

    $scope.salvar = function() {
        if ($scope.pessoa.id) {
            $scope.pessoa.$update(function() {
                toastr.success($scope.pessoa.nome + ' atualizado com sucesso');
                $scope.novaPessoa($scope.pessoa.tipo); 
                window.location = '#/listapessoa';
            });
            return;
        }
        $scope.pessoa.$save(function() {
            toastr.success($scope.pessoa.nome + ' salvo com sucesso');           
            $scope.novaPessoa($scope.pessoa.tipo);
            window.location = '#/listapessoa';
        });
        
    };
    
    $scope.deletar = function(pessoa) {

        BootstrapDialog.confirm('Deseja realmente deletar a Pessoa: <b>' + pessoa.nome + '</b>?', function(result) {
            if (result) {
                Pessoa.delete({id: pessoa.id, tipo: pessoa.tipo}, function() {
                    toastr.success(pessoa.nome + ' deletada com sucesso');
                    if ($scope.tipoPessoa === 'J') {
                        $scope.filtroPessoaJuridica(1);
                    } else {
                        if ($scope.tipoPessoa === 'A') {
                            $scope.filtroAluno(1);
                        } else {
                            $scope.filtroPessoaFisica(1);
                        }
                    }
                });
            }
            return;
        });
    };

    $scope.select2Options = {
    };

    $scope.voltar = function() {
        window.location = '#/listapessoa';
    };

//Novo telefone

    $scope.novoTelefone = function() {
        $scope.telefone = getNovoTelefone();
    };

    $scope.salvarTelefone = function() {
        if ($scope.indiceTelefone >= 0) {
            $scope.pessoa.telefones.splice($scope.indiceTelefone, 1);
        }
        $scope.pessoa.telefones.push($scope.telefone);
        console.log($scope.telefones);
        toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
        //$scope.telefone = getNovoTelefone();
        $scope.indiceTelefone = {};
    };

    $scope.editarTelefone = function(indice) {
        $scope.indiceTelefone = indice;
        $scope.telefone = angular.copy($scope.pessoa.telefones[indice]);
    };

    $scope.delTelefone = function(index) {
        toastr.warning("Telefone removido  " + $scope.pessoa.telefones[index].numero + "!");
        $scope.pessoa.telefones.splice(index, 1);
        if($scope.pessoa.telefones.length === 0){
            $scope.telefone = {};
        }   
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
            $scope.pessoaJuridica.enderecos.splice($scope.indiceEndereco, 1);
        }
        $scope.pessoaJuridica.enderecos.push($scope.endereco);
        toastr.success("Endereço adicionado !");
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.indiceEndereco = {};
    };

    $scope.editarEndereco = function(indice) {
        $scope.indiceEndereco = indice;
        $scope.endereco = angular.copy($scope.pessoaJuridica.enderecos[indice]);

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
        $scope.pessoaJuridica.enderecos.splice(index, 1);
    };

    $scope.novoEndereco = function() {
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.cidades = [];
        $scope.unidadesFederativas = [];
        $scope.pais = {};
    };

    function getNovoEndereco() {
        return {
            tipoEndereco: 'RUA',
            principal: 'S'
        };
    }

    function getNovoTelefone() {
        return {
            tipo: 'CELULAR'
        };
    }

    jQuery(function($) {
        $.mask.definitions['~'] = '[+-]';
        //$("#numeroDdd").mask("99");
        $("#telefone").mask("9999-9999?9");
        $("#ramal").mask("9?");
        $("#cep").mask("99.999-999");
        //$("#cpf").mask("999.999.999-99");
        //$("#rg").mask("9.999.999-*");
        //$("#cnpj").mask("99.999.999/9999-99");
    });
}

controllers.controller('PessoaController',
        [
            '$scope',
            '$location',
            '$log',
            '$routeParams',
            '$http',
            'PessoaFactory',
            PessoaController
        ]);