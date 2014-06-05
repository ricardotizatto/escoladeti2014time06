function OrdemProducaoController($scope, $http, $routeParams) {
    console.log('carregando controller');
    $scope.info = {};

    $scope.deletar = function(ordemProducao) {
        console.log('deletando ordem de producao ' + JSON.stringify(ordemProducao));

        BootstrapDialog.confirm('Deseja realmente deletar a Ordem de Produção: <b>' + ordemProducao.id + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: ordemProducao,
                    url: './rest/ordemProducaoSource/ordemProducao',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                        .success(function(data, status) {
                            $scope.getTodos(1);
                            console.log('ordem de producao deletado');
                            BootstrapDialog.show({
                                title: 'Notifica&ccedil;&atilde;o',
                                message: 'Ordem de Produção <b>' + ordemProducao.id + '</b> deletada com Sucesso!',
                                type: BootstrapDialog.TYPE_SUCCESS,
                                buttons: [{
                                        id: 'btn-ok',
                                        icon: 'glyphicon glyphicon-ok',
                                        label: ' OK',
                                        cssClass: 'btn-success btn-padrao',
                                        autospin: false,
                                        action: function(dialogRef) {
                                            dialogRef.close();
                                        }
                                    }]
                            });
                        })
                        .error(function(data, status) {
                            console.log('erro ao deletar a ordem de produção ' + data);
                            BootstrapDialog.show({
                                title: 'Notifica&ccedil;&atilde;o',
                                message: 'Ocorreu um erro ao deletar a Ordem de Produção: <b>' + ordemProducao.id + '</b>',
                                type: BootstrapDialog.TYPE_DANGER,
                                buttons: [{
                                        id: 'btn-ok',
                                        icon: 'glyphicon glyphicon-ok',
                                        label: ' OK',
                                        cssClass: 'btn-success btn-padrao',
                                        autospin: false,
                                        action: function(dialogRef) {
                                            dialogRef.close();
                                        }
                                    }]
                            });
                        });
            } else {
                $scope.getTodos(1);
            }
        });
    };

    $scope.novo = function() {
        $scope.ordemProducao = getNovaOrdemProducao();
        window.location = '#/ordemproducao';
    };

    $scope.carregarOrdemProducao = function() {
        console.log('carregando ordem de produção');

        if (!$routeParams.ordemProducaoId) {
            $scope.ordemProducao = getNovaOrdemProducao();
            return;//se não tiver id não buscar
        }

        $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
                .success(function(ordemProducao, status) {
                    $scope.ordemProducao = ordemProducao;
                });
    };

    $scope.editar = function(ordemProducao) {
        window.location = '#/ordemproducao/' + ordemProducao.id;
    };
    
    $scope.salvar = function() {
        $http.post('./rest/ordemProducaoSource/ordemProducao', $scope.ordemProducao)
                .success(function(ordemProducao, status) {
                    $scope.ordemProducao = getNovaOrdemProducao();
                    console.log('ordemProducao editado = ' + ordemProducao);
                    $scope.info.message = 'Salvo com sucesso';
                    $scope.info.status = 'success';
                })
                .error(function(data, status) {
                    console.log('ordemProducao não salvo = ' + data);
                    $scope.info = {};
                    $scope.info.status = 'danger';
                    console.log($scope.info);
                    $scope.info.message = data.message;
                });
    };

    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get('./rest/ordemProducaoSource/listar/pag/' + numeroPagina)
                .success(function(listaOrdensProducao, status) {
                    $scope.ordensProducao = listaOrdensProducao;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar ordensProducao ' + data);
                });
    };

    function getNovaOrdemProducao() {
        console.log('nova ordem de produção');
        return {};
    }

    $scope.voltar = function() {
        $scope.ordemProducao = {};
        window.location = '#/listaordemproducao';
    };

}