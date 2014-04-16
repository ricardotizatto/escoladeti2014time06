function ListaCepController ($scope, bd) {
  $scope.ceps = bd.ceps;

  $scope.editarCep = function( indice ){
    bd.cep = $scope.ceps[indice];
    window.location = "#/cadastrocep";  
  };

  $scope.delCep = function(index){
      $scope.ceps.splice(index,1);
  };

  $scope.novoCep = function(){
  	bd.cep = {};
  	window.location = "#/cadastrocep"; 
  }

}