var controllers = angular.module('controllers');

function CidadeController($scope, $routeParams, cidadeService, estadoService) {
	$scope.select2 = 'one';
	console.log('Carregando controller');
	$scope.info = {};

	var buscarSelecionado = function() {

		var selecionados = $.grep($scope.unidadesFederativas, function(item) {
			return item.id == $scope.cidade.idUnidadeFederativa;
		});

		console.log(selecionados[0]);

		$scope.cidade.unidadeFederativa = selecionados[0];
	};

	$scope.deletar = function(cidade) {
		console.log('deletando cidade ' + JSON.stringify(cidade));

		BootstrapDialog.confirm('Deseja realmente deletar a Cidade: <b>'
				+ cidade.nome + '</b>?', function(result) {
			if (result) {
				cidadeService.deletar(cidade).success(function(data, status) {
					$scope.getTodos($scope.pageNumber);
					console.log('Cidade deletada!');
					toastr.success('Cidade ' + cidade.nome + ' deletada.');
				}).error(function(data, status) {
					console.log('Cidade não foi deletado', data);
					toastr.error(data.message);
				});
			}
		});
	};

	$scope.novo = function() {
		$scope.cidade = getNovaCidade();
		window.location = '#/cadastrocidade';
	};

	$scope.carregarCidade = function() {
		console.log('carregando cidade com id: ' + $routeParams.cidadeId);
		if (!$routeParams.cidadeId) {
			$scope.cidade = getNovaCidade();
			return;// se não tiver id não buscar
		}

		cidadeService
				.buscar($routeParams.cidadeId)
				.success(
						function(cidade, status) {
							console.log(cidade);
							console.log('Estado', cidade.unidadeFederativa);
							$scope.cidade = cidade;
							$scope.cidade.idUnidadeFederativa = cidade.unidadeFederativa.id;
						});
	};
    
    (function() {
        $scope.pageNumber = 1;
    	console.log('carregando Estados');
    	estadoService.buscarTodos()
    		.success(function(listaUf) {
                console.log(listaUf);
                $scope.unidadesFederativas = listaUf;
            })
            .error(function(data) {
                console.log('erro ao buscar estados ' + data);
            });
    }());
    
//    carregarUnidadesFederativas();
	
	$scope.editar = function(cidade) {
		console.log(cidade);
		window.location = '#/cadastrocidade/' + cidade.id;
	};

	$scope.buscaCidadesContendoNome = function() {
		console.log($scope.busca);
		cidadeService.buscarPorNome($scope.busca).then(function(retorno) {
			console.log(retorno.data);
			$scope.cidades = retorno.data;
		});
	};

	$scope.salvar = function() {

		$scope.cidade.nome = $scope.cidade.nome.toUpperCase();
		buscarSelecionado();

		console.log($scope.cidade);
		cidadeService.salvar($scope.cidade).success(function(cidade) {
			$scope.cidade = getNovaCidade();
			console.log("cidade salva = " + cidade);
			toastr.success('Cidade ' + cidade.nome + ' salva com sucesso.');
                        window.location = "#/listacidade";
		}).error(function(data) {
			console.log("erro ao salvar cidade" + data);
			toastr.warning(data.message);
		});
	};

	$scope.getTodos = function(numeroPagina) {
		cidadeService.listar(numeroPagina).success(function(listaCidades) {
			$scope.cidades = listaCidades;
                        
            console.log($scope.cidades);
		}).error(function(data) {
			console.log('erro ao buscar Cidades ' + data.developerMessage);
		});
	};

	function getNovaCidade() {
		console.log('Nova Cidade');
		return {
			nome : '',
			unidadeFederativa : null
		};
	}
	;

	$scope.voltar = function() {
		$scope.cidade = {};
		window.location = '#/listacidade';
	};

	$scope.select2Options = {};

};

controllers.controller('CidadeController', [ '$scope', '$routeParams','cidadeService', 'estadoService', CidadeController ]);