var controllers = angular.module('controllers');
            
            
function MaterialController($scope, Material) {    
    console.log('Carregando MaterialController'); 
    
    $scope.teste = 'teste acesso';
    
    $scope.getMateriaisProduzidos = function (pageNumber){
        
        console.log('Carregando MaterialController ');
        Material.buscaMateriaisProduzidos({pagina: pageNumber}, function(materiaisProduzidos) {
            $scope.materiaisProduzidos = JSON.stringify(materiaisProduzidos);
            console.log('MaterialController $scope: ' + $scope.materiaisProduzidos);
        });
    }            

}

controllers.controller( 'MaterialController',
                [ 
                '$scope',
                'MaterialFactory',
                MaterialController]);
