function ListaUsuarioController ($scope, bd) {
  $scope.usuarios = bd.usuarios;

  $scope.editarUsuario = function( indice ){
    bd.usuario = $scope.usuarios[indice];
    window.location = "#/cadastrousuario";  
  };

  $scope.delUsuario = function(index){
      $scope.usuarios.splice(index,1);
  }; 
}