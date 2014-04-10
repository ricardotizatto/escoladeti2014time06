function CadastroEstadoController( $scope, bd ){

  $scope.estado = bd.estado || [];
  bd.estados = bd.estados || [];

  $scope.id_Estado = 0;
  $scope.estados = [];
  $scope.estado = {}; 

  $scope.salvarEstado = function(){

    if(!$scope.estado.id_Estado){
        $scope.id_Estado++;
        $scope.estado.id_Estado = $scope.id_Estado;
        $scope.estados.push( $scope.estado );
        bd.estados.push($scope.estado);
    }
    $scope.estado = {};
  };
  
}