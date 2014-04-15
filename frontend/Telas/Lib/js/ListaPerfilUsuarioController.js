'use strict';
function listaPerfilUsuarioController ($scope, bd) {

	$scope.perfilsDeUsuario = bd.perfilsDeUsuario;

	$scope.editarPerfilUsuario = function editarPerfilUsuario(indice) {
		bd.perfilDeUsuario = bd.perfilsDeUsuario[indice];
		bd.indicePerfilUsuario = indice;
		window.location = '#/cadastroperfilusuario';
	}

	$scope.novoPerfilUsuario = function() {
		bd.perfilUsuario = {};
		window.location = '#/cadastroperfilusuario';
	}
	
	$scope.excluirPerfilUsuario = function excluirPerfilUsuario(indice) {
		bd.perfilsDeUsuario.splice(indice,1);
	}

}