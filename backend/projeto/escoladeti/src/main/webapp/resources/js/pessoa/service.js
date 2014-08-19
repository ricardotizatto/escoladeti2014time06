function PessoaFactory($resource) {
	return $resource("./rest/pessoas/:id/:acao/:pagina", {id: '@id'},{
		
		update: {method: 'PUT'},
		paginarFisica: {
			method: 'GET',
			params: {
				acao: 'paginarFisica'
			}
		},
                paginarJuridica: {
                        method: 'GET',
                        params: {
                                acao: 'paginarJuridica'
                         }
                }
                
	});
}

angular.module('services')
	.factory('PessoaFactory', ['$resource', PessoaFactory]);