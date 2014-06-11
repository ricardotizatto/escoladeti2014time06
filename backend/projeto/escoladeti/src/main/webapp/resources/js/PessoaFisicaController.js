'use strict';

function pessoaFisicaController($scope, $http, $routeParams) {
	function getNovaPessoaFisica() {
		return {
			telefones: [],
			enderecos: []
		};
	}
	
    $scope.novo = function() {
        $scope.pessoa = getNovaPessoaFisica();
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
    	$scope.pessoa = getNovaPessoaFisica();
        if ($routeParams.pessoaFisicaId) {
            console.log('Aqui');
        }
    };

    $scope.salvar = function() {
    	console.log('enviando pessoa fisica ', $scope.pessoa);
        $http.post('./rest/pessoaFisicaSource/pessoaFisica', $scope.pessoa)
                .success(function(data, status) {
                    console.log('Salvo com sucesso ' , data);
                    $scope.pessoa = getNovaPessoaFisica();
                })
                .error(function(data) {
                    console.log('Nao foi possivel Salvar ', data);
                });
    };

    $scope.salvarTelefone = function() {
        console.log($scope.telefone);
        $scope.pessoa.telefones.push($scope.telefone);

        console.log($scope.telefones);
        $scope.telefone = getNovo();
    };

    $scope.cancelarTelefone = function() {
        $scope.telefone = getNovo();
    };

    $scope.editarTelefone = function(indice) {
        $scope.telefone = $scope.pessoa.telefones[indice];
    };

    $scope.delTelefone = function(index) {
        $scope.pessoa.telefones.splice(index, 1);
    };

    $scope.idEndereco = 0;

    $scope.salvarEndereco = function() {
        console.log($scope.endereco);
        if (!$scope.idEndereco) {
            $scope.idEndereco++;
            $scope.endereco.idEndereco = $scope.idEndereco;
            $scope.pessoa.enderecos.push($scope.endereco);
        }
        $scope.endereco = null;
    };

    $scope.editarEndereco = function(indice) {
        $scope.endereco = $scope.pessoa.enderecos[indice];
    };

    $scope.addEndereco = function() {
        $scope.pessoa.enderecos.push($scope.endereco);
        $scope.endereco = null;
    };

    $scope.delEndereco = function(index) {
        $scope.pessoa.enderecos.splice(index, 1);
    };

    $scope.cancelarEndereco = function() {
        $scope.endereco = getNovo();
    };

    function getNovo() {
        return {};
    }
    

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