function CadastroPaisController( $scope, bd ){

  $scope.pais = bd.pais || {};
  bd.paises = bd.paises || [];

  $scope.idPais = 0;
  $scope.paises = [];

  $scope.salvarPais = function(){

    if(!$scope.pais.idPais){
        $scope.idPais++;
        $scope.pais.idPais = $scope.idPais;
        $scope.paises.push( $scope.pais );
        bd.paises.push($scope.pais);
    }
    $scope.pais = {};
  };
  
}