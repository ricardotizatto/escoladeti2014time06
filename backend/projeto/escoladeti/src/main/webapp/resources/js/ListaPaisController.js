function ListaPaisController ($scope, bd) {
  $scope.paises = bd.paises;

  $scope.editarPais = function( indice ){
    bd.pais = $scope.paises[indice];
    window.location = "#/cadastropais";  
  };

  $scope.delPais = function(index){
      $scope.paises.splice(index,1);
  };

  $scope.novoPais = function(){
  	bd.pais = {};
  	window.location = "#/cadastropais"; 
  }

}