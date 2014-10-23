var services = angular.module('services');

function EstadoService($http) {
    return {
        buscar: function(eventoId) {
            return $http.get('./public/rest/evento' + eventoId);
        },
        buscarPorNome: function(filtro) {
            return $http.get('./public/rest/evento?q=' + filtro.toUpperCase());
        },
        listar: function(nrPagina) {
            return $http.get('./public/rest/evento/' + nrPagina);
        },
        buscarTodos: function () {
			return $http.get('./public/rest/evento');
		},        
        
    }
    
}