services = angular.module("services");

function ChamadaService($http) {	
	console.log('carregando service chamada');
	return {
		
		/*buscar: function (periodoId) {
			return $http.get('./rest/chamadaSource/periodo/' +  periodoId);
		},*/
		listar: function (nrPagina) {
			return $http.get('./rest/chamadaSource/listar/pag/' + nrPagina);
		}
	};
}

services.factory('chamadaService', ['$http', ChamadaService]);

