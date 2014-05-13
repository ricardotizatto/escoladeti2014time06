function CidadeController ($scope, $http, $routeParams){
    console.log('Carregando controller');
    
    $scope.editar = function(id){
        window.location = "#/cadastrocidade/"+cidade.id;
    };
    
    $scope.deletar = function(cidade){
        console.log('deletando cidade' +JSON.stringfy(cidade));
        $http({
          method : 'DELETE',
          data : cidade,
          url : './rest/cidadeSource/cidade',
          headers : {'Content-type ': 'application/json; charset=UTF-8'}
        })
        .success(function(data, status){
            $scope.getTodos();
        	console.log("cidade deletado");
	}).error(function(data, status) {
		console.log("erro ao deletar cidade "+data);
        });
    };
    
    $scope.salvar = function(){
        $http.post("./rest/cidadeSource/cidade", $scope.cidade)
        .success(function(cidade, status){
            $scope.cidade = getNovaCidade();
            console.log("cidade salva = "+cidade);
        })
        .error(function(data, status){
            console.log("erro ao salvar cidade" +data);
        });
    };
    
    $scope.novo = function(){
        $scope.cidade = getNovaCidade();
        window.location = "#/cadastrocidade";
    };
    
    $scope.getTodos = function(){
        $http.get("./rest/cidadeSource/cidade")
        .success(function(cidades, status){
            $scope.cidades = cidades;       
        })
        .error(function(data, status){
            console.log('erro ao buscar cidades');
        });
    };
    
    $scope.carregarCidade = function() {
	  console.log("carregando cidade"); 	  		
	  if (!$routeParams.cidadeId) return;//se não tiver id não buscar
	  
	  $http.get('./rest/cidadeSource/cidade/'+$routeParams.paisId)
		 .success(function(cidade, status) {
			$scope.cidade = cidade;
		});
    };

    function getNovaCidade() {
	  console.log('nova cidade');
	  return {};
    };
}