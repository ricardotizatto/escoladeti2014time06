function PessoaFactory($resource) {
	return $resource("./rest/pessoa/:id/:acao/:pagina", {id: '@id'},{
		
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