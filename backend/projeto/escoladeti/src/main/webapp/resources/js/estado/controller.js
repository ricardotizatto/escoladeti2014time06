var controllers = angular.module('controllers');

function EstadoController($scope, $routeParams, paisService, estadoService) {
    $scope.select2 = 'one';
    console.log('Carregando controller');
    $scope.info = {};

    var buscarSelecionado = function () {

        var selecionados = $.grep($scope.paises, function (item) {
            return item.id == $scope.unidadeFederativa.idPais;
        });

        console.log(selecionados[0]);

        $scope.unidadeFederativa.pais = selecionados[0];
    };

    $scope.deletar = function (unidadeFederativa) {
        console.log('deletando unidadeFederativa ' + JSON.stringify(unidadeFederativa));

        BootstrapDialog.confirm('Deseja realmente deletar o Estado: <b>' + unidadeFederativa.nome + '</b>?', function (result) {
            if (result) {
                estadoService.deletar(unidadeFederativa)
                        .success(function (data, status) {
                            $scope.getTodos(1);
                            console.log('Estado deletado!');
                            toastr.success('Estado ' + unidadeFederativa.nome + ' deletado.');
                        })
                        .error(function (data, status) {
                            console.log('Estado não foi deletado', data);
                            toastr.error(data.message);
                        });
            }
        });
    };

    $scope.novo = function () {
        $scope.unidadeFederativa = getNovoEstado();
        window.location = '#/cadastroestado';
    };

    $scope.carregarEstado = function () {
        console.log('carregando unidadeFederativa com id: ' + $routeParams.unidadeFederativaId);
        if (!$routeParams.unidadeFederativaId) {
            $scope.unidadeFederativa = getNovoEstado();
            return;//se não tiver id não buscar
        }

        estadoService.buscar($routeParams.unidadeFederativaId)
                .success(function (unidadeFederativa, status) {
                    console.log(unidadeFederativa);
                    console.log('pais', unidadeFederativa.pais);
                    $scope.unidadeFederativa = unidadeFederativa;
                    $scope.unidadeFederativa.idPais = unidadeFederativa.pais.id;
                });
    };

    (function () {
        console.log('carregando pais');
        paisService.buscarTodos()
                .success(function (listaPaises) {
                    console.log(listaPaises);
                    $scope.paises = listaPaises;
                })
                .error(function (data) {
                    console.log('erro ao buscar paises ' + data);
                });
    }());

    //carregarPaises('');

    $scope.editar = function (unidadeFederativa) {
        console.log(unidadeFederativa);
        window.location = '#/cadastroestado/' + unidadeFederativa.id;
    };

    $scope.buscaEstadosContendoNome = function () {
        console.log($scope.busca);
        estadoService.buscarPorNome($scope.busca)
                .then(function (retorno) {
                    console.log(retorno.data);
                    $scope.unidadesFederativas = retorno.data;
                });
    };

    $scope.salvar = function () {

        $scope.unidadeFederativa.nome = $scope.unidadeFederativa.nome.toUpperCase();
        $scope.unidadeFederativa.sigla = $scope.unidadeFederativa.sigla.toUpperCase();
        buscarSelecionado();

        console.log($scope.unidadeFederativa);
        estadoService.salvar($scope.unidadeFederativa)
                .success(function (unidadeFederativa) {
                    $scope.unidadeFederativa = getNovoEstado();
                    console.log("unidadeFederativa salva = " + unidadeFederativa);
                    toastr.success('Estado ' + unidadeFederativa.nome + ' salvo com sucesso.');
                    window.location = "#/listaestado";
                })
                .error(function (data) {
                    console.log("erro ao salvar unidadeFederativa" + data);
                    toastr.warning(data.message);
                });
    };

    $scope.getTodos = function (numeroPagina) {
        console.log(numeroPagina);
        estadoService.listar(numeroPagina)
                .success(function (listaUnidadesFederativas) {
                    console.log(listaUnidadesFederativas);
                    $scope.unidadesFederativas = listaUnidadesFederativas;
                    estadoService.buscarTodos()
                            .success(function(todos) {
                                $scope.totalItems = todos.length;
                            });
                        })
                        .error(function (data) {
                            console.log('erro ao buscar Estados ' + data.developerMessage);
                        });
            };

            function getNovoEstado() {
                console.log('novo Estado');
                return {
                    nome: '',
                    pais: null
                };
            }
            ;

            $scope.voltar = function () {
                $scope.unidadeFederativa = {};
                window.location = '#/listaestado';
            };

            $scope.select2Options = {
            };

        }

        controllers.controller('EstadoController', ['$scope', '$routeParams', 'paisService', 'estadoService', EstadoController]);