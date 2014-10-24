var controllers = angular.module('controllers');
            
            
function MaterialController($scope, Material) {    
    console.log('Carregando MaterialController'); 
    
    $scope.getMateriaisProduzidos = function (pageNumber){
        
        console.log('Carregando MaterialController ');
        Material.buscaMateriaisProduzidos({pagina: pageNumber}, function(materiaisProduzidos) {
            $scope.materiaisProduzidos = materiaisProduzidos;
            console.log('MaterialController ' + materiaisProduzidos);
        });
    }            

}

controllers.controller( 'MaterialController',
                [ 
                '$scope',
                'MaterialFactory',
                MaterialController]);
