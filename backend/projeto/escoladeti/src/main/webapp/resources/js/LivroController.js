function livroController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.deletar = function(livro) {
        console.log('deletando livro ' + JSON.stringify(livro));
        $http({
            method: 'DELETE',
            data: livro,
            url: './rest/livroSource/livro',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
        .success(function(data, status) {
            $scope.getTodos();
            console.log('Livro deletado!')
        })
        .error(function(data, status) { 
            console.log('Livro não foi deletado');
        });
    };
    
    $scope.novo = function() {
        $scope.livro = getNovoLivro();
        window.location = '#/cadastrolivro';
    };
    
    $scope.carregarLivro = function() {
        if ($routeParams.livroId) {
            $http.get('./rest/livroSource/livro/' + $routeParams.livroId)
                    .success(function(livro) {
                        console.log('Sucesso ao livro: ');
                        $scope.livro = livro;
                    })
                    .error(function(data, status) {
                        console.log('erro ao buscar livro ');
                    });
        }
    };

    $scope.editar = function(livro) {
        console.log(livro);
        window.location = '#/cadastrolivro/' + livro.id;
    };
    
    $scope.buscaLivrosContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/livroSource/livro?q=' + $scope.busca)
            .then(function(retorno) {
                console.log(retorno.data.list);
                $scope.livros = retorno.data;
            });
    }  

    $scope.salvar = function() {
        console.log(angular.toJson($scope.livro, true));
        $http.post("./rest/livroSource/livro", $scope.livro)
                .success(function(livro, status) {
                    $scope.livro = getNovoLivro();
                    console.log("livro salva = " + livro);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar livro" + data);
                });
    };
    
    $scope.getTodos = function() {
        $http.get("./rest/livroSource/livro")
            .success(function(livros, status) {
                $scope.livros = livros;
            })
            .error(function(data, status) {
                console.log('erro ao buscar livros');
            });
    };

    function getNovoLivro() {
        console.log('novo livro');
        return {};
    };
    
    $scope.voltar = function() {
        $scope.livro = {};
        window.location = '#/listalivro';
    }
}