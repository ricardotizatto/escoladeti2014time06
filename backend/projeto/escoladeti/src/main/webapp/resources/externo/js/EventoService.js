angular.module('services')
        .factory("EventoFactory", ["$resource" ,EventoFactory ]);

function EventoFactory($resource) {
    return $resource("./rest/eventoSource/:id/:acao/:pagina/:tipo", {id: '@id'},{
		
        update: {method: 'PUT'},
        buscaEventos: {
                method: 'GET',
                params: {
                        acao: 'evento'
                }
        }
        
    });   
}