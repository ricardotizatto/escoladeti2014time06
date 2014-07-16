var controllers = angular.module('controllers');

function SolicitacaoController($scope, $location, $log, $http, $routeParams) {
	var $this = this;
	
	
	var ItemCorrente = function () {
		this.outro = "";
		this.traducaoMaterial = "BRAILLE";
		this.idMaterial = 0;
		this.livro = {};	
	};
	
	var Solicitacao = function () {
		this.id = 0;
		this.ensino = 'FUNDAMENTAL';
		this.serie = '1-SERIE';
		this.cep = '';
		this.numeroEndereco = 0;
		this.escola = '';
		this.endereco = '';
		this.itensSolicitacao = [];
	};	
	
	$log.debug('carregando solicitacao');
	
	$scope.itemCorrente = new ItemCorrente();	
	
	$scope.enviarSolicitacao = function () {
		var solicitacao = $scope.solicitacao;
		var itens = [];
		
		for (var i in solicitacao.itensSolicitacao) {
			itens.push({
				traducaoMaterial: solicitacao.itensSolicitacao[i].traducaoMaterial,
				livro:  solicitacao.itensSolicitacao[i].livro,
				outro:  solicitacao.itensSolicitacao[i].outro
			});
		}
		
		$http({
			method : 'POST',
			url: './rest/solicitacaoResouce/solicitacao',
			data: {
				id: solicitacao.id,
				aluno: buscarItem(solicitacao.idAluno, $scope.pessoas),
				responsavel: buscarItem(solicitacao.idResponsavel, $scope.pessoas),
				nre: buscarItem(solicitacao.idNre, $scope.cidades),
				municipio: buscarItem(solicitacao.idMunicipio, $scope.cidades),
				cep: solicitacao.cep,
				endereco: solicitacao.endereco,
				numeroEndereco: solicitacao.numeroEndereco,
				serie: solicitacao.serie,
				ensino: solicitacao.ensino,
				escola: solicitacao.escola,
				dataChegada: solicitacao.dataChegada,
				itensSolicitacao: itens				
			}
		}).success(function (data) {
			toastr.success('Solicitacao salva com sucesso.');
			toastr.success('Numero da Solicitacao: '+data.id);
			$scope.solicitacao = new Solicitacao();
		}).error(function (data) {
			toastr.warning(data.message);
		});
	};
	
	$scope.editar = function(solicitacao) {
		$location.path('/cadastrosolicitacao/'+ solicitacao.id);
	};
	    
	
	$scope.carregarSolicitacao = function () {
		console.log('carregarSolicitacao');
		if (!$routeParams.idSolicitacao) {
			
			console.log('carregarSolicitacao, new');
			$scope.solicitacao = new Solicitacao();
			return;
		}
		
		console.log('carregarSolicitacao', $routeParams.idSolicitacao);
		
		$http({
			url: './rest/solicitacaoResouce/solicitacao/'+$routeParams.idSolicitacao,
			method: 'GET'
		}).success(function (data) {
			console.log(data);
			$scope.solicitacao = data;
			$scope.solicitacao.idAluno = data.aluno ? data.aluno.id : null;
			$scope.solicitacao.idNre = data.nre ? data.nre.id : null;
			$scope.solicitacao.idMunicipio = data.municipio ? data.municipio.id : null;
			$scope.solicitacao.idResponsavel = data.responsavel ? data.responsavel.id : null;
			
			for (var i in $scope.solicitacao.itensSolicitacao) {
				$scope.solicitacao.itensSolicitacao[i].idLivro =
					$scope.solicitacao.itensSolicitacao[i].livro.id;
			}
		});
	};
	
	$http({
		method: 'GET',
		url: './rest/solicitacaoResouce/solicitacao/pag/1'		
	}).success(function (data) {
		$scope.solicitacoes = data;
	});
	
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
		return selecionados[0];
	}
	
	function buscarItem(id, list) {
		var selecionados = $.grep(list, function (item) {
			return item.id = id;
		});
		
		console.log('item encontrado ', id, selecionados[0]);
		return selecionados[0];
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
	
}

controllers.controller('SolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$http',
		 '$routeParams',
		 SolicitacaoController
		 ]);