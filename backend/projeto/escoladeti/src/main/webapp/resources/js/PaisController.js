function paisController ($scope, $http, $routeParams) {
	console.log('carregando controller');

  $scope.deletar = function(pais){
	/*  $http.delete("./rest/paisSorce/pais", pais)
      .success(function(data, status) {
		console.log("deletado");
	})
	.error(function(data, status) {
		console.log("erro ao deletar "+data);
	}); */
	  console.log('deletando pais '+JSON.stringify(pais));
	  $http({
		  method : 'DELETE',
		  data : pais,
		  url : './rest/paisSorce/pais',
		  headers : {'Content-Type': 'application/json; charset=UTF-8'}
	  })
	  .success(function(data, status) {
		$scope.getTodos();
		console.log("pais deletado");
	}).error(function(data, status) {
		console.log("erro ao deletar pais "+data);
	});
  };

  $scope.novo = function() {
	$scope.pais = getNovoPais();
  	window.location = "#/cadastropais"; 
  }
  
  $scope.carregarPais = function() {
	  console.log("carregando pais"); 	  		
	  if (!$routeParams.paisId) return;//se não tiver id não buscar
	  
	  $http.get('./rest/paisSorce/pais/'+$routeParams.paisId)
		 .success(function(pais, status) {
			$scope.pais = pais;
		});
  }
  
  $scope.editar = function(pais) {
	 window.location = "#/cadastropais/"+pais.id;
  }
  
  $scope.salvar = function() {
	  $http.post("./rest/paisSorce/pais", $scope.pais)
	  .success(function(pais, status) {
		  $scope.pais = getNovoPais();
		  console.log("pais salvo = "+pais);		
	  })
	  .error(function(data, status) {
		console.log("erro ao salvar "+data);
	  });;
  }
  
  $scope.getTodos = function () {
	$http.get("./rest/paisSorce/pais")
	.success(function (paises, status) {
		$scope.paises = paises;
	})
	.error(function(data, status) {
		console.log("erro ao buscar paises "+data);
	});
  }
  
  function getNovoPais() {
	  console.log('novo pais');
	  return {};
  }


}