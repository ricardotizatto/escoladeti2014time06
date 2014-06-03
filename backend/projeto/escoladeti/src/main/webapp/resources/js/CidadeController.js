function cidadeController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(cidade) {
        window.location = '#/cadastrocidade/' + cidade.id;
    };

    $scope.deletar = function(cidade) {
        console.log('deletando cidade' + JSON.stringify(cidade));
        $http({
            method: 'DELETE',
            data: cidade,
            url: './rest/cidadeSource/cidade',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log("cidade deletado");
                }).error(function(data, status) {
            console.log("erro ao deletar cidade " + data);
        });
    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.cidade, true));
        $http.post("./rest/cidadeSource/cidade", $scope.cidade)
                .success(function(cidade, status) {
                    $scope.cidade = getNovaCidade();
                    console.log("cidade salva = " + cidade);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar cidade" + data);
                });
    };

    $scope.novo = function() {
        $scope.cidade = getNovaCidade();
        window.location = '#/cadastrocidade';
    };

    $scope.getTodos = function(numeroPagina) {
        console.log("Pagina: " + numeroPagina);
        $http.get("./rest/cidadeSource/listar/pag/" + numeroPagina)
                .success(function(listaCidades, status) {
                    $scope.cidades = listaCidades;
                    console.log("cidades carregadas");
                })
                .error(function(data, status) {
                    console.log('erro ao buscar cidades');
                });
    };

    $scope.carregarCidade = function() {
        console.log("carregando cidade");
        if (!$routeParams.cidadeId)
            return;//se não tiver id não buscar

        $http.get('./rest/cidadeSource/cidade/' + $routeParams.cidadeId)
                .success(function(cidade, status) {
                    $scope.cidade = cidade;
                    console.log("carregando cidade");
                });
    };

    $scope.buscaCidadeContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/cidadeSource/cidade?q=' + $scope.busca)
                .then(function(retorno) {
                    console.log(retorno.data.list);
                    $scope.cidades = retorno.data;
                });
    };

//    $scope.carregarEstado = function(){
//       console.log("carregando estado"); 	  		
//       $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
//               .success(function(estado, status){
////                   console.log(angular.toJson(estado, true));
//                    $scope.estados = estado;
//               })
//               .error(function(data, status){
//                   console.log('erro ao buscar estados')
//               });
//    };
    $scope.carregaEstados = function() {
        carregaEstados();
    };


    function carregaEstados() {
        $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
                .success(function(unidadeFederativa) {
                    console.log('Estados carregados');
                    $scope.unidadeFederativa = unidadeFederativa;
                    //$scope.cidade.unidadeFederativa = {"id":1,"nome":"parana","sigla":"pr","pais":{"id":1,"nome":"Brasil","sigla":"BR","codPais":1}};

                    //console.log({a : 1} === {a : 1}); 
                    //console.log(unidadeFederativa[0])
                    //console.log($scope.cidade.unidadeFederativa);

                })
                .error(function(data) {
                    console.log('Nao foi possivel carregar os estados' + data);
                });

    }
    ;
//    
//     function carregaCidade (){
//        $http.get('./rest/cidadeSource/cidade')
//                .success(function(cidade){
//                    console.log('Cidade carregada');
//                    $scope.cidade = cidade;
//        })
//                .error(function(data){
//                    console.log('Nao foi possivel carregar a cidade' + data);
//        });
//    };

    function getNovaCidade() {
        console.log('nova cidade');
        return {};
    };
    
    $scope.cancelar = function(){
        $scope.cidade = {};
    };
    $scope.listar = function(){
        $scope.cidade = {};
        window.location = '#/listacidade';
    };
    $scope.voltar = function(){
        $scope.cidade = {};
        window.location = '#/listacidade';
    }

}