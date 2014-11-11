var controllers = angular.module('controllers');

function RelatorioAssociadoController($scope, $location, PessoaFactory) {

	$scope.buscaAssociados = function() {
		PessoaFactory.listaTodosAssociados(function(pessoas) {
			$scope.pessoas = pessoas.map(function(pessoa) {
				return {
					nome : pessoa.nome,
					id : pessoa.id
				};
			});
		});
	}
	
	$scope.limparCampos = function(pesquisa){
		$scope.pesquisa = {};
	}
}

controllers.controller('RelatorioAssociadoController', [ '$scope', '$location',
		'PessoaFactory', RelatorioAssociadoController ]);