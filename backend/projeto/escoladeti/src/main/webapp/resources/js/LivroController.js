function livroController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.deletar = function(livro) {
        console.log('deletando livro ' + JSON.stringify(livro));
        
        BootstrapDialog.confirm('Deseja realmente deletar o Livro: <b>' + livro.nome + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: livro,
                    url: './rest/livroSource/livro',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                .success(function(data, status) {
                    $scope.getTodos(1);
                    console.log('Livro deletado!');
                    toastr.success('Livro ' + livro.nome + ' deletado com sucesso'); 
                })
                .error(function(data, status) { 
                    console.log('Livro não foi deletado' + data);
                    toastr.error('Erro ao deletar o livro: ' + livro.nome + ' - '+ data.message);
                });
            } else {
                $scope.getTodos(1);
            }    
        });
    };
    
    $scope.novo = function() {
        $scope.livro = getNovoLivro();
        window.location = '#/cadastrolivro';
    };
        
    $scope.carregarLivro = function() {
        console.log('carregando livro com id: ' + $routeParams.livroId );
        if (!$routeParams.livroId){
            $scope.livro = getNovoLivro();
            return;//se não tiver id não buscar
        }    

        $http.get('./rest/livroSource/livro/' + $routeParams.livroId)
            .success(function(livro, status) {
                console.log(livro);
                delete livro.info;
                $scope.livro = livro;
            });
            
    };

    $scope.editar = function(livro) {
        console.log(livro);
        window.location = '#/cadastrolivro/' + livro.id;
    };
    
    $scope.buscaLivrosContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/livroSource/livro?q=' + $scope.busca.toUpperCase())
            .then(function(retorno) {
                console.log(retorno.data.list);
                
                retorno.data.list.forEach(function(livro) {
                    console.log(livro);
                    delete livro.info;
                });
                $scope.livros = retorno.data;
            });
    };

     $scope.salvar = function() {

        $scope.livro.nome = $scope.livro.nome.toUpperCase();
        $scope.livro.autor = $scope.livro.autor.toUpperCase();
        $scope.livro.editora = $scope.livro.editora.toUpperCase();
        $scope.livro.disciplina = $scope.livro.disciplina.toUpperCase();

        console.log($scope.livro);
        $http.post("./rest/livroSource/livro", $scope.livro)
            .success(function(livro, status) {
                $scope.livro = getNovoLivro();
                console.log("livro salva = " + livro);
                toastr.success('Livro ' + livro.nome + ' salvo com sucesso');
<<<<<<< HEAD
                $scope.voltar();
=======
                setTimeout(function(){window.location="#/listalivro"}, 5000);
>>>>>>> eaf97577c924fb18eeae6d0fe136a0b1919ac569
            })
            .error(function(data, status) {
                console.log("erro ao salvar livro" + data);
               // toastr.error(data.message);
            });
    };

    
    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        $http.get('./rest/livroSource/listar/pag/' + numeroPagina)
            .success(function(listaLivros, status) {
                
                listaLivros.list.forEach(function (livro) {
                    delete livro.info;
                });
                $scope.livros = listaLivros;
            })
            .error(function(data, status) {
                console.log('erro ao buscar livros ' + data);
            });
    };

    function getNovoLivro() {
        console.log('novo livro');
        return {};
    };
    
    $scope.voltar = function() {
        $scope.livro = {};
        window.location = '#/listalivro';
    };
}