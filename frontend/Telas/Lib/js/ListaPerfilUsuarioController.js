'use strict';
function listaPerfilUsuarioController ($scope, bd) {

	$scope.perfilsUsuario = bd.perfilsDeUsuario;

	$scope.editarPerfilUsuario = function editarPerfilUsuario() {
		alert('Editado');
		console.log('Controler Lista iniciado');
	}
	
	$scope.excluirPerfilUsuario = function excluirPerfilUsuario() {
		alert('Excluido');
		console.log('Controler Lista iniciado');
	}

}