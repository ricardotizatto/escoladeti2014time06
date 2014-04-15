'use strict';

function perfilUsuarioController($scope, bd) {
	
	bd.perfilsDeUsuario = bd.perfilsDeUsuario || [];
	$scope.perfilDeUsuario = bd.perfilDeUsuario || {};
	$scope.telas = bd.telas || [];

	$scope.addPerfilUsuario = function addPerfilUsuario() {
		if (angular.isUndefined(bd.indicePerfilUsuario)) {
			bd.perfilsDeUsuario.push($scope.perfilDeUsuario);
		}
		$scope.perfilDeUsuario = {};
	}

	$scope.cancelarPerfilUsuario = function() {
		window.location = '#/listaperfilusuario';
	}
}