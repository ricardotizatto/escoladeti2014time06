'use strict';

function perfilUsuarioController($scope, $http) {
	console.log('Controller funcionando');
	
	bd.perfilsDeUsuario = bd.perfilsDeUsuario || [];
	$scope.telas = bd.telas;
	$scope.perfilsUsuario = bd.perfilsDeUsuario;

	$scope.addPerfilUsuario = function addPerfilUsuario() {
		bd.perfilsDeUsuario.push($scope.perfilUsuario);
		$scope.perfilUsuario = {};
	}
}