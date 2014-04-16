function CadastroPJController( $scope, bd ){

  $scope.pessoa = bd.pessoa || {};
  bd.pessoas = bd.pessoas || [];

  $scope.idPessoa = 0;
  $scope.pessoas = [];

  $scope.salvarPessoa = function(){

    if(!$scope.pessoa.idPessoa){
        $scope.idPessoa++;
        $scope.pessoa.idPessoa = $scope.idPessoa;
        $scope.pessoas.push( $scope.pessoa );
        bd.pessoas.push( $scope.pessoa );
    }
    $scope.pessoa = {};
  };

  $scope.idTelefone = 0;
  $scope.telefones = [];
  $scope.telefone = {}; 

  $scope.salvarTelefone = function(){

    if(!$scope.telefone.idTelefone){
        $scope.idTelefone++;
        $scope.telefone.idTelefone = $scope.idTelefone;
        $scope.telefones.push( $scope.telefone );
    }
    $scope.telefone = {};
  };

  $scope.editarTelefone = function( indice ){
    $scope.telefone = $scope.telefones[indice];
  };

  $scope.addTelefone = function(){
    $scope.telefones.push($scope.telefone);
    $scope.telefone = {};      
  };


  $scope.delTelefone = function(index){
    $scope.telefones.splice(index,1);
  }; 

  $scope.idEndereco = 0;
  $scope.enderecos = [];
  $scope.endereco = {}; 

  $scope.salvarEndereco = function(){

    if(!$scope.endereco.idEndereco){
        $scope.idEndereco++;
        $scope.endereco.idEndereco = $scope.idEndereco;
        $scope.enderecos.push( $scope.endereco );
    }
    $scope.endereco = {};
  };

  $scope.editarEndereco = function( indice ){
    $scope.endereco = $scope.enderecos[indice];
  };

  $scope.addEndereco = function(){
    $scope.enderecos.push($scope.endereco);
    $scope.endereco = {};      
  };

  $scope.delEndereco = function(index){
    $scope.enderecos.splice(index,1);
  };

  jQuery(function($) {
      $.mask.definitions['~']='[+-]';
      $(".mascaraCNPJ").mask("99.999.999/9999-99");
      $(".telefone").mask("(99) 9999-9999?9");
  });
       
}