function produtoController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.deletar = function(produto) {
        console.log('deletando produto ' + JSON.stringify(produto));
        
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
                    console.log('Produto deletado!');
                    toastr.success('Produto ' + produto.nome + ' deletado com sucesso'); 
                })
                .error(function(data, status) { 
                    console.log('Produto não foi deletado' + data);
                    toastr.error('Erro ao deletar o produto: ' + produto.nome + ' - '+ data.message);
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
        console.log('carregando produto com id: ' + $routeParams.produtoId );
        if (!$routeParams.produtoId){
            $scope.produto = getNovoProduto();
            return;//se não tiver id não buscar
        }    

        $http.get('./rest/produtoSource/produto/' + $routeParams.produtoId)
            .success(function(produto, status) {
                console.log(produto);
                delete produto.info;
                $scope.produto = produto;
            });
            
    };

    $scope.editar = function(produto) {
        console.log(produto);
        window.location = '#/cadastrotipoproduto/' + produto.id;
    };
    
    $scope.buscaProdutosContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/produtoSource/produto?q=' + $scope.busca.toUpperCase())
            .then(function(retorno) {
                console.log(retorno.data.list);
                
                retorno.data.list.forEach(function(produto) {
                    console.log(produto);
                    delete produto.info;
                });
                $scope.produtos = retorno.data;
            });
    };

    $scope.salvar = function() {
  
        $scope.produto.nome = $scope.produto.nome.toUpperCase();
        
        console.log($scope.produto);
        $http.post("./rest/produtoSource/produto", $scope.produto)
            .success(function(produto, status) {
                $scope.produto = getNovoProduto();
                console.log("produto salva = " + produto);
                toastr.success('Produto ' + produto.nome + ' salvo com sucesso');
                setTimeout(function(){window.location="#/listaproduto"}, 5000);
            })
            .error(function(data, status) {
                console.log("erro ao salvar produto" + data);
               // toastr.error(data.message);
            });
    };

    
    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        $http.get('./rest/produtoSource/listar/pag/' + numeroPagina)
            .success(function(listaProdutos, status) {
                
                listaProdutos.list.forEach(function (produto) {
                    delete produto.info;
                });
                $scope.produtos = listaProdutos;
            })
            .error(function(data, status) {
                console.log('erro ao buscar produtos ' + data);
            });
    };

    function getNovoProduto() {
        console.log('novo produto');
        return {};
    };
    
    $scope.voltar = function() {
        $scope.produto = {};
        window.location = '#/listaproduto';
    };
}