function cepController($scope, $http, $routeParams) {
    console.log('Carregando Cep controller');

    

   $scope.getTodos = function() {

        $http.get("./rest/cepSource/cep")
                .success(function(ceps, status) {
                    $scope.ceps = ceps;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar eventos');
                });
    };

    $scope.carregarCep = function() {
        if ($routeParams.cepId) {
            $http.get('./rest/cepSource/cep/' + $routeParams.cepId)
                    .success(function(cep) {
                        $scope.cep = cep;
                    });
        }
    };
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}


