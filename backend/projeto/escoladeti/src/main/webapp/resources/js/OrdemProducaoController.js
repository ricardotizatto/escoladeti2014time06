function OrdemProducaoController($scope, $http, $routeParams) {
    console.log('carregando controller');
    $scope.info = {};

    $scope.ordensProducao = [
        {id: 101, material: "Gerenciamento de Projetos", traducao: "brille", status: 'andamento',
            parteMaterial: [
                {id: 01, parte: 1, responsavel: "Jose da Silva", inicio: 01, fim: 100, revisao: "Maria Pereira", observacao: "OBS 1", status: 'Andamento'},
                {id: 02, parte: 2, responsavel: "Jose da Silva", inicio: 101, fim: 200, revisao: "Maria Pereira", observacao: "OBS 2", status: 'Andamento'},
            ]
        },
        {id: 102, material: "Matematica Discreta", traducao: "brille", status: 'rejeitado',
            parteMaterial: [
                {id: 01, parte: 1, responsavel: "Antonio Souza", inicio: 01, fim: 100, revisao: "Isabela Oliveira", observacao: "OBS 1", status: 'Andamento'},
                {id: 02, parte: 2, responsavel: "Antonio Souza", inicio: 101, fim: 200, revisao: "Isabela Oliveira", observacao: "OBS 2", status: 'Andamento'},
            ]

        }
    ];

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
        window.location = '#/ordemproducao';
    };

    $scope.carregarOrdemProducao = function() {

        if (!$routeParams.ordemProducaoId) {
            $scope.ordemProducao = getNovaOrdemProducao();
            console.log('carregando ordem de produção ', $scope.ordemProducao);
            return;//se não tiver id não buscar
        }

        for (var i = 0; i < $scope.ordensProducao.length; i++)
            if ($scope.ordensProducao[i].id == $routeParams.ordemProducaoId)
                $scope.ordemProducao = $scope.ordensProducao[i];

        /*
         $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
         .success(function(ordemProducao, status) {
         $scope.ordemProducao = ordemProducao;
         });
         */
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

    /*
     $scope.getTodos = function(numeroPagina) {
     console.log(numeroPagina);
     $http.get('./rest/ordemProducaoSource/listar/pag/' + numeroPagina)
     .success(function(ordenProducaoPage, status) {
     $scope.ordensProducao = ordenProducaoPage.list;
     })
     .error(function(data, status) {
     alert(data.message);//TODO: Implementar tag no html para popular com a mensagem
     console.log('erro ao buscar ordensProducao ' + data.developerMessage );
     });
     };
     */

    function getNovaOrdemProducao() {
        console.log('nova ordem de produção');
        return {
            state: "ANDAMENTO"
        };
    }

    $scope.voltar = function() {
        $scope.ordemProducao = {};
        window.location = '#/listaordemproducao';
    };
    
    $scope.cancelarParteMaterial = function() {
        $scope.parteMaterial = {};
        window.location = '#/ordemproducao/' + $routeParams.ordemProducaoId;
    };

    $scope.novaParteMaterial = function(ordemProducao) {
        $scope.parteMaterial = {};
        window.location = '#/cadastropartematerial/'+ ordemProducao.id;        
    }

    $scope.carregarParteMaterial = function() {
        console.log('parte link Material: ' + $routeParams.ordemProducaoId + ' - ' + $routeParams.parteMaterialId);
        
        if(!$routeParams.parteMaterialId){
            $scope.parteMaterial = {};
            for (var i = 0; i < $scope.ordensProducao.length; i++) {
                if ($scope.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                    console.log('parte material: ' + $scope.ordensProducao[i].parteMaterial.length);
                    $scope.parteMaterial.parte = $scope.ordensProducao[i].parteMaterial.length +1;
                    return;
                }
            }
        }    

        for (var i = 0; i < $scope.ordensProducao.length; i++) {
            if ($scope.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                for (var j = 0; j < $scope.ordensProducao[i].parteMaterial.length; j++) {
                    if ($scope.ordensProducao[i].parteMaterial[j].id == $routeParams.parteMaterialId) {
                        $scope.parteMaterial = $scope.ordensProducao[i].parteMaterial[j];
                    }
                }
            }
        }

        console.log('Parte material: ' + $scope.parteMaterial.parte);

        /*
         for(var i=0; i<$scope.ordemProducao[$routeParams.parteMaterialId].parteMaterial.length; i++)
         if($scope.ordemProducao[i].parteMaterial.id == $routeParams.parteMaterialId )
         $scope.parteMaterial = $scope.ordemProducao[i].parteMaterial;
         */
    };

    $scope.editarParteMaterial = function(ordemProducao, parteMaterial) {
        console.log('link: ' + ordemProducao.id + '-' + parteMaterial.id);
        window.location = '#/cadastropartematerial/' + ordemProducao.id + '/' + parteMaterial.id;
    };

    $scope.salvarParteMaterial = function() {
        for (var i=0; i<$scope.ordensProducao.length; i++) {
            if ($scope.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                console.log('Ordem id: ' + $scope.ordensProducao[i].id);
                for (var j=0; j<$scope.ordensProducao[i].parteMaterial.length; j++) {
                    if ($scope.ordensProducao[i].parteMaterial[j].parte == $scope.parteMaterial.parte) {
                        return;
                    }else{
                        $scope.ordensProducao[i].parteMaterial.push($scope.parteMaterial);
                        $scope.parteMaterial = {};
                        console.log($scope.ordensProducao);
                        return;
                    }
                }
            }
        }
        

    };
}
