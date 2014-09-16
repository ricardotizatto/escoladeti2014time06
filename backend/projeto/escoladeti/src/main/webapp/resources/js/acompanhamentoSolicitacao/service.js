function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:id/:acao", {id: '@id'},{
	    	
        update: {method: 'PUT'},    
        listarPesquisa: {
                method: 'POST',
                params: {
                    acao: 'listarPesquisa'
                }
            }
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);