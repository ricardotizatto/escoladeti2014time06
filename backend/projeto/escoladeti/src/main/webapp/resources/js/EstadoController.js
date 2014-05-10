function EstadoController ($scope, $http, $routeParams) {
  

  $scope.editar = function(id){
    window.location = "#/cadastroestado/"+id;  
  };

  $scope.deletar = function(index){
      $scope.estados.splice(index,1);
  };

  $scope.novo = function(){
  	window.location = "#/cadastroestado"; 
  }
  

  function errorHandler(dados, status){
	  console.log("Erro "+data);	  
  }
  
  $scope.getTodos = function() {
	  console.log('buscando estados');
	  $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
	  .success(function(unidadesFederativas, status) {
		$scope.unidadesFederativas = unidadesFederativas;
	}).error(errorHandler);
  }
  
}