function CaracteristicaFactory($resource) {
  return $resource('./rest/caracteristica/:tipo', {
//    query: {
//      method: 'GET',
//      isArray : true
//    }
  });

}

angular.module('services').factory('CaracteristicaFactory', ['$resource', CaracteristicaFactory]);