function ListaDistritoController ($scope, bd) {
  $scope.distritos = bd.distritos;

  $scope.editarDistrito = function( indice ){
    bd.distrito = $scope.distritos[indice];
    window.location = "#/cadastrodistrito";  
  };

  $scope.delDistrito = function(index){
      $scope.distritos.splice(index,1);
  };

  $scope.novoDistrito = function(){
  	bd.distrito = {};
  	window.location = "#/cadastrodistrito"; 
  }

}