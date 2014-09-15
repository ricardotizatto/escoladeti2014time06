function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:id/:acao/:pagina", {id: '@id'},{
		
            listarPesquisa: {
                method: 'GET',
                isArray: true,
                acao: 'listarpesquisa'
            }
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);