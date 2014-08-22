function BuscaCepFactory($resource) {
    return $resource("./rest/cepSource/cep/:cep", {cep: '@cep'}, {
    });
}

angular.module('services')
        .factory('BuscaCepFactory', ['$resource', BuscaCepFactory]);