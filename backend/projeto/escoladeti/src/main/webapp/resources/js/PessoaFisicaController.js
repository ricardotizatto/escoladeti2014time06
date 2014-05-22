function pessoaFisicaController($scope, $http, $routeParams) {

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

    $scope.idTelefone = 0;
    $scope.telefones = [];
    $scope.telefone = null;

    $scope.salvarTelefone = function() {
        $scope.pessoa.telefones.push($scope.telefone);
        $scope.telefone = getNovoTelefone();
    };

    $scope.editarTelefone = function(indice) {
        $scope.telefone = $scope.telefones[indice];
    };

    $scope.delTelefone = function(index) {
        $scope.pessoa.telefones.splice(index, 1);
    };

    $scope.idEndereco = 0;
    $scope.enderecos = [];
    $scope.endereco = null;

    $scope.salvarEndereco = function() {

        if (!$scope.endereco.idEndereco) {
            $scope.idEndereco++;
            $scope.endereco.idEndereco = $scope.idEndereco;
            $scope.enderecos.push($scope.endereco);
        }
        $scope.endereco = null;
    };

    $scope.editarEndereco = function(indice) {
        $scope.endereco = $scope.enderecos[indice];
    };

    $scope.addEndereco = function() {
        $scope.enderecos.push($scope.endereco);
        $scope.endereco = null;
    };

    $scope.delEndereco = function(index) {
        $scope.enderecos.splice(index, 1);
    };

    function getNovaPessoaFisica() {
        return {};
    }
    function getNovoTelefone(){
        return {};
    }
}