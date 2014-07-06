services = angular.module("services");

function DistritoService($http) {	
	console.log('carregando service distrito');
	return {
		
		deletar: function (distrito) {
			 return $http({
                 method: 'DELETE',
                 data: distrito,
                 url: './rest/distritoSource/distrito',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/distritoSource/distrito?q=' + filtro.toUpperCase());
		},
		
		buscar: function (distritoId) {
			return $http.get('./rest/distritoSource/distrito/' +  distritoId);
		},
		
		salvar: function (distrito) {
			return $http.post('./rest/distritoSource/distrito', {
				nome : distrito.nome.toUpperCase(),
				inicioVigencia: distrito.inicioVigencia,
				fimVigencia: distrito.fimVigencia,
				cidade : distrito.cidade,
				id: distrito.id
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/distritoSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/distritoSource/listar');
		}
	};
}

services.factory('distritoService', ['$http', DistritoService]);
