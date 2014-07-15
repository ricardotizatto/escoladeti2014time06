var controllers = angular.module('controllers');

function SolicitacaoController($scope, $location, $log, $http) {
	var ItemCorrente = function () {
		this.outro = "";
		this.traducao = "BRAILLE";
		this.idMaterial = 0;
		this.livro = {};		
	};
	
	$log.debug('carregando solicitacao');
	$scope.solicitacao = {};
	$scope.itemCorrente = new ItemCorrente();
	$scope.solicitacao.itensMateriais = [];
	
	$http({
		method: 'GET',
		url: './rest/pessoaFisicaSource/pessoaFisica'			
	}).success(function (data) {
		$scope.pessoas = data;
	});
	
	$http({
		method: 'GET',
		url: './rest/cidadeSource/listar'			
	}).success(function (data) {
		$scope.cidades = data;
	});
	
	var Solicitacao = function () {		
	};	
	
	$scope.novo = function () {
		$location.path('/cadastrosolicitacao');		
		$scope.solicitacao = new Solicitacao();
	};
	
	$scope.voltar = function(){
		$location.path('/listasolicitacoes');
	};
	
	$scope.adicionarMaterial = function () {
		$scope.solicitacao.itensMateriais.push($scope.itemCorrente);
		$scope.itemCorrente = new ItemCorrente();
	};
	
}

controllers.controller('SolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$http',
		 SolicitacaoController
		 ]);