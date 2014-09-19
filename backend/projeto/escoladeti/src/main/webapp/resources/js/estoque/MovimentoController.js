var controllers = angular.module('controllers');

function movimentoController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.select2 = 'one';
    $scope.info = {};

    $scope.deletar = function(movimento) {
        console.log('deletando movimento de produto' + JSON.stringify(movimento));

        BootstrapDialog.confirm('Deseja realmente deletar o Movimento: <b>' + movimento.produto.nome + ' ' + movimento.quantidade + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: movimento,
                    url: './rest/movimentacaoSource/movimentacao',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                        .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log('Movimento deletado!');
                    toastr.success('Movimento ' + movimento.produto.nome + ' ' + movimento.quantidade + ' deletado com sucesso');
                })
                        .error(function(data, status) {
                    console.log('Movimento não foi deletado' + data);
                    toastr.error('Erro ao deletar o movimento: ' + movimento.produto.nome + ' ' + movimento.quantidade + ' - ' + data.message);
                });
            } else {
                $scope.getTodos(1);
            }
        });
    };

    $scope.novo = function() {
        $scope.movimento = getNovoMovimento();
        window.location = '#/cadastromovimento';
    };

    $scope.carregarMovimento = function() {
        console.log('carregando movimento com id: ' + $routeParams.movimentoId);
        if (!$routeParams.movimentoId) {
            $scope.movimento = getNovoMovimento();
            return;//se não tiver id não buscar
        }

        $http.get('./rest/movimentacaoSource/movimentacao/' + $routeParams.movimentoId)
                .success(function(movimento, status) {
            console.log(movimento);
            
            
            $scope.movimento = movimento;
            $scope.produto.list.forEach(function(produto) {
                if (produto.id === $scope.movimento.produto.id) {
                    $scope.movimento.produto = produto.id;
                }

            });
        });

    };

    $scope.editar = function(movimento) {
        console.log(movimento);
        window.location = '#/cadastromovimento/' + movimento.id;
    };



    $scope.salvar = function() {

//        $scope.movimento.tipo = $scope.movimento.tipo.toUpperCase();
//        $scope.movimento.quantidade = $scope.movimento.quantidade;


        $scope.produto.list.forEach(function(produto) {
            if (produto.id == $scope.movimento.produto) {
                $scope.movimento.produto = produto;
            }

        });

        console.log($scope.movimento);
        $http.post("./rest/movimentacaoSource/movimentacao", $scope.movimento)
                .success(function(movimento, status) {
            $scope.movimento = getNovoMovimento();
            console.log("movimento salva = " + movimento);
            toastr.success('Movimento ' + movimento.produto.nome + ' ' + movimento.quantidade + ' salvo com sucesso');
            setTimeout(function() {
                window.location = "#/listamovimento"
            }, 2000);
        })
                .error(function(data, status) {
            console.log("erro ao salvar movimento" + data);
            // toastr.error(data.message);
        });
    };


    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get("./rest/movimentacaoSource/listar/pag/" + numeroPagina)
                .success(function(listaMovimentos, status) {

//            listaEstoques.list.forEach(function(estoque) {
//                delete estoque.info;
//            });
            $scope.movimentos = listaMovimentos;
        })
                .error(function(data, status) {
            console.log('erro ao buscar movimento ' + data);
        });
    };
    $http.get("./rest/produtoSource/produto")
            .success(function(listaProdutos, status) {

        $scope.produto = listaProdutos;
    })
            .error(function(data, status) {
        console.log('erro ao buscar produto ' + data);
    });
//    };


    function getNovoMovimento() {
        console.log('novo movimento movimento');
        return {};
    }
    ;

    $scope.voltar = function() {
        $scope.movimento = {};
        window.location = '#/listamovimento';
    };

    $scope.select2Options = {};

}
;

controllers.controller('MovimentoController', ['$scope', '$routeParams', 'movimentoService', 'produtoService', MovimentoController]);