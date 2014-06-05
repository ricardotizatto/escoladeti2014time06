function distritoController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(distrito) {
        window.location = '#/cadastrodistrito/' + distrito.id;
    };

    $scope.deletar = function(distrito) {
        console.log('deletando distrito' + JSON.stringify(distrito));
        $http({
            method: 'DELETE',
            data: distrito,
            url: './rest/distritoSource/distrito',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log("distrito deletado");
                }).error(function(data, status) {
            console.log("erro ao deletar distrito" + data);
        });
    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.distrito, true));
        $http.post("./rest/distritoSource/distrito", $scope.distrito)
                .success(function(distrito, status) {
                    $scope.distrito = getNovoDistrito();
                    console.log("distrito salva = " + distrito);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar distrito" + data);
                });
    };

    $scope.novo = function() {
        $scope.distrito = getNovoDistrito();
        window.location = '#/cadastrodistrito';
    };

    $scope.getTodos = function(numeroPagina) {
        console.log("Pagina: " + numeroPagina);
        $http.get("./rest/distritoSource/listar/pag/" + numeroPagina)
                .success(function(listaDistritos, status) {
                    $scope.distritos = listaDistritos;
                    console.log("distritos carregados");
                })
                .error(function(data, status) {
                    console.log('erro ao buscar distritos');
                });
    };

    $scope.carregarDistrito = function() {
        console.log("carregando distrito");
        if (!$routeParams.distritoId)
            return;//se não tiver id não buscar

        $http.get('./rest/distritoSource/distrito/' + $routeParams.distritoId)
                .success(function(distrito, status) {
                    $scope.distrito = distrito;
                    console.log("carregando distrito");
                });
    };

    $scope.buscaDistritoContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/distritoSource/distrito?q=' + $scope.busca)
                .then(function(retorno) {
                    console.log(retorno.data.list);
                    $scope.distritos = retorno.data;
                });
    };
    
    $scope.carregarCidade = function(){
        $http.get('./rest/cidadeSource/cidade')
                .success(function(cidade){
                    console.log("Cidades carregadas");
                    $scope.cidades = cidade;
                })
                .error(function(data){
                    console.log('Nao foi possivel carregar cidades' + data);
                });
    };
    
    function getNovoDistrito() {
        console.log('novo distrito');
        return {};
    };

    $scope.cancelar = function() {
        $scope.distrito = {};
    };
    
    $scope.listar = function() {
        $scope.distrito = {};
        window.location = '#/listadistrito';
    };
    
    $scope.voltar = function() {
        $scope.distrito = {};
        window.location = '#/listadistrito';
    };

}