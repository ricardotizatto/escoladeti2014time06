function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:id/:acao", {id: '@id'},{
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);