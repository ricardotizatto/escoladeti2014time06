function producaoController($scope) {
    console.log('carregando controller');
    
    $scope.novo = function() {
        window.location = '#/ordemproducaoparte';
    }
    
    $scope.novaOrdemProducao = function() {
        window.location = '#/ordemproducao';
    }

    $scope.editar = function() {
        window.location = '#/ordemproducaoparte';
    }
    
    $scope.editarOrdemProducao = function() {
        window.location = '#/ordemproducao';
    }
    
    $scope.deletar = function() {
        window.location = '#/ordemproducao';
    }
    
    $scope.deletarOrdemProducao = function() {
        window.location = '#/listaordemproducao';
    }

}