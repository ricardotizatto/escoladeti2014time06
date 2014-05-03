function CadastroBairroController( $scope, bd ){

  $scope.cidades = [
    { nome : "Astorga"  },
    { nome : "Maringá"  },
    { nome : "Santa Fé" },
    { nome : "Sarandi"  }
  ];

  $scope.faixasCeps = [
    { faixaCep : "01000-000 - 02000-000" },
    { faixaCep : "02001-000 - 03000-000" },
    { faixaCep : "03001-000 - 04001-000" },
    { faixaCep : "04001-000 - 05001-000" }
  ];

  $scope.bairro = bd.bairro || {};
  bd.bairros = bd.bairros || [];
  $scope.idBairro = 0;
  $scope.bairros = [];

  $scope.salvarBairro = function(){
    if(!$scope.bairro.idBairro){
        $scope.idBairro++;
        $scope.bairro.idBairro = $scope.idBairro;
        $scope.bairros.push( $scope.bairro );
        bd.bairros.push($scope.bairro);
    }
    $scope.bairro = {};
  };  
}