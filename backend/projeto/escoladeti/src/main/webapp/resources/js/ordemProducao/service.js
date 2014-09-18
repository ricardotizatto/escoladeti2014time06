angular.module('services')
    .factory('OrdemProducaoFactory', ['$resource', OrdemProducaoFactory]);

function OrdemProducaoFactory($resource) {
    return $resource('./rest/solicitacao-itens/:id/:acao', {

    });
};

