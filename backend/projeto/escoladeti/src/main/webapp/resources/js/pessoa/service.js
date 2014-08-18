function PessoaFactory($resource) {
	return $resource("./rest/pessoas/:id/:acao/:pagina/:tipoPessoa/", {id: '@id'},{
		
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
	.factory('PessoaFactory', ['$resource', PessoaFactory]);