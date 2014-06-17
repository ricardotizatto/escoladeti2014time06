function EstadoController ($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.info = {};

    $scope.deletar = function(unidadeFederativa) {
        console.log('deletando unidadeFederativa ' + JSON.stringify(unidadeFederativa));

        BootstrapDialog.confirm('Deseja realmente deletar o Estado: <b>' + unidadeFederativa.nome + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: unidadeFederativa,
                    url: './rest/unidadeFederativaSource/unidadeFederativa',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                    .success(function(data, status) {
                        $scope.getTodos(1);
                        console.log('Estado deletado!');
                        $scope.info.message = 'Estado ' + unidadeFederativa.nome + ' deletado com sucesso';
                        $scope.info.status = 'success';
                    })
                    .error(function(data, status) {
                        console.log('Estado não foi deletado' + data);
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao deletar o unidadeFederativa: ' + unidadeFederativa.nome + ' - ' + data.message;
                    });
            } else {
                $scope.getTodos(1);
            }
        });
    };

    $scope.novo = function() {
        $scope.unidadeFederativa = getNovoEstado();
        window.location = '#/cadastroestado';
    };

    $scope.carregarEstado = function() {
        console.log('carregando unidadeFederativa com id: ' + $routeParams.unidadeFederativaId);
        if (!$routeParams.unidadeFederativaId) {
            $scope.unidadeFederativa = getNovoEstado();
            return;//se não tiver id não buscar
        }

        $http.get('./rest/unidadeFederativaSource/unidadeFederativa/' + $routeParams.unidadeFederativaId)
            .success(function(unidadeFederativa, status) {
                console.log(unidadeFederativa);
                delete unidadeFederativa.info;
                $scope.unidadeFederativa = unidadeFederativa;
            });

    }
    
    $scope.carregarPaises = function() {
        console.log('carregando pais');
        $http.get('./rest/paisSource/listarTodosPaises')
            .success(function(listaPaises) {
                console.log(listaPaises);
                $scope.paises = listaPaises;
            })
            .error(function(data) {
                console.log('erro ao buscar paises ' + data);
            });
    }

    $scope.editar = function(unidadeFederativa) {
        console.log(unidadeFederativa);
        window.location = '#/cadastroestado/' + unidadeFederativa.id;
    };

    $scope.buscaEstadosContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/unidadeFederativaSource/unidadeFederativa?q=' + $scope.busca.toUpperCase())
            .then(function(retorno) {
                console.log(retorno.data);
                $scope.unidadesFederativas = retorno.data;
            });
    }

    $scope.salvar = function() {

        $scope.unidadeFederativa.nome = $scope.unidadeFederativa.nome.toUpperCase();
        $scope.unidadeFederativa.sigla = $scope.unidadeFederativa.sigla.toUpperCase();

        console.log($scope.unidadeFederativa);
        $http.post("./rest/unidadeFederativaSource/unidadeFederativa", $scope.unidadeFederativa)
            .success(function(unidadeFederativa) {
                $scope.unidadeFederativa = getNovoEstado();
                console.log("unidadeFederativa salva = " + unidadeFederativa);
                $scope.info.message = 'Estado ' + unidadeFederativa.nome + ' salvo com sucesso';
                $scope.info.status = 'success';
            })
            .error(function(data) {
                console.log("erro ao salvar unidadeFederativa" + data);
                $scope.info.status = 'danger';
                console.log($scope.info);
                $scope.info.message = data.message;
            });
    };

    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get('./rest/unidadeFederativaSource/listar/pag/' + numeroPagina)
            .success(function(listaUnidadesFederativas) {
                console.log(listaUnidadesFederativas);
                $scope.unidadesFederativas = listaUnidadesFederativas;
            })
            .error(function(data) {
                console.log('erro ao buscar Estados ' + data.developerMessage);
            });
    }

    function getNovoEstado() {
        console.log('novo Estado');
        return {};
    };

    $scope.voltar = function() {
        $scope.unidadeFederativa = {};
        window.location = '#/listaestado';
    }
}