function producaoController($scope) {
    console.log('carregando controller');
    
    $scope.novo = function() {
        window.location = '#/ordemproducaoparte';
    };
    
    $scope.novaOrdemProducao = function() {
        window.location = '#/ordemproducao';
    };

    $scope.editar = function() {
        window.location = '#/ordemproducaoparte';
    };
    
    $scope.editarOrdemProducao = function() {
        window.location = '#/ordemproducao';
    };
    
    $scope.deletar = function() {
        window.location = '#/ordemproducao';
    };
    
    $scope.deletarOrdemProducao = function() {
        window.location = '#/listaordemproducao';
    };
    
    $scope.getStatus = function(status) {
        switch (status) {
            case "e":
                return "label-success";
                break;
            case "f":
                return "label-warning";
                break;
            case "r":
                return "label-danger";
                break;    
            default:     
                return "label-default";
        }
    };
}