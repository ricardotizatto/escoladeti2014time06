'use strict';

function pessoaFisicaController($scope, $http, $routeParams) {
	$scope.info = {};
	
	function getNovaPessoaFisica() {
		return {
			telefones: [],
			enderecos: []
		};
	}
	
    $scope.novo = function() {
        $scope.pessoaFisica = getNovaPessoaFisica();
        window.location = '#/pessoafisica';
    };

    $scope.init = function() {
    	console.log('init');
        $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
                .success(function(unidadesFederativas, status) {
                    $scope.estados = unidadesFederativas;
                    console.log(unidadesFederativas);
                });
        $http.get('./rest/paisSource/pais')
                .success(function(paises, status) {
                    $scope.paises = paises;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar paises ' + data);
                });
        $http.get("./rest/cidadeSource/cidade")
                .success(function(cidades, status) {
                    $scope.cidades = cidades;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar cidades');
                });
    };
    
    $scope.carregarPessoa = function() {
    	$scope.pessoaFisica = getNovaPessoaFisica();
        if ($routeParams.pessoaFisicaId) {
            console.log('Aqui');
        }
    };
    
    $scope.voltar = function() {
        $scope.pessoaFisica = getNovo();
        window.location = '#/listapessoafisica';
    };

    $scope.salvar = function() {
    	console.log('enviando pessoa fisica ', $scope.pessoaFisica);
        $http.post('./rest/pessoaFisicaSource/pessoaFisica', $scope.pessoaFisica)
                .success(function(data, status) {
                    //console.log('Salvo com sucesso ' , data);
                	$scope.info.status = 'success';
                	$scope.info.message  = 'Pessoa salva com sucesso.';
                    $scope.pessoaFisica = getNovaPessoaFisica();
                })
                .error(function(data) {
                	$scope.info.status = 'danger';
                	$scope.info.message = data.message;
                    console.log('Nao foi possivel Salvar ', data);
                });
    };

    $scope.salvarTelefone = function() {
        console.log($scope.telefone);
        $scope.pessoaFisica.telefones.push($scope.telefone);

        console.log($scope.telefones);
        $scope.telefone = getNovo();
    };

    $scope.cancelarTelefone = function() {
        $scope.telefone = getNovo();
    };

    $scope.editarTelefone = function(indice) {
        $scope.telefone = $scope.pessoaFisica.telefones[indice];
    };

    $scope.delTelefone = function(index) {
        $scope.pessoaFisica.telefones.splice(index, 1);
    };

    $scope.idEndereco = 0;

    $scope.salvarEndereco = function() {
        console.log($scope.endereco);
        $scope.pessoaFisica.enderecos.push($scope.endereco);
        
        console.log($scope.enderecos);
        $scope.endereco = getNovo();
    };

    $scope.editarEndereco = function(indice) {
        $scope.endereco = $scope.pessoaFisica.enderecos[indice];
    };

    $scope.addEndereco = function() {
        $scope.pessoaFisica.enderecos.push($scope.endereco);
        $scope.endereco = null;
    };

    $scope.delEndereco = function(index) {
        $scope.pessoaFisica.enderecos.splice(index, 1);
    };

    $scope.cancelarEndereco = function() {
        $scope.endereco = getNovo();
    };

    function getNovo() {
        return {};
    }
    
    $scope.getTodos = function (pag) {
    	$http.get('./rest/pessoaFisicaSource/pessoaFisica')
    		.success(function (data, status) {
    			$scope.pessoasFisicas = data;
    		})
    		.error(function (data, status) {
    			console.log(data);
    		});
    };
    

    $scope.filtroCidades = function() {
//    	console.log('filtro cidades');
//        var filtroCidades = [];
//        angular.forEach($scope.cidades, function(value, key) {
//            if (value.unidadeFederativa === $scope.estado) {
//                this.push(value);
//            }
//        }, filtroCidades);
//        return cidades;
    };
}