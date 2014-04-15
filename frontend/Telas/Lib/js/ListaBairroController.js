function ListaBairroController ($scope, bd) {
  $scope.bairros = bd.bairros;

  $scope.editarBairro = function( indice ){
    bd.bairro = $scope.bairros[indice];
    window.location = "#/cadastrobairro";  
  };

  $scope.delBairro = function(index){
      $scope.bairros.splice(index,1);
  };

  $scope.novoBairro = function(){
  	bd.bairro = {};
  	window.location = "#/cadastrobairro"; 
  }

}