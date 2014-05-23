function CadastroParticipanteController( $scope, bd ){
  
  $scope.perfisDeAcesso = [
    { nome : "Gerente"    },
    { nome : "Vendedor"   },
    { nome : "Caixa"      },
    { nome : "Estagiario" }
  ];

  $scope.usuario = bd.usuario || {};
  bd.usuarios = bd.usuarios || [];

  $scope.id_Usuario = 0;
  $scope.usuarios = [];

  $scope.salvarUsuario = function(){

    if(!$scope.usuario.id_Usuario){
        $scope.id_Usuario++;
        $scope.usuario.id_Usuario = $scope.id_Usuario;
        $scope.usuarios.push( $scope.usuario );
        bd.usuarios.push($scope.usuario);
    }
    $scope.usuario = {};
  };

  $scope.id_temEspecial = 0;
  $scope.itensEspeciais = [];
  $scope.itemEspecial = {}; 

  $scope.salvarItemEspecial = function(){

    if(!$scope.itemEspecial.id_temEspecial){
        $scope.id_temEspecial++;
        $scope.itemEspecial.id_temEspecial = $scope.id_temEspecial;
        $scope.itensEspeciais.push( $scope.itemEspecial );
    }
    $scope.itemEspecial = {};
  };

  $scope.editarItemEspecial = function( indice ){
    $scope.itemEspecial = $scope.itensEspeciais[indice];
  };

  $scope.delItemEspecial = function(index){
    $scope.itensEspeciais.splice(index,1);
  }; 

}