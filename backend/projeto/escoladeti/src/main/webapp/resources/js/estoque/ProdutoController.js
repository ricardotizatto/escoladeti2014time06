function produtoController($scope, $http, $routeParams) {
    $scope.deletar = function(produto) {
        BootstrapDialog.confirm('Deseja realmente deletar o Produto: <b>' + produto.nome + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: produto,
                    url: './rest/produtoSource/produto',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                        .success(function(data, status) {
                            $scope.getTodos(1);
                            toastr.success('Produto ' + produto.nome + ' deletado com sucesso');
                        })
                        .error(function(data, status) {
                            toastr.error('Erro ao deletar o produto: ' + produto.nome + ' - ' + data.message);
                        });
            } else {
                $scope.getTodos(1);
            }
        });
    };

    $scope.novo = function() {
        $scope.produto = getNovoProduto();
        window.location = '#/cadastrotipoproduto';
    };

    $scope.carregarProduto = function() {
        if (!$routeParams.produtoId) {
            $scope.produto = getNovoProduto();
            return;//se não tiver id não buscar
        }

        $http.get('./rest/produtoSource/produto/' + $routeParams.produtoId)
                .success(function(produto, status) {
                    delete produto.info;
                    $scope.produto = produto;
                });

    };

    $scope.editar = function(produto) {
        window.location = '#/cadastrotipoproduto/' + produto.id;
    };

    $scope.buscaProdutosContendoNome = function() {
        $http.get('./rest/produtoSource/produto?q=' + $scope.busca.toUpperCase())
                .then(function(retorno) {
                    retorno.data.list.forEach(function(produto) {
                        delete produto.info;
                    });
                    $scope.produtos = retorno.data;
                });
    };

    $scope.validaEditar = function(){
        if($routeParams.produtoId){
            return true;
        }
        return false;
    };

    $scope.salvar = function() {
        if ($routeParams.produtoId) {
            return $scope.atualizar();
        }

        $scope.produto.nome = $scope.produto.nome.toUpperCase();
        $http.post("./rest/produtoSource/produto", $scope.produto)
                .success(function(produto, status) {
                    $scope.produto = getNovoProduto();
                    toastr.success('Produto ' + produto.nome + ' salvo com sucesso');
                    setTimeout(function() {
                        window.location = "#/listaproduto"
                    }, 2000);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar produto");
                    console.log(data);
                    toastr.error(data.message);
                });
    };

    $scope.atualizar = function() {
        $scope.produto.nome = $scope.produto.nome.toUpperCase();
        $http.post("./rest/produtoSource/produto/atualizar", $scope.produto)
                .success(function(produto, status) {
                    $scope.produto = getNovoProduto();
                    toastr.success('Produto ' + produto.nome + ' salvo com sucesso');
                    setTimeout(function() {
                        window.location = "#/listaproduto"
                    }, 2000);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar produto" + data);
                    toastr.error(data.message);
                });
    };

    $scope.getTodos = function(numeroPagina) {
        $http.get('./rest/produtoSource/listar/pag/' + numeroPagina)
                .success(function(listaProdutos, status) {

                    listaProdutos.list.forEach(function(produto) {
                        delete produto.info;
                    });
                    $scope.produtos = listaProdutos;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar produtos ' + data);
                });
    };

    function getNovoProduto() {
        return {};
    }
    ;

    $scope.voltar = function() {
        $scope.produto = {};
        window.location = '#/listaproduto';
    };
}