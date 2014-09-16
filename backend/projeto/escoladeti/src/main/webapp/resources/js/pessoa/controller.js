var controllers = angular.module('controllers');

function PessoaController($scope, $location, $log, $routeParams, $http, Pessoa, BuscaCep, PaisService, EstadoService, CidadeService) {

    $scope.mask = '999.999.999-99';

    $scope.select2 = 'one';
    console.log('Carregando controller');

    $scope.init = function () {
        //$scope.tipoPessoa = 'F';
        $scope.filtroPessoaFisica(1);
        $scope.focusCpf = false;
        $scope.enderecoPrincipal = false;
    };

    $scope.modificarPais = function (paisId) {
        if (!paisId || paisId === null)
            return;
        EstadoService.buscaEstadosPorPais(paisId)
                .success(function (data, status) {
                    $scope.unidadesFederativas = data;
                });
    };

    $scope.validaCpf = function (cpf) {
        if(!cpf)
            return;
        $scope.focusCpf = !ValidarCPF(cpf);
        if ($scope.focusCpf && cpf) {
            toastr.warning("CPF inválido!");
            $scope.pessoa.cpf = undefined;
        }
    };

    $scope.validaCnpj = function (cnpj) {
        if(!cnpj)
            return;
        $scope.focusCnpj = !ValidarCNPJ(cnpj);
        if ($scope.focusCnpj && $scope.pessoa.aluno !== 'true') {
            toastr.warning("CNPJ inválido!");
            $scope.pessoa.cnpj = undefined;
        }
    };

    $scope.validaEmail = function () {
        if (ValidaEmail($scope.pessoa.email) === false)
            toastr.warning("E-mail inválido!");
    };


    $scope.novo = function () {
        console.log('Nova Pessoa');
        window.location = '#/pessoa';
    };

    $scope.carregarPessoa = function () {
        console.log('carregando pessoa:');

        if (!$routeParams.pessoaId) {
            $scope.novaPessoa("F");
            $log.debug('criando pessoa');
            return;
        }

        $log.debug('buscando pessoa');
        Pessoa.get({id: $routeParams.pessoaId, tipo: $routeParams.pessoaTipo}, function (pessoa) {

            $scope.pessoa = pessoa;
            $scope.telefone = pessoa.telefones[0];
            if (pessoa.tipo !== 'J') {
                $scope.pessoa.aluno = String(pessoa.aluno);
            }
        });
    };

    $scope.editar = function (p) {
        window.location = '#/pessoa/' + p.id + '/' + p.tipo;
    };

    $scope.buscaPessoaContendoNome = function () {
        $scope.busca = $scope.busca.toUpperCase();
        Pessoa.buscarPessoa({pagina: 1, busca: $scope.busca}, function (pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.getTodos = function (numeroPagina) {
        if ($scope.tipoPessoa === 'J') {
            $scope.filtroPessoaJuridica(numeroPagina);
        } else if ($scope.tipoPessoa === 'A') {
            $scope.filtroAluno(numeroPagina);
        } else {
            $scope.filtroPessoaFisica(numeroPagina);
        }

        Pessoa.get(function (pessoas) {
            $scope.totalItems = pessoas.length;
        });
    };


    $scope.filtroPessoaJuridica = function (numeroPagina) {
        Pessoa.paginarJuridica({pagina: numeroPagina}, function (pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.filtroPessoaFisica = function (numeroPagina) {
        Pessoa.get({pagina: numeroPagina},
        function (pagina) {
            console.log(pagina);
            $scope.pagina = pagina;
        },
                function (erro) {
                    console.log(erro);
                });
    };

    $scope.filtroAluno = function (numeroPagina) {
        Pessoa.paginarAluno({pagina: numeroPagina}, function (pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.novaPessoa = function (tipo) {
        if ($scope.tipo === "J") {
            $scope.pessoa = new Pessoa({
                tipo: "J",
                email: "",
                telefones: [],
                enderecos: []
            });
        } else {
            $scope.pessoa = new Pessoa({
                tipo: "F",
                email: "",
                aluno: "false",
                sexo: "MASCULINO",
                telefones: [],
                enderecos: []
            });
        }
    };

    $scope.salvar = function () {
        if ($scope.pessoa.id) {
            $scope.pessoa.$update(function () {
                toastr.success($scope.pessoa.nome + ' atualizado com sucesso');
                $scope.novaPessoa($scope.pessoa.tipo);
                window.location = '#/listapessoa';
            });
            return;
        }
        $scope.pessoa.$save(function () {
            toastr.success($scope.pessoa.nome + ' salvo com sucesso');
            $scope.novaPessoa($scope.pessoa.tipo);
            window.location = '#/listapessoa';
        });

    };

    $scope.deletar = function (pessoa) {

        BootstrapDialog.confirm('Deseja realmente deletar a Pessoa: <b>' + pessoa.nome + '</b>?', function (result) {
            if (result) {
                Pessoa.delete({id: pessoa.id, tipo: pessoa.tipo}, function () {
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

    $scope.voltar = function () {
        window.location = '#/listapessoa';
    };

//Novo telefone

    $scope.novoTelefone = function () {
        $scope.telefone = getNovoTelefone();
    };

    $scope.salvarTelefone = function () {
        if ($scope.indiceTelefone >= 0) {
            $scope.pessoa.telefones.splice($scope.indiceTelefone, 1);
        }
        $scope.pessoa.telefones.push($scope.telefone);
        console.log($scope.telefones);
        toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
        //$scope.telefone = getNovoTelefone();
        $scope.indiceTelefone = {};
    };

    $scope.editarTelefone = function (indice) {
        $scope.indiceTelefone = indice;
        $scope.telefone = angular.copy($scope.pessoa.telefones[indice]);
    };

    $scope.delTelefone = function (index) {
        toastr.warning("Telefone removido  " + $scope.pessoa.telefones[index].numero + "!");
        $scope.pessoa.telefones.splice(index, 1);
        if ($scope.pessoa.telefones.length === 0) {
            $scope.telefone = {};
        }
    };


// Endereco    

    $scope.modificarCidade = function (cidadeId) {
        if (!cidadeId)
            return;
        CidadeService.buscar(cidadeId)
                .success(function (c, status) {
                    $scope.endereco.cidade = c;
                });
    };

    $scope.salvarEndereco = function () {      
        if(contemEnderecoPrincipal($scope.endereco.principal)){
            console.log('Entrou aqui!');
            toastr.warning('Endereço principal já informado!');
            return;
        }
        
        $scope.endereco.logradouro = angular.uppercase($scope.endereco.logradouro);
        $scope.endereco.bairro = angular.uppercase($scope.endereco.bairro);

        if ($scope.endereco.complemento)
            $scope.endereco.complemento = angular.uppercase($scope.endereco.complemento);

        if (angular.isUndefined($scope.indiceEndereco))
            $scope.pessoa.enderecos.push($scope.endereco);
        else
            $scope.pessoa.enderecos[$scope.indiceEndereco] = $scope.endereco;
        toastr.success('Endereço adicionado !');
        $scope.endereco = getNovoEndereco();
        $scope.indiceEndereco = undefined;

    };

    $scope.editarEndereco = function (indice) {
        
        $scope.indiceEndereco = indice;

        $scope.endereco = angular.copy($scope.pessoa.enderecos[indice]);

        console.log($scope.endereco);

        $scope.modificarPais($scope.endereco.cidade.unidadeFederativa.pais.id);

        $scope.modificarEstado($scope.endereco.cidade.unidadeFederativa.id);

        $scope.modificarCidade($scope.endereco.cidade.id);


    };

    $scope.delEndereco = function (index) {
        toastr.warning('Endereço removido !');
        $scope.pessoa.enderecos.splice(index, 1);
    };

    $scope.novoEndereco = function () {
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.cidades = [];
        $scope.unidadesFederativas = [];
        $scope.pais = {};
    };

    $scope.modificarEstado = function (estadoId) {
                 
        if (!estadoId || estadoId === null)
            return;
        CidadeService.buscaCidadesPorEstado(estadoId)
                .success(function (data, status) {
                    $scope.cidades = data;
                });
    };
    
    function contemEnderecoPrincipal(principal){
        var contem = false;
        if(angular.isUndefined($scope.pessoa.enderecos)){
            console.log('Undefined!');
            return contem;
        }
        angular.forEach($scope.pessoa.enderecos,function(value, key){
            if(value.principal === 'S' && value.principal === principal){
                contem = true;
            }
                
        });
        return contem;
    };

    function getNovoEndereco() {
        return {
            tipoEndereco: 'RUA',
            principal: contemEnderecoPrincipal() ? 'N' : 'S'
        };
    }

    $scope.buscaCep = function (c) {
        if (!c) {
            return;
        }
        BuscaCep.get({cep: c},
        function (cep) {
            if (!cep.cidade) {
                return;
            }
            $scope.endereco = cep;
            $scope.modificarPais(cep.cidade.unidadeFederativa.pais.id);
            $scope.modificarEstado(cep.cidade.unidadeFederativa.id);
            $scope.endereco.id = null;
            $scope.endereco.principal = 'S';

            console.log($scope.endereco);
        }, function (mesage) {
            console.log(mesage);
        });
    };

    function getNovoTelefone() {
        return {
            tipo: 'CELULAR'
        };
    }

    (function () {
        PaisService.buscarTodos()
                .success(function (paises) {
                    $scope.paises = paises;
                });
    })();

    jQuery(function ($) {
        $.mask.definitions['~'] = '[+-]';
        //$("#numeroDdd").mask("99");
        $("#telefone").mask("9999-9999?9");
        $("#ramal").mask("9?");
        $("#cep").mask("99.999-999");
        $("#cpf").mask("999.999.999-99");
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
            'BuscaCepFactory',
            'paisService',
            'estadoService',
            'cidadeService',
            PessoaController
        ]);