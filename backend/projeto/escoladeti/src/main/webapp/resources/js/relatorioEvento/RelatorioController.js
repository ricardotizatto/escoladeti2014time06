var controllers = angular.module('controllers');

function RelatorioEventoController($scope, $location, $http) {
	var baseUrl = './relatorio/eventos';
	var method = 'GET';
	
	$scope.buscaEventos = function() {
		var url = baseUrl + '/comParticipantes';
		$http({
			url : url,
			method : method
		})
		.success(function(data){
			$scope.eventos = data.map(function(item){
				return {
					titulo : item.titulo,
					id : item.id
				}
			});
		});
	}
	
	$scope.limparCampos = function(pesquisa){
		$scope.pesquisa = {};
	}
}

controllers.controller('RelatorioAssociadoController', [ '$scope', '$location',
		'PessoaFactory', RelatorioAssociadoController ]);