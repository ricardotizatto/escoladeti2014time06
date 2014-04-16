function ListaPJController ($scope, bd) {
  $scope.pessoasjuridicas = bd.pessoasjuridicas;

  $scope.editarPessoaJuridica = function( indice ){
    bd.pessoajuridica = $scope.pessoasjuridicas[indice];
    window.location = "#/pessoajuridica";  
  };

  $scope.delPessoaJuridica = function(index){
      $scope.pessoasjuridicas.splice(index,1);
  };

  $scope.novaPessoaJuridica = function(){
  	bd.pessoajuridica = {};
  	window.location = "#/pessoajuridica"; 
  }

}