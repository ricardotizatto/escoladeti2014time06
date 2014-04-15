'use strict';

function perfilUsuarioController($scope, bd) {
	
	bd.perfilsDeUsuario = bd.perfilsDeUsuario || [];
	$scope.perfilDeusuario = bd.perfilDeusuario || {};
	$scope.telas = bd.telas || [];

	$scope.addPerfilUsuario = function addPerfilUsuario() {
		if (angular.isUndefined(bd.indicePerfilUsuario)) {
			bd.perfilsDeUsuario.push($scope.perfilDeusuario);
		}
		$scope.perfilDeusuario = {};
	}

	$scope.cancelarPerfilUsuario = function() {
		window.location = '#/listaperfilusuario';
	}
}