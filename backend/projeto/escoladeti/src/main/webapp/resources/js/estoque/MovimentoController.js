var controllers = angular.module('controllers');

function movimentoController($scope, $routeParams, movimentoService) {
    $scope.select2 = 'one';
    $scope.info = {};
    $scope.novo = function() {
        $scope.movimento = getNovoMovimento();
        window.location = '#/cadastromovimento';
    };
    $scope.extornar = function(movimento) {
        BootstrapDialog.confirm('Deseja realmente extornar o movimento?', function(result) {
            if (result) {
//                movimento.tipo = movimento.tipo * (-1);
                movimentoService.extornar(movimento)
                        .success(function(movimento, status) {
                            toastr.success('Extorno realizado com sucesso.');
                            $scope.getTodos(1);
                        })
                        .error(function(data, status) {
                            toastr.error(data.message);
                        });
            } else {
                $scope.getTodos(1);
            }
        });
    };
    $scope.validaExtornado = function(movimento) {
        return movimento.extornado;
    };
    $scope.editar = function(movimento) {
        window.location = '#/cadastromovimento/' + movimento.id;
    };
    $scope.carregarMovimento = function() {
        movimentoService.listarPessoas()
                .success(function(listaPessoas, status) {
                    $scope.pessoas = listaPessoas;
                })
                .error(function(data, status) {
                    toastr.error(data.message);
                });
        movimentoService.listarProdutos()
                .success(function(listaProdutos, status) {
                    $scope.produtos = listaProdutos;
                })
                .error(function(data, status) {
                    toastr.error(data.message);
                });
        if ($routeParams.movimentoId) {
            movimentoService.buscar($routeParams.movimentoId)
                    .success(function(movimento, status) {
                        $scope.movimento = movimento;
                    })
                    .error(function(data, status) {
                        toastr.error(data.message);
                    });
        } else {
            $scope.movimento = getNovoMovimento();
        }
    };
    $scope.salvar = function() {
        movimentoService.salvar($scope.movimento)
                .success(function(movimento, status) {
                    toastr.success('Movimentação salva com sucesso.');
                    window.location = '#/listamovimento';
                })
                .error(function(data, status) {
                    toastr.error(data.message);
                });
    };
    $scope.getTodos = function(numeroPagina) {
        movimentoService.listar(numeroPagina)
                .success(function(listaMovimentos, status) {
                    $scope.movimentos = listaMovimentos;
                })
                .error(function(data, status) {
                    toastr.error(data.message);
                });
    };
    $scope.voltar = function() {
        window.location = '#/listamovimento/';
    };
    
    function getNovoMovimento() {
        return {tipo: "ENTRADA"};
    }
    ;
}
;
controllers.controller('movimentoController', ['$scope', '$routeParams', 'movimentoService', movimentoController]);