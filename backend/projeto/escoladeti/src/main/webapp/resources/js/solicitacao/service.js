function SolicitacaoFactory($resourse) {
	return $resourse("./rest/solicitacoes/:id/:acao/:pagina", {id: '@id'},{
		
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