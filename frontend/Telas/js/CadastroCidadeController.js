function CadastroCidadeController( $scope, bd ){

  $scope.estados = [
    { nome : "Paraná"},
    { nome : "Santa Catarina"},
    { nome : "Rio de Janeiro"},
    { nome : "São Paulo"}
  ]; 

  $scope.cidade = bd.cidade || {};
  bd.cidades = bd.cidades || [];

  $scope.id_Cidade = 0;
  $scope.cidades = [];

  $scope.salvarCidade = function(){

    if(!$scope.cidade.id_Cidade){
        $scope.id_Cidade++;
        $scope.cidade.id_Cidade = $scope.id_Cidade;
        $scope.cidades.push( $scope.cidade );
        bd.cidades.push($scope.cidade);
    }
    $scope.cidade = {};
  };
  
}