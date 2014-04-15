function ListaPessoaFisicaController ($scope, bd) {
  $scope.pessoas = bd.pessoas;

  $scope.editarPessoaFisica = function(indice){
    bd.pessoa = $scope.pessoas[indice];
    window.location = "#/pessoafisica"; 
    $scope.pessoas.splice(indice,1); 
  };

  $scope.delPessoaFisica = function(indice){
      $scope.pessoas.splice(indice,1);
 
  }; 
}