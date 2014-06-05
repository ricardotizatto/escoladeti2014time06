<<<<<<< HEAD
function OrdemProducaoController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.deletar = function(pais) {
        console.log('deletando pais ' + JSON.stringify(pais));

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
                            console.log('Ordem Produção deletado');
                            BootstrapDialog.show({
                                title: 'Notificação',
                                message: 'Ordem Produção <b>' + ordemProducao.id + '</b> deletada com Sucesso!',
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
                            console.log('erro ao deletar ordem de produção ' + data);
                            BootstrapDialog.show({
                                title: 'Notificação',
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
    }

    $scope.carregarOrdemProducao = function() {
        console.log('carregando ordem produção');
=======
function OrdemProducaoController ($scope, $http, $routeParams){
    console.log('Carregando controller');
    
    $scope.deletar = function(ordemProducao) {
         console.log('deletando Ordem de Producao ' + JSON.stringify(ordemProducao));
        $http({
            method: 'DELETE',
            data: ordemProducao,
            url: '.rest/ordemProducaoSource/ordemProducao',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
        .success(function(data, status) {
            $scope.getTodos(1);
            console.log('Ordem de Produção deletada!');
        })
        .error(function(data, status) { 
            console.log('Ordem de Produção não foi deletada' + data);
        });
    };
    
    $scope.novo = function() {
        $scope.ordemProducao = getNovaOrdemProducao();
        window.location = '#/ordemproducao';
    };
    
    $scope.carregarOrdemProducao = function() {
        console.log('carregando Ordem de Producao com id: ' + $routeParams.ordemProducaoId );
>>>>>>> d36e5b35e9120e522c282e6ba7b5314c022a7b0f
        if (!$routeParams.ordemProducaoId)
            return;//se não tiver id não buscar

        $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
<<<<<<< HEAD
            .success(function(ordemProducao, status) {
                $scope.ordemProducao = ordemProducao;
            });
    }

    $scope.editar = function(ordemProducao) {
        window.location = '#/ordemproducao/' + ordemProducao.id;
    }

    $scope.salvar = function() {

        $scope.ordemProducao.material = $scope.ordemProducao.material.toUpperCase();
        $scope.ordemProducao.traducao = $scope.ordemProducao.traducao.toUpperCase();
        $scope.ordemProducao.status = $scope.ordemProducao.status.toUpperCase();

        console.log($scope.ordemProducao);
        $http.post("./rest/ordemProducaoSource/ordemProducao", $scope.ordemProducao)
                .success(function(ordemProducao, status) {
                    $scope.ordemProducao = getNovaOrdemProducao();
                    console.log("Ordem de Producao salva = " + ordemProducao);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar Ordem de Producao" + data);
                });
    };

    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get('./rest/ordemProducaoSource/listar/pag/' + numeroPagina)
                .success(function(listaOrdensProducao, status) {
                    $scope.ordensProducao = listaOrdensProducao;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar Ordens de Producao ' + data);
                });
    }

    function getNovaOrdemProducao() {
        return {};
    }

=======
                .success(function(ordemProducao, status) {
                    console.log(ordemProducao);
                    $scope.ordemProducao = ordemProducao;
                });

    }
    
    $scope.editar = function(ordemProducao) {
        console.log(ordemProducao);
        window.location = '#/ordemproducao' + ordemProducao.id;
    };
    
    $scope.buscaOrdemProducaoContendoNome = function() {
        console.log($scope.busca);
        $http.get('./rest/ordemProducaoSource/ordemProducao?q=' + $scope.busca)
                .then(function(retorno) {
                    console.log(retorno.data.list);
                    $scope.ordensProducao = retorno.data;
                });
    } 
    
    $scope.salvar = function() {

        $scope.ordemProducao.material = $scope.ordemProducao.material.toUpperCase();
        $scope.ordemProducao.traducao = $scope.ordemProducao.traducao.toUpperCase();
        $scope.ordemProducao.status = $scope.ordemProducao.status.toUpperCase();

        console.log($scope.ordemProducao);
        $http.post("./rest/ordemProducaoSource/ordemProducao", $scope.ordemProducao)
                .success(function(ordemProducao, status) {
                    $scope.ordemProducao = getNovaOrdemProducao();
                    console.log("Ordem de Producao salva = " + ordemProducao);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar Ordem de Producao" + data);
                });
    };
    
    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get('./rest/ordemProducaoSource/listar/pag/' + numeroPagina)
            .success(function(listaOrdensProducao, status) {
                $scope.ordensProducao = listaOrdensProducao;
            })
            .error(function(data, status) {
                console.log('erro ao buscar Ordens de Producao ' + data);
            });
    }
                    
    function getNovaOrdemProducao() {
        return {};
    }
    
>>>>>>> d36e5b35e9120e522c282e6ba7b5314c022a7b0f
    $scope.voltar = function() {
        $scope.OrdemProducao = {};
        window.location = '#/listaordemproducao';
    }
<<<<<<< HEAD

=======
    
>>>>>>> d36e5b35e9120e522c282e6ba7b5314c022a7b0f
    $scope.getStatusOrdemProducao = function(status) {
        switch (status) {
            case "Andamento":
                return "label-primary";
                break;
            case "Finalizado":
                return "label-success";
                break;
            case "Rejeitado":
                return "label-danger";
                break;
            default:
                return "label-default";
        }
    };
<<<<<<< HEAD

=======
    
>>>>>>> d36e5b35e9120e522c282e6ba7b5314c022a7b0f
    //Início das funções da ParteMaterial
    $scope.novaParteMaterial = function() {
        $scope.parteMaterial = getNovaParteMaterial();
        window.location = '#/cadastropartematerial';
    };

    $scope.salvarParteMaterial = function() {
        $http.post('./rest/ordemProducaoSource/parteMaterial', $scope.parteMaterial)
                .success(function(parteMaterial, status) {
                    $scope.parteMaterial = getNovaParteMaterial();
                    console.log('Parte do Material salva ' + parteMaterial);
                })
                .error(function(data) {
                    console.log('Parte do Material não foi salva ' + data);
                });
    };
    $scope.carregarParteMaterial = function() {
        if ($routeParams.parteMaterialId) {
            $http.get('./rest/ordemProducaoSource/parteMaterial/' + $routeParams.parteMaterialId)
                    .success(function(parteMaterial) {
                        $scope.parteMaterial = parteMaterial;
                    });
        }
    };

    $scope.getTodasPartesMateriais = function() {
        $http.get('./rest/ordemProducaoSource/parteMaterial')
                .success(function(partesMateriais) {
                    $scope.partesMateriais = partesMateriais;
                    console.log('Partes materiaias carregadas');
                });
    };

    $scope.editarParteMaterial = function(parteMaterial) {
        console.log(parteMaterial);
        window.location = '#/cadastropartematerial/' + parteMaterial.id;
    };

    $scope.deletarParteMaterial = function(parteMaterial) {
        $http({
            method: 'DELETE',
            data: parteMaterial,
            url: './rest/ordemProducaoSource/parteMaterial',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
                    console.log('Deletada!');
                    $scope.getTodasPartesMateriais();
                })
                .error(function(data) {
                    console.log('Não foi possíivel deletar ' + data);
                });
    };

    $scope.cancelarParteMaterial = function() {
        window.location = '#/ordemproducao';
    };

    function getNovaParteMaterial() {
        return {};
    }

}