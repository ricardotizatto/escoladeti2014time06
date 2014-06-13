function pessoaJuridicaController($scope, $http, $routeParams) {
	function getNovaPessoaJuridica() {
		return {
			telefones: [],
			enderecos: []
		};
	}
	
    $scope.novo = function() {
        $scope.pessoaJuridica = getNovaPessoaJuridica();
        window.location = '#/pessoajuridica';
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
    	$scope.pessoaJuridica = getNovaPessoaJuridica();
        if ($routeParams.pessoaJuridicaId) {
            console.log('Aqui');
        }
    };
    
    $scope.voltar = function() {
        $scope.pessoaJuridica = getNovo();
        window.location = '#/listapessoajuridica';
    };

    $scope.salvar = function() {
    	console.log('enviando pessoa juridica ', $scope.pessoaJuridica);
        $http.post('./rest/pessoaJuridicaSource/pessoaJuridica', $scope.pessoaJuridica)
                .success(function(data, status) {
                    console.log('Salvo com sucesso ' , data);
                    $scope.pessoaJuridica = getNovaPessoaJuridica();
                })
                .error(function(data) {
                    console.log('Nao foi possivel Salvar ', data);
                });
    };

    $scope.salvarTelefone = function() {
        console.log($scope.telefone);
        $scope.pessoaJuridica.telefones.push($scope.telefone);

        console.log($scope.telefones);
        $scope.telefone = getNovo();
    };

    $scope.cancelarTelefone = function() {
        $scope.telefone = getNovo();
    };

    $scope.editarTelefone = function(indice) {
        $scope.telefone = $scope.pessoaJuridica.telefones[indice];
    };

    $scope.delTelefone = function(index) {
        $scope.pessoaJuridica.telefones.splice(index, 1);
    };

    $scope.idEndereco = 0;

    $scope.salvarEndereco = function() {
        console.log($scope.endereco);
        $scope.pessoaJuridica.enderecos.push($scope.endereco);
        
        console.log($scope.enderecos);
        $scope.endereco = getNovo();
    };

    $scope.editarEndereco = function(indice) {
        $scope.endereco = $scope.pessoaJuridica.enderecos[indice];
    };

    $scope.addEndereco = function() {
        $scope.pessoaJuridica.enderecos.push($scope.endereco);
        $scope.endereco = null;
    };

    $scope.delEndereco = function(index) {
        $scope.pessoaJuridica.enderecos.splice(index, 1);
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