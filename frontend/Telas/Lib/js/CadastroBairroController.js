function CadastroBairroController( $scope, bd ){

  $scope.cidades = [
    { nome : "Astorga"  },
    { nome : "Maringá"  },
    { nome : "Santa Fé" },
    { nome : "Sarandi"  }
  ];

  $scope.faixasCeps[
    { faixa : "01000-000 - 02000-000" },
    { faixa : "02001-000 - 03000-000" },
    { faixa : "03001-000 - 04001-000" }
  ];

  $scope.bairro = bd.bairro || {};
  bd.bairros = bd.bairros || [];
  $scope.idBairro = 0;
  $scope.bairros = [];

  $scope.salvarBairro = function(){
    if(!$scope.bairro.idBairro){
        $scope.idBairro++;
        $scope.bairros.push( $scope.bairro );
        bd.bairros.push($scope.bairro);
    }
    $scope.bairro = {};
  };  
}