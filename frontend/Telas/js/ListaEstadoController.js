function ListaEstadoController ($scope, bd) {
  $scope.estados = bd.estados;

  $scope.editarEstado = function( indice ){
    bd.estado = $scope.estados[indice];
    window.location = "#/cadastroestado";  
  };

  $scope.delEstado = function(index){
      $scope.estados.splice(index,1);
  };

  $scope.novoEstado = function(){
  	bd.estado = {};
  	window.location = "#/cadastroestado"; 
  }

}