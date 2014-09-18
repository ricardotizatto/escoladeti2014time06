angular.module('services')
    .factory('VolumeFactory', ['$resource', VolumeFactory]);

function VolumeFactory($resource) {
    return $resource('./rest/volumes/:id/:acao', {id: '@id'},{
        update: {
            method: 'PUT'
        }
    });
}