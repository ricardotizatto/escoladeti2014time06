function listaTelaController ($scope, bd){
	
	$scope.telas = bd.telas;

	$scope.editarTela = function (indice) {
		bd.tela = $scope.telas[indice];
		window.location = '#/cadastrotela';
		//$scope.telas.splice(indice,1);
	};

	$scope.novaTela = function () {
		bd.tela = {};
		window.location = '#/cadastrotela';
	}

	$scope.deletarTela = function (indice){
		$scope.telas.splice(indice,1);
	}
}