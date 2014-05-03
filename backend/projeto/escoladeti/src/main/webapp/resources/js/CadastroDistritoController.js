function CadastroDistritoController( $scope, bd ){

  $scope.cidades = [
    { nome : "Astorga"  },
    { nome : "Maringá"  },
    { nome : "Santa Fé" },
    { nome : "Sarandi"  }
  ];

  $scope.distrito = bd.distrito || {};
  bd.distritos = bd.distritos || [];

  $scope.id_Distrito = 0;
  $scope.distritos = [];

  $scope.salvarDistrito = function(){

    if(!$scope.distrito.id_Distrito){
        $scope.id_Distrito++;
        $scope.distrito.id_Distrito = $scope.id_Distrito;
        $scope.distritos.push( $scope.distrito );
        bd.distritos.push($scope.distrito);
    }
    $scope.distrito = {};
  };
  
}