var controllers = angular.module('controllers');

function SolicitacaoController($scope, $location, $log, $routeParams, $http, Solicitacao) {
	
	var ItemCorrente = function () {
		this.outro = "";
		this.traducaoMaterial = "BRAILLE";
		this.livro = {};	
		this.status = 'ABERTO';
	};	
	
	$scope.itemCorrente = new ItemCorrente();	
	
	$scope.enviarSolicitacao = function () {
		$log.debug('enviando solicitacao');
		console.log($scope.solicitacao);
		$scope.solicitacao.$save();
	};
	
	$scope.editar = function(solicitacao) {
		$location.path('/cadastrosolicitacao/'+ solicitacao.id);
	};
	
	$scope.carregarSolicitacao = function () {
		$log.debug('carrgegando solicitacao x');
		
		if (!$routeParams.idSolicitacao) {
			
			$scope.solicitacao = new Solicitacao({
				ensino: 'FUNDAMENTAL',
				serie: '1-SERIE',
				itensSolicitacao : []
			});
			
			$log.debug('criando solicitacao', $scope.solicitacao);
			return;
		}
		
		$log.debug('buscando solicitacao', Solicitacao);
		Solicitacao.get({id: $routeParams.idSolicitacao}, function(solicitacao) {
			$scope.solicitacao = solicitacao;
			$scope.solicitacao.aluno = solicitacao.aluno ? solicitacao.aluno.id : null;
			$scope.solicitacao.nre = solicitacao.nre ? solicitacao.nre.id : null;
			$scope.solicitacao.municipio = solicitacao.municipio ? solicitacao.municipio.id : null;
			$scope.solicitacao.responsavel = solicitacao.responsavel ? solicitacao.responsavel.id : null;
		});
	};
	
	Solicitacao.paginar({pagina: 1}, function (pagina) {
		$scope.pagina = pagina;
	});
	
	$http({
		method: 'GET',
		url: './rest/pessoaFisicaSource/pessoaFisica/lista'			
	}).success(function (data) {
		$scope.pessoas = data;
	});
	
	$http({
		method: 'GET',
		url: './rest/cidadeSource/listar'			
	}).success(function (data) {
		$scope.cidades = data;
	});
	
	$http({
		method: 'GET',
		url: './rest/livroSource/livros'			
	}).success(function (data) {
		$scope.livros = data;
	});
	
	
	$scope.getDescricaoMaterial = function (item) {		
		item.livro = buscarLivro(item.idLivro);		
		if (item.livro)
			return item.livro.nome;
	};
	
	function buscarLivro(idLivro) {
		var selecionados = $.grep($scope.livros, function (item) {
    		return item.id == idLivro;
    	});
		return angular.copy(selecionados[0]);
	}
	
	$scope.novo = function () {
		$location.path('/cadastrosolicitacao');		
		$scope.solicitacao = new Solicitacao();
	};
	
	$scope.voltar = function(){
		$location.path('/listasolicitacoes');
	};
	
	$scope.adicionarMaterial = function () {
		$scope.solicitacao.itensSolicitacao.push($scope.itemCorrente);
		$scope.itemCorrente = new ItemCorrente();
	};
        
        $("#cep").mask("99999-999");
	
	$scope.getStatusItem = function (status) {
		console.log(item);
		switch (status) {
			case 'ABERTO':
				return 'warning';
			case 'ANDAMENTO':
				return 'primary';
			case 'CANCELADO':
				return 'danger';
		}
	};
	
}

controllers.controller('SolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$routeParams',
		 '$http',
		 'SolicitacaoFactory',
		 SolicitacaoController
		 ]);