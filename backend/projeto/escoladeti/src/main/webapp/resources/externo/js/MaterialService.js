angular.module('services')
        .factory("MaterialFactory", ["$resource", MaterialFactory ]);

function MaterialFactory($resource) {
    return $resource("public/rest/:id/:acao/:pagina/:tipo", {id: '@id'},{
		
        buscaMateriaisProduzidos: {
            method: 'GET',
            params: {
                acao: 'materiaisproduzidos'
            }
        }
        
    });   
}