function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:id/:acao", {id: '@id'},{
	    	
        update: {method: 'PUT'},    
        listarPesquisa: {
                method: 'POST',
                params: {
                    acao: 'listarPesquisa'
                }
            },
            listarItens: {
                method: 'GET',
                params: {
                    acao: 'listarItens' 
                }
            }
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);