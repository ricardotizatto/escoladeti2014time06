function AcompanhamentoSolicitacaoFactory($resource) {
	return $resource("./rest/acompanhamentosolicitacoes/:id/:acao/:pagina", {id: '@id'},{
		
            update: {method: 'PUT'},
            listartodos: {
                method: 'GET',
                isArray: true,
                params: {
                        acao: 'listartodos'
                }
            }
	});
}

angular.module('services')
	.factory('AcompanhamentoSolicitacaoFactory', ['$resource', AcompanhamentoSolicitacaoFactory]);