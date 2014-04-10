function CadastroUsuarioController( $scope, bd )
{
  $scope.usuario = bd.usuario || [];
  bd.usuarios = bd.usuarios || [];

  $scope.salvarUsuario = function(){
      bd.usuarios.push($scope.usuario);
  };

  $scope.id_temEspecial = 0;
  $scope.itensEspeciais = [];
  $scope.itemEspecial = null; 

  $scope.salvarItemEspecial = function(){

    if(!$scope.itemEspecial.id_temEspecial){
        $scope.id_temEspecial++;
        $scope.itemEspecial.id_temEspecial = $scope.id_temEspecial;
        $scope.itensEspeciais.push( $scope.itemEspecial );
    }
    $scope.itemEspecial = null;
  };

  $scope.editarItemEspecial = function( indice ){
    $scope.itemEspecial = $scope.itensEspeciais[indice];
  };

  $scope.delItemEspecial = function(index){
    $scope.itensEspeciais.splice(index,1);
  }; 

}