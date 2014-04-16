'use strict';
function listaPerfilUsuarioController ($scope, bd) {

	$scope.perfilsDeUsuario = bd.perfilsDeUsuario;
	bd.indicePerfilUsuario = -1;

	$scope.editarPerfilUsuario = function editarPerfilUsuario(indice) {
		bd.perfilDeUsuario = bd.perfilsDeUsuario[indice];
		bd.indicePerfilUsuario = indice;
		window.location = '#/cadastroperfilusuario';
	}

	$scope.novoPerfilUsuario = function() {
		bd.perfilDeUsuario = {};
		window.location = '#/cadastroperfilusuario';
	}
	
	$scope.excluirPerfilUsuario = function excluirPerfilUsuario(indice) {
		bd.perfilsDeUsuario.splice(indice,1);
	}

}