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
        
        listarTodasPessoaFisicas:{
            method: 'GET',
            isArray: true,
            params: {
                acao: 'todasPessoas'
            }
        },
        
        paginar : {
            method : 'GET',
            isArray : true
        },
        
        listaTodasPessoas : {
        	method : 'GET',
        	isArray : true,
        	params : {
        		acao : 'todasPessoas'
        	}
        },
        obterEnderecoDaEscola : {
        	method : 'GET',
        	params : {
        		acao : 'obterEnderecoDaEscola'
        	}
        },
        listaTodosAssociados : {
        	method : 'GET',
        	isArray : true,
        	params : {
        		acao : 'todosAssociados'
        	}
        },
        listarTodasAsEscolas : {
        	method : 'GET',
        	isArray : true,
        	params : {
        		acao : 'listarTodasAsEscolas'
        	}
        }
                
    });
}

angular.module('services')
	.factory('PessoaFactory', ['$resource', PessoaFactory]);