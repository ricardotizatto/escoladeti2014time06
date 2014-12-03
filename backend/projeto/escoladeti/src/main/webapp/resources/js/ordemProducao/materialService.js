angular.module('services')
    .factory('MaterialFactory', ['$resource', MaterialFactory]);

function MaterialFactory($resource) {
    return $resource('./rest/solicitacoes-volume/:id', {id: '@id'}, {
        update: {
            method: 'PUT'
        }
    });
}

