angular.module('services')
    .factory('OrdemProducaoFactory', ['$resource', OrdemProducaoFactory]);

function OrdemProducaoFactory($resource) {
    return $resource('./rest/solicitacao-itens/:id/:acao/:idVolume', {id: '@id'}, {
        produzir: {
            method: "POST",
            params: {
                acao: 'produzir'
            }
        },
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

        enviarVolume: {
            method: 'PUT',
            params: {
                acao: 'solicitacao-volume'
            }
        }
    });
};

