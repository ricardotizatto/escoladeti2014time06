function CaracteristicaFactory($resource){
	return $resource('./rest/caracteristica',{
		query : {
			method : 'GET',
			isArray : true
		}
	});
	
}

angular.module('services').factory('CaracteristicaFactory',['$resource',CaracteristicaFactory]);