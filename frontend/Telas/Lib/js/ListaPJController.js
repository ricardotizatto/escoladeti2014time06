function ListaPJController ($scope, bd) {
  
  $scope.pessoasJuridicas = bd.pessoasJuridicas;
  
  $scope.editarPessoaJuridica = function( indice ){
    bd.pessoaJuridica = $scope.pessoasJuridicas[indice];
    window.location = "#/pessoajuridica";  
  };

  $scope.delPessoaJuridica = function(index){
      $scope.pessoasJuridicas.splice(index,1);
  };

  $scope.novaPessoaJuridica = function(){
  	bd.pessoaJuridica = {};
  	window.location = "#/pessoajuridica"; 
  }

}