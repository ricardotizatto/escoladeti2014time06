function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:acao", {id: '@id'},{
		
		listar: {
			method: 'GET',
			params: {
				acao: 'listar'
			}
		}
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);