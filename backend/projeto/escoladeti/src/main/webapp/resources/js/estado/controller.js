var controllers = angular.module('controllers');

function EstadoController ($scope, $routeParams, paisService, estadoService) {

    console.log('Carregando controller');
    $scope.info = {};

    $scope.deletar = function(unidadeFederativa) {
        console.log('deletando unidadeFederativa ' + JSON.stringify(unidadeFederativa));

        BootstrapDialog.confirm('Deseja realmente deletar o Estado: <b>' + unidadeFederativa.nome + '</b>?', function(result) {
            if (result) {
            	estadoService.deletar(unidadeFederativa)
                    .success(function(data, status) {
                        $scope.getTodos(1);
                        console.log('Estado deletado!');
                        toastr.success('Estado '+unidadeFederativa.nome+' deletado.');
                    })
                    .error(function(data, status) {
                        console.log('Estado não foi deletado', data);
                        toastl.error(data.message);
                    });
            }
        });
    };

    $scope.novo = function() {
        $scope.unidadeFederativa = getNovoEstado();
        window.location = '#/cadastroestado';
    };

    $scope.carregarEstado = function() {
        console.log('carregando unidadeFederativa com id: ' + $routeParams.unidadeFederativaId);
        if (!$routeParams.unidadeFederativaId) {
            $scope.unidadeFederativa = getNovoEstado();
            return;//se não tiver id não buscar
        }

        estadoService.buscar( $routeParams.unidadeFederativaId)
            .success(function(unidadeFederativa, status) {
                console.log(unidadeFederativa);
                $scope.unidadeFederativa = unidadeFederativa;
            });
    };
    
    $scope.carregarPaises = function() {
    	console.log('carregando pais');
        paisService.buscarPorNome('')
            .success(function(listaPaises) {
                console.log(listaPaises);
                $scope.paises = listaPaises.list;
            })
            .error(function(data) {
                console.log('erro ao buscar paises ' + data);
            });
    };

    $scope.editar = function(unidadeFederativa) {
        console.log(unidadeFederativa);
        window.location = '#/cadastroestado/' + unidadeFederativa.id;
    };

    $scope.buscaEstadosContendoNome = function() {
        console.log($scope.busca);
        estadoService.buscarPorNome($scope.busca)
            .then(function(retorno) {
                console.log(retorno.data);
                $scope.unidadesFederativas = retorno.data;
            });
    };

    $scope.salvar = function() {

        $scope.unidadeFederativa.nome = $scope.unidadeFederativa.nome.toUpperCase();
        $scope.unidadeFederativa.sigla = $scope.unidadeFederativa.sigla.toUpperCase();

        console.log($scope.unidadeFederativa);
        estadoService.salvar($scope.unidadeFederativa)
            .success(function (unidadeFederativa) {
                $scope.unidadeFederativa = getNovoEstado();
                console.log("unidadeFederativa salva = " + unidadeFederativa);
                toastr.success('Estado '+unidadeFederativa.nome+' salvo com sucesso.');
            })
            .error(function (data) {
                console.log("erro ao salvar unidadeFederativa" + data);
                toastr.warning(data.message);
            });
    };

    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        estadoService.listar(numeroPagina)
            .success(function(listaUnidadesFederativas) {
                console.log(listaUnidadesFederativas);
                $scope.unidadesFederativas = listaUnidadesFederativas;
            })
            .error(function(data) {
                console.log('erro ao buscar Estados ' + data.developerMessage);
            });
    };

    function getNovoEstado() {
        console.log('novo Estado');
        return {
        	nome: '',
        	pais: null
        };
    };

    $scope.voltar = function() {
        $scope.unidadeFederativa = {};
        window.location = '#/listaestado';
    };
    
    $scope.select2Options = {
            allowClear:true
    };
}

controllers.controller('EstadoController', ['$scope', '$routeParams', 'paisService', 'estadoService', EstadoController]);