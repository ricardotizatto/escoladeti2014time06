'use strict;'

function telaController ($scope, bd) { 

	bd.telas = bd.telas || [];
	$scope.tela = bd.tela || {};

	$scope.addTela = function addTela() {
		if (bd.indiceTela == -1){
			bd.telas.push($scope.tela);
		}
		$scope.tela = {};
	}

	$scope.cancelarTela = function () {
		window.location = '#/listatela';
	}
}