services = angular.module("services");

function ItemAcessoService($http) {	
	console.log('carregando service item de acesso');
	return {
		
		deletar: function (itemAcesso) {
			 return $http({
                 method: 'DELETE',
                 data: itemAcesso,
                 url: './rest/itemAcessoSource/itemAcesso',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/itemAcessoSource/itemAcesso?q=' + filtro.toUpperCase());
		},
		
		buscar: function (itemAcessoId) {
			return $http.get('./rest/itemAcessoSource/itemAcesso/' +  itemAcessoId);
		},
		
		salvar: function (itemAcesso) {
			return $http.post('./rest/itemAcessoSource/itemAcesso', {
				nomeComponente: itemAcesso.nomeComponente.toUpperCase()
				
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/itemAcessoSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/itemAcessoSource/listar');
		}
	};
}

services.factory('itemAcessoService', ['$http', ItemAcessoService]);

