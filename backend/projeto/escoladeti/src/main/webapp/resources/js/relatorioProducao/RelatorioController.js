var controllers = angular.module('controllers');

function RelatorioProducaoController($scope, $location, $http) {
	var baseUrl = './relatorio/producao';
	var method = 'GET';
	
	$scope.limparCampos = function(pesquisa){
		$scope.pesquisa = {};
	}
}

controllers.controller('RelatorioProducaoController', [ '$scope', '$location',
		'PessoaFactory', RelatorioProducaoController ]);