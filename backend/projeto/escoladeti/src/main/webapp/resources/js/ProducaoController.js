function producaoController($scope) {
    console.log('carregando controller');
    
    $scope.novo = function() {
        window.location = '#/ordemproducaoparte';
    }

    $scope.editar = function() {
        window.location = '#/ordemproducaoparte';
    }

}