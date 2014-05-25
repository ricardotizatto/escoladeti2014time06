function livroController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(livro) {
        console.log(livro);
        window.location = '#/cadastrolivro/' + livro.id;
    };

    $scope.deletar = function(livro) {
        alert(livro.nome);
        $http({
            method: 'DELETE',
            data: livro,
            url: './rest/livroSource/livro',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
            .success(function(data) {
                console.log("livro deletado");
                 $scope.getTodos();
            }).error(function(data) {
            console.log("erro ao deletar livro ");
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
                    $scope.livro = livro;
                });
        }
    };

    function getNovoLivro() {
        console.log('novo livro');
        return {};
    };
}