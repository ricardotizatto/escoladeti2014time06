function ListaCidadeController ($scope, bd) {
  $scope.cidades = bd.cidades;

  $scope.editarCidade = function( indice ){
    bd.cidade = $scope.cidades[indice];
    window.location = "#/cadastrocidade";  
  };

  $scope.delCidade = function(index){
      $scope.cidades.splice(index,1);
  };

  $scope.novoCidade = function(){
  	bd.cidade = {};
  	window.location = "#/cadastrocidade"; 
  }

}