function pessoaFisicaController($scope, $http, $routeParams) {
    $scope.novo = function() {
        $scope.pessoa = getNovo();
        window.location = '#/cadastropessoafisica';
    };

    $scope.carregarPessoa = function() {
        if ($routeParams.pessoaFisicaId) {
            console.log('Aqui');
        }
        $scope.pessoa = getNovo();
        $scope.pessoa.telefones = [];
    };

    $scope.salvar = function() {
        $http.post('./rest/pessoaFisicaSource/pessoaFisica', $scope.pessoa)
                .success(function(data, status) {
                    console.log('Salvo com sucesso ' + data);
                    $scope.pessoa = getNovaPessoaFisica();
                })
                .error(function(data) {
                    console.log('Nao foi possivel Salvar ' + data);
                });
    };

    $scope.salvarTelefone = function() {
        if (angular.isUndefined($scope.telefone) || !$scope.telefone.tipo) {
            alert('Tipo nao pode ser nulo');
            $scope.telefone.tipo.focus();
        } else {
            console.log($scope.telefone);
            $scope.pessoa.telefones.push($scope.telefone);

            console.log($scope.telefones);
            $scope.telefone = getNovo();
        }
    };

    $scope.cancelarTelefone = function() {

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

    function getNovo() {
        return {};
    }
}