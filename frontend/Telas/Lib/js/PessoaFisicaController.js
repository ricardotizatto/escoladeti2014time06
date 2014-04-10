function PessoaFisicaController( $scope, bd )
{
$scope.pessoas = [];
$scope.pessoa = null;

bd.pessoas = bd.pessoas || [];


$scope.getPessoa = function(cpf){
    for(i=0;i<$scope.pessoas.length;i++){
        if(cpf == $scope.pessoas[i].cpf){
          return $scope.pessoa =  $scope.pessoas[i];
        }
    }
    $scope.pessoa = null;
    return false;
}

$scope.getPessoas = function(){
  var array = [];
  for(i=0;i<$scope.pessoas;i++)
    array.push(i);
  return array;
}

$scope.addPessoa = function(){
  
	bd.pessoas.push($scope.pessoa);
	$scope.pessoa = null;      
};

$scope.delPessoa = function(index){
  $scope.pessoas.splice(index,1);
}; 

$scope.idTelefone = 0;
$scope.telefones = [];
$scope.telefone = null; 

$scope.salvarTelefone = function(){

  if(!$scope.telefone.idTelefone){
      $scope.idTelefone++;
      $scope.telefone.idTelefone = $scope.idTelefone;
      $scope.telefones.push( $scope.telefone );
  }
  $scope.telefone = null;
};

$scope.editarTelefone = function( indice ){
  $scope.telefone = $scope.telefones[indice];
};

$scope.addTelefone = function(){
  $scope.telefones.push($scope.telefone);
  $scope.telefone = null;      
};


$scope.delTelefone = function(index){
  $scope.telefones.splice(index,1);
}; 

$scope.idEndereco = 0;
$scope.enderecos = [];
$scope.endereco = null; 

$scope.salvarEndereco = function(){

  if(!$scope.endereco.idEndereco){
      $scope.idEndereco++;
      $scope.endereco.idEndereco = $scope.idEndereco;
      $scope.enderecos.push( $scope.endereco );
  }
  $scope.endereco = null;
};

$scope.editarEndereco = function( indice ){
  $scope.endereco = $scope.enderecos[indice];
};

$scope.addEndereco = function(){
  $scope.enderecos.push($scope.endereco);
  $scope.endereco = null;      
};

$scope.delEndereco = function(index){
  $scope.enderecos.splice(index,1);
};       
}