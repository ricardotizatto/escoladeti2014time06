function cidadeController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(cidade) {
        window.location = '#/cadastrocidade/' + cidade.id;
    };

    $scope.deletar = function(cidade) {
        console.log('deletando cidade' + JSON.stringify(cidade));
        
        BootstrapDialog.confirm('Deseja realmente deletar a Cidade: <b>' + cidade.nome + '</b>?', function(result) {
            if(result){
                $http({
                    method: 'DELETE',
                    data: cidade,
                    url: './rest/cidadeSource/cidade',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log("cidade deletado");
                    $scope.info = {};
                    $scope.info.message = 'Cidade ' + cidade.nome + ' deletada com sucesso';
                    $scope.info.status = 'success';
                })
                .error(function(data, status) {
                    console.log("erro ao deletar cidade " + data);
                    $scope.info = {};
                    $scope.info.status = 'danger';
                    $scope.info.mesage = 'Erro ao deletar a cidade: ' + cidade.nome + ' - '+data.message;
                });
            }else{
                $scope.getTodos(1);
            }
        });
    };

    $scope.salvar = function() {
        $scope.cidade.nome = $scope.cidade.nome.toUpperCase();
//        console.log(angular.toJson($scope.cidade, true));
        $http.post("./rest/cidadeSource/cidade", $scope.cidade)
                .success(function(cidade, status) {
                    $scope.cidade = getNovaCidade();
                    console.log("cidade salva = " + cidade);
                    $scope.info = {};
                    $scope.info.message = 'Cidade ' + cidade.nome + ' salvo com sucesso' ;
                    $scope.info.status = 'success';
                })
                .error(function(data, status) {
                    console.log("erro ao salvar cidade" + data);
                    $scope.info = {};
                    $scope.info.status = 'danger';
                    console.log($scope.info);
                    $scope.info.message = 'Erro ao salvar a cidade ' + cidade.nome + ' - '+data.message;
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
        $http.get('./rest/cidadeSource/cidade?q=' + $scope.busca.toUpperCase())
                .then(function(retorno) {
                    console.log(retorno.data.list);
                    $scope.cidades = retorno.data;
                });
    };
    
    $scope.carregaEstados = function() {
        $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
                .success(function(unidadeFederativa) {
                    console.log('Estados carregados');
                    $scope.unidadeFederativa = unidadeFederativa;
                })
                .error(function(data) {
                    console.log('Nao foi possivel carregar os estados' + data);
                });

    };
    
    function getNovaCidade() {
        console.log('nova cidade');
        return {};
    };

    $scope.cancelar = function() {
        $scope.cidade = {};
    };
    
    $scope.listar = function() {
        $scope.cidade = {};
        window.location = '#/listacidade';
    };
    
    $scope.voltar = function() {
        $scope.cidade = {};
        window.location = '#/listacidade';
    }

}