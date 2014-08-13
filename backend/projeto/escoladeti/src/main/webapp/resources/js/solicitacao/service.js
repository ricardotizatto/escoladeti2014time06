function SolicitacaoFactory($resource) {
	return $resource("./rest/solicitacoes/:id/:acao/:pagina", {id: '@id'},{
		
		update: {method: 'PUT'},
		paginar: {
			method: 'GET',
			params: {
				acao: 'paginar'
			}
		}
	});
}

angular.module('services')
	.factory('SolicitacaoFactory', ['$resource', SolicitacaoFactory]);