function PessoaFactory($resource) {
	return $resource("./rest/pessoas/:id/:acao/:pagina/:busca", {id: '@id'},{
		
		update: {method: 'PUT'},
		paginarFisica: {
			method: 'GET',
			params: {
				acao: 'paginarFisica'
			}
		},
                paginarAluno: {
                    method: 'GET',
                    params: {
                        acao: 'paginarAluno'
                    }
                },
                paginarJuridica: {
                        method: 'GET',
                        params: {
                                acao: 'paginarJuridica'
                         }
                },
                buscarFisica: {
                    method: 'GET',
                    params: {
                        acao: 'buscarFisica'
                    }
                },
                buscarAluno: {
                    method: 'GET',
                    params: {
                        acao: 'buscarAluno'
                    }
                },
                buscarJuridica: {
                    method: 'GET',
                    params: {
                        acao: 'buscarJuridica'
                    }
                }
                
	});
}

angular.module('services')
	.factory('PessoaFactory', ['$resource', PessoaFactory]);