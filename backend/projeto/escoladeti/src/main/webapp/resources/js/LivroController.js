function livroController ($scope, $http, $routeParams){
    console.log('Carregando controller');
    
    $scope.editar = function(livro){
        window.location = '#/cadastrolivro/' + livro.id;
    };
    
    $scope.deletar = function(livro){
        console.log('deletando livro' +JSON.stringify(livro));
        $http({
          method : 'DELETE',
          data : livro,
          url : './rest/livroSource/livro',
          headers : {'Content-Type': 'application/json; charset=UTF-8'}
        })
        .success(function(data, status){
            $scope.getTodos();
        	console.log("livro deletado");
	}).error(function(data, status) {
		console.log("erro ao deletar livro "+data);
        });
    };
    
    $scope.salvar = function(){
        console.log(angular.toJson($scope.livro, true));
        $http.post("./rest/livroSource/livro", $scope.livro)
        .success(function(livro, status){
            $scope.livro = getNovoLivro();
            console.log("livro salva = "+livro);
        })
        .error(function(data, status){
            console.log("erro ao salvar livro" +data);
        });
    };
    
    $scope.novo = function(){
        $scope.livro = getNovoLivro();
        window.location = '#/cadastrolivro';
    };
    
    $scope.getTodos = function(){

       $http.get("./rest/livroSource/livro")
        .success(function(livros, status){
            $scope.livros = livros;       
        })
        .error(function(data, status){
            console.log('erro ao buscar livros');
        });
    };
    
    $scope.carregarLivro = function() {
        console.log("carregando livro"); 	  		
	  if (!$routeParams.livroId) return;//se não tiver id não buscar
	  
	  $http.get('./rest/livroSource/livro/'+$routeParams.livroId)
		 .success(function(livro, status) {
			$scope.livro = livro;
		  console.log("carregando livro"); 	
              });
    };
       
//    
//     function carregaLivro (){
//        $http.get('./rest/livroSource/livro')
//                .success(function(livro){
//                    console.log('Livro carregada');
//                    $scope.livro = livro;
//        })
//                .error(function(data){
//                    console.log('Nao foi possivel carregar a livro' + data);
//        });
//    };
    
    function getNovoLivro() {
	  console.log('novo livro');
	  return {};
    };
    
    
}