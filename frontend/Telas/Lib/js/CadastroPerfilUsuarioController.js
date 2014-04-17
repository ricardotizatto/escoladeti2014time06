'use strict';

function cadastroPerfilUsuarioController($scope, bd) {
	
	bd.perfilsDeUsuario = bd.perfilsDeUsuario || [];
	$scope.perfilDeUsuario = bd.perfilDeUsuario || {};
	$scope.telas = bd.telas || [];

	$scope.addPerfilUsuario = function addPerfilUsuario() {
		if (bd.indicePerfilUsuario == -1) {
			bd.perfilsDeUsuario.push($scope.perfilDeUsuario);
		}
		$scope.perfilDeUsuario = {};
	}

	$scope.cancelarPerfilUsuario = function() {
		window.location = '#/listaperfilusuario';
	}
}