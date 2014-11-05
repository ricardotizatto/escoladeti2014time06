angular.module('services')
    .factory('VolumeFactory', ['$resource', VolumeFactory]);

function VolumeFactory($resource) {
    return $resource('./rest/volumes/:id/:acao', {id: '@id'},{
        update: {
            method: 'PUT'
        },

        marcarComoImpresso: {
            method: 'PUT',
            params: {
                acao: 'impresso'
            }
        },

        rejeitar: {
            method: 'PUT',
            params: {
                acao: 'rejeitado'
            }
        },

        marcarComoRevisado: {
            method: 'PUT',
            params: {
                acao: 'revisado'
            }
        },

        marcarComoEnviado: {
            method: 'PUT',
            params: {
                acao: 'enviado'
            }
        },

        reativar: {
            method: 'PUT',
            params: {
                acao: 'andamento'
            }
        },

        concluir: {
            method: 'PUT',
            params: {
                acao: 'conclusao'
            }
        }

    });
}