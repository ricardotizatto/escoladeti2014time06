'use strict;'

function telaController ($scope, bd) { 

	bd.telas = bd.telas || [];
	$scope.telas = bd.telas || {};
	$scope.tela = bd.tela || {};

	$scope.addTela = function addTela() {
		bd.telas.push($scope.tela);
		$scope.tela = {};
	}

	$scope.cancelarTela = function () {
		if (angular.isUndefined($scope.tela))
			bd.telas.push($scope.tela);
		window.location = '#/listatela';
	}
}