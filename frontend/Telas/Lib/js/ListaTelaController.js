function listaTelaController ($scope, bd){
	
	$scope.telas = bd.telas;
	bd.indiceTela = -1;

	$scope.editarTela = function (indice) {
		bd.tela = $scope.telas[indice];
		bd.indiceTela = indice;
		window.location = '#/cadastrotela';
	};

	$scope.novaTela = function () {
		bd.tela = {};
		window.location = '#/cadastrotela';
	}

	$scope.deletarTela = function (indice){
		$scope.telas.splice(indice,1);
	}
}