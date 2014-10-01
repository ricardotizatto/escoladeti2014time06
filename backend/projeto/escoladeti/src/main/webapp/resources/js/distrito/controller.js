var controllers = angular.module('controllers');

function DistritoController($scope, $routeParams, distritoService, cidadeService) {
	$scope.select2 = 'one';
	console.log('Carregando controller');
	$scope.info = {};

	var buscarSelecionado = function() {

		var selecionados = $.grep($scope.cidades, function(item) {
			return item.id == $scope.distrito.idCidade;
		});

		console.log(selecionados[0]);

		$scope.distrito.cidade = selecionados[0];
	};

	$scope.deletar = function(distrito) {
		console.log('deletando distrito ' + JSON.stringify(distrito));

		BootstrapDialog.confirm('Deseja realmente deletar o Distrito: <b>'
				+ distrito.nome + '</b>?', function(result) {
			if (result) {
				distritoService.deletar(distrito).success(function(data, status) {
					$scope.getTodos($scope.pageNumber);
					console.log('Distrito deletada!');
					toastr.success('Distrito ' + distrito.cidade.nome + ' deletada.');
				}).error(function(data, status) {
					console.log('Distrito não foi deletado', data);
					toastr.error(data.message);
				});
			}
		});
	};

	$scope.novo = function() {
		$scope.distrito = getNovoDistrito();
		window.location = '#/cadastrodistrito';
	};

	$scope.carregarDistrito = function() {
		console.log('carregando distrito com id: ' + $routeParams.distritoId);
		if (!$routeParams.distritoId) {
			$scope.distrito = getNovoDistrito();
			return;// se não tiver id não buscar
		}

		distritoService
				.buscar($routeParams.distritoId)
				.success(
						function(distrito, status) {
							console.log(distrito);
							console.log('Distrito', distrito.cidade);
							$scope.distrito = distrito;
							$scope.distrito.idCidade = distrito.cidade.id;
						});
	};
    
    (function() {
    	console.log('carregando Estados');
    	cidadeService.buscarTodos()
    		.success(function(listaCidade) {
                console.log(listaCidade);
                $scope.cidades = listaCidade;
            })
            .error(function(data) {
                console.log('erro ao buscar cidades ' + data);
            });
    }());
    
//    carregarUnidadesFederativas();
	
	$scope.editar = function(distrito) {
		console.log(distrito);
		window.location = '#/cadastrodistrito/' + distrito.id;
	};

	$scope.buscaDistritosContendoNome = function() {
		console.log($scope.busca);
		distritoService.buscarPorNome($scope.busca).then(function(retorno) {
			console.log(retorno.data);
			$scope.distritos = retorno.data;
		});
	};

	$scope.salvar = function() {

		buscarSelecionado();

		console.log($scope.distrito);
		distritoService.salvar($scope.distrito).success(function(distrito) {
			$scope.distrito = getNovoDistrito();
			console.log("distrito salvo = " + distrito);
			toastr.success('Distrito salvo com sucesso.');
		}).error(function(data) {
			console.log("erro ao salvar distrito" + data);
			toastr.warning(data.message);
		});
	};

	$scope.getTodos = function(numeroPagina) {
		console.log(numeroPagina);
		distritoService.listar(numeroPagina).success(function(listaDistritos) {
			console.log(listaDistritos);
			$scope.distritos = listaDistritos;
		}).error(function(data) {
			console.log('erro ao buscar Distritos ' + data.developerMessage);
		});
	};

	function getNovoDistrito() {
		console.log('Nova Distrito');
		return {
			inicioVigencia : null,
			fimVigencia : null,
			cidade : null,
			nome : null
		};
	}
	;

	$scope.voltar = function() {
		$scope.distrito = {};
		window.location = '#/listadistrito';
	};

	$scope.select2Options = {};

};

controllers.controller('DistritoController', [ '$scope', '$routeParams','distritoService', 'cidadeService', DistritoController ]);