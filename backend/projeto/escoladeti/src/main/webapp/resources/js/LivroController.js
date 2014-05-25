function livroController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(livro) {
        console.log(livro);
        window.location = '#/cadastrolivro/' + livro.id;
    };
    
    $scope.deletar = function(livro) {
        $http({
            method: 'DELETE',
            data: livro,
            url: './rest/livro',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data, status) {
                    //$scope.getTodos();
                    console.log('Livro deletado!')
                })
                .error(function(data, status) { 
                    console.log('Livro não foi deletado');
                });
    };

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

    $scope.novo = function() {
        $scope.livro = getNovoLivro();
        window.location = '#/cadastrolivro';
    };
    
    $scope.getById = function() {
        $http.get("./rest/livroSource/livro/60")
                .success(function(livro, status) {
                    $scope.livro = livro;
                    console.log('Sucesso ao buscar livro' + livro.nome);
                })
                .error(function(livro, status) {
                    console.log('erro ao buscar livro' + livro.nome);
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

    function getNovoLivro() {
        console.log('novo livro');
        return {};
    };
}