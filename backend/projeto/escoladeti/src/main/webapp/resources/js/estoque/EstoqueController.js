function produtoController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.deletar = function(estoque) {
        console.log('deletando produto ' + JSON.stringify(estoque));
        
        BootstrapDialog.confirm('Deseja realmente deletar o Estoque: <b>' + estoque.nome + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: estoque,
                    url: './rest/estoqueSource/estoque',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log('Estoque deletado!');
                    toastr.success('Estoque ' + estoque.nome + ' deletado com sucesso'); 
                })
                .error(function(data, status) { 
                    console.log('Estoque não foi deletado' + data);
                    toastr.error('Erro ao deletar o estoque: ' + estoque.nome + ' - '+ data.message);
                });
            } else {
                $scope.getTodos(1);
            }    
        });
    };
    
    $scope.novo = function() {
        $scope.produto = getNovoEstoque();
        window.location = '#/cadastromovimentoestoque';
    };
        
    $scope.carregarEstoque = function() {
        console.log('carregando estoque com id: ' + $routeParams.estoqueId );
        if (!$routeParams.estoqueId){
            $scope.estoque = getNovoEstoque();
            return;//se não tiver id não buscar
        }    

        $http.get('./rest/estoqueSource/estoque/' + $routeParams.estoqueId)
            .success(function(estoque, status) {
                console.log(estoque);
                delete estoque.info;
                $scope.estoque = estoque;
            });
            
    };

    $scope.editar = function(estoque) {
        console.log(estoque);
        window.location = '#/cadastromovimentoestoque/' + estoque.id;
    };
    
 

    $scope.salvar = function() {
  
        $scope.estoque.movimentacao = $scope.estoque.movimentacao.toUpperCase();
        $scope.estoque.quantidade = $scope.estoque.quantidade;
        buscaSelecionado();
        
        console.log($scope.estoque);
        $http.post("./rest/estoqueSource/estoque", $scope.estoque)
            .success(function(estoque, status) {
                $scope.estoque = getNovoProduto();
                console.log("estoque salva = " + estoque);
                toastr.success('Estoque ' + estoque.nome + ' salvo com sucesso');
                setTimeout(function(){window.location="#/listaestoque"}, 5000);
            })
            .error(function(data, status) {
                console.log("erro ao salvar estoque" + data);
               // toastr.error(data.message);
            });
    };
    
//     var buscarSelecionado = function () {
//    	
//    	var selecionados = $.grep($scope.produtos, function (item) {
//    		return item.id == $scope.estoque.idProduto;
//    	});
//    	
//    	console.log(selecionados[0]);
//    	
//    	$scope.estoque.produto = selecionados[0];
//    };
    
    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        $http.get('./rest/estoqueSource/listar/pag/' + numeroPagina)
            .success(function(listaEstoques, status) {
                
                listaEstoques.list.forEach(function (estoque) {
                    delete estoque.info;
                });
                $scope.estoques = listaEstoques;
            })
            .error(function(data, status) {
                console.log('erro ao buscar estoque ' + data);
            });
    };

    function getNovoEstoque() {
        console.log('novo produto');
        return {};
    };
    
    $scope.voltar = function() {
        $scope.estoque = {};
        window.location = '#/listaestoque';
    };
}