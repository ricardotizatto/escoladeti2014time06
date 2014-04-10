'use strict;'

function telaController ($scope, bd) {
	console.log(bd.telas);

	bd.telas = bd.telas || [];
	$scope.telas = bd.telas;

	$scope.addTela = function addTela() {
		bd.telas.push($scope.tela);
		$scope.tela = {};
	}

}