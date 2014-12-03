angular.module('services')
    .factory('OrdemProducaoFactory', ['$resource', OrdemProducaoFactory]);

function OrdemProducaoFactory($resource) {
    return $resource('./rest/solicitacao-itens/:id/:acao/:idVolume/:acaoVolume', {id: '@id'}, {

        cancelar: {
            method: "POST",
            params: {
                acao: 'cancelar'
            }
        },
        finalizar: {
            method: "POST",
            params: {
                acao: 'finalizacao'
            }
        },
        sugerir: {
            method: 'GET',
            params: {
                acao: 'sugestao'
            }
        },

        marcarImpresso: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume',
                acaoVolume: 'impresso'
            }
        },

        marcarRevisado: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume',
                acaoVolume: 'revisado'
            }
        },

        marcarRejeitado: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume',
                acaoVolume: 'rejeitado'
            }
        },

        marcarEnviado: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume',
                acaoVolume: 'enviado'
            }
        },

        reativar: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume',
                acaoVolume: 'reativacao'
            }
        }
    });
};

