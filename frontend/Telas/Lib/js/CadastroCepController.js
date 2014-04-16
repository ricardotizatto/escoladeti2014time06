function CadastroCepController( $scope, bd ){

  $scope.logradouros = [
    { nome : "Av. Brasil"     },
    { nome : "Av. São Paulo"  },
    { nome : "Av. Tiradentes" },
    { nome : "Rua Londrina"   }
  ];

  $scope.bairros = [
    { nome : "Zona 01" },
    { nome : "Zona 02" },
    { nome : "Zona 03" },
    { nome : "Zona 04" }
  ];

  $scope.cep = bd.cep || {};
  bd.ceps = bd.ceps || [];
  $scope.idCep = 0;
  $scope.ceps = [];

  $scope.salvarCep = function(){
    if(!$scope.cep.idCep){
        $scope.idCep++;
        $scope.cep.idCep = $scope.idCep;
        $scope.ceps.push( $scope.cep );
        bd.ceps.push($scope.cep);
    }
    $scope.cep = {};
  };  

  jQuery(function($) {
      $.mask.definitions['~']='[+-]';
      $(".mascaraCep").mask("99999-999");
  });

}

