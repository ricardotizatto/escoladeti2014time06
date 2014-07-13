services = angular.module("services");

function CidadeService($http) {	
	console.log('carregando service cidade');
	return {
		
		deletar: function (cidade) {
			 return $http({
                 method: 'DELETE',
                 data: cidade,
                 url: './rest/cidadeSource/cidade',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/cidadeSource/cidade?q=' + filtro.toUpperCase());
		},
		
		buscar: function (cidadeId) {
			return $http.get('./rest/cidadeSource/cidade/' +  cidadeId);
		},
		
		salvar: function (cidade) {
			return $http.post('./rest/cidadeSource/cidade', {
				nome: cidade.nome.toUpperCase(),
				fundacao: cidade.fundacao,
				unidadeFederativa: cidade.unidadeFederativa,
				id: cidade.id
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/cidadeSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/cidadeSource/listar');
		}
	};
}

services.factory('cidadeService', ['$http', CidadeService]);
