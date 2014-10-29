function PessoaFactory($resource) {
    return $resource("./rest/pessoas/:id/:acao/:pagina/:tipo", {id: '@id'},{
		
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
                acao: 'paginarJuridica',
                busca : $resource("busca")
            }
        },
        buscarFisica: {
            method: 'GET',
            params: {
                acao: 'buscarFisica',
                busca : $resource("busca")
            }
        },
        buscarPessoa: {
            method: 'GET',
            params: {
                acao: 'buscarPessoa'
            }
        },
        buscarAluno: {
            method: 'GET',
            params: {
                acao: 'buscarAluno',
                busca : $resource("busca")
            }
        },
        buscarJuridica: {
            method: 'GET',
            params: {
                acao: 'buscarJuridica'
            }
        },

        listarAlunos: {
            method: 'GET',
            isArray: true,
            params: {
                acao: 'alunos'
            }
            },

        listarPessoasFisicas: {
            method: 'GET',
            isArray: true,
            params: {
                acao: 'fisicas'
            }
        },
        
        listarTodasPessoas:{
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