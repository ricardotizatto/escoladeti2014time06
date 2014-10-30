function PessoaFactory($resource) {
    return $resource("./rest/pessoas/:id/:acao/:pagina/:tipo", {id: '@id'},{
    	
    	save : {method : 'POST'},
		
        update: {method: 'PUT'},

        buscarPessoa: {
            method: 'GET',
            params: {
                acao: 'buscarPessoa'
            }
        },
        
        listarTodas:{
            method: 'GET',
            isArray: true,
            params: {
                acao: 'todasPessoas'
            }
        },
        
        paginar : {
            method : 'GET',
            isArray : true
        }
                
    });
}

angular.module('services')
	.factory('PessoaFactory', ['$resource', PessoaFactory]);