function OrdemProducaoController($scope, $http, $routeParams, bd) {
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
                            bd.getTodos(1);
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
                bd.getTodos(1);
            }
        });
    };

    $scope.novo = function() {
        window.location = '#/ordemproducao';
    };

    $scope.carregarOrdemProducao = function() {

        if (!$routeParams.ordemProducaoId) {
            $scope.ordemProducao = getNovaOrdemProducao();
            console.log('carregando ordem de produção ', bd.ordemProducao);
            return;//se não tiver id não buscar
        }

        for (var i=0; i<bd.ordensProducao.length; i++){
            if (bd.ordensProducao[i].id == $routeParams.ordemProducaoId)
                $scope.ordemProducao = bd.ordensProducao[i];
                console.log('carregando ordem de producao ', $scope.ordemProducao);
        }    
    };

    $scope.editar = function(ordemProducao) {
        window.location = '#/ordemproducao/' + ordemProducao.id;
    };

    $scope.salvar = function() {
        $http.post('./rest/ordemProducaoSource/ordemProducao', bd.ordemProducao)
                .success(function(ordemProducao, status) {
                    bd.ordemProducao = getNovaOrdemProducao();
                    console.log('ordemProducao editado = ' + ordemProducao);
                    bd.info.message = 'Salvo com sucesso';
                    bd.info.status = 'success';
                })
                .error(function(data, status) {
                    console.log('ordemProducao não salvo = ' + data);
                    bd.info = {};
                    bd.info.status = 'danger';
                    console.log(bd.info);
                    bd.info.message = data.message;
                });
    };
    
    $scope.getTodos = function(numeroPagina){
        bd.ordensProducao = [
            {id: 101, material: "Gerenciamento de Projetos", traducao: "brille", status: 'ANDAMENTO',
                parteMaterial: [
                    {id: 1, parte: 1, responsavel: "Jose da Silva", inicio: 01, fim: 100, revisao: "Maria Pereira", observacao: "OBS 1", status: 'ANDAMENTO'},
                    {id: 2, parte: 2, responsavel: "Jose da Silva", inicio: 101, fim: 200, revisao: "Maria Pereira", observacao: "OBS 2", status: 'ANDAMENTO'},
                    {id: 3, parte: 3, responsavel: "Sebastiao da Costa", inicio: 201, fim: 300, revisao: "Jose da Silva", observacao: "OBS 3", status: 'REJEITADO'},
                ]
            },
            {id: 102, material: "Matematica Discreta", traducao: "brille", status: 'ANDAMENTO',
                parteMaterial: [
                    {id: 1, parte: 1, responsavel: "Antonio Souza", inicio: 01, fim: 100, revisao: "Isabela Oliveira", observacao: "OBS 1", status: 'FINALIZADO'},
                    {id: 2, parte: 2, responsavel: "Antonio Souza", inicio: 101, fim: 200, revisao: "Isabela Oliveira", observacao: "OBS 2", status: 'FINALIZADO'},
                ]

            }
        ];
        
        $scope.ordensProducao = bd.ordensProducao;
    }

    /*
     $scope.getTodos = function(numeroPagina) {
     console.log(numeroPagina);
     $http.get('./rest/ordemProducaoSource/listar/pag/' + numeroPagina)
     .success(function(ordenProducaoPage, status) {
     bd.ordensProducao = ordenProducaoPage.list;
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
        bd.ordemProducao = {};
        window.location = '#/listaordemproducao';
    };
    
    $scope.cancelarParteMaterial = function() {
        bd.parteMaterial = {};
        window.location = '#/ordemproducao/' + $routeParams.ordemProducaoId;
    };

    $scope.novaParteMaterial = function(ordemProducao) {
        bd.parteMaterial = {};
        window.location = '#/cadastropartematerial/'+ ordemProducao.id;        
    }

    $scope.carregarParteMaterial = function() {
        console.log('parte link Material: ' + $routeParams.ordemProducaoId + ' - ' + $routeParams.parteMaterialId);
        
        if(!$routeParams.parteMaterialId){
            $scope.parteMaterial = {};
            for (var i = 0; i < bd.ordensProducao.length; i++) {
                if (bd.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                    console.log('parte material: ' + bd.ordensProducao[i].parteMaterial.length);
                    $scope.parteMaterial.parte = bd.ordensProducao[i].parteMaterial.length +1;
                    $scope.parteMaterial.status = 'ANDAMENTO';
                    return;
                }
            }
        }    

        for (var i=0; i<bd.ordensProducao.length; i++) {
            if (bd.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                for (var j=0; j<bd.ordensProducao[i].parteMaterial.length; j++) {
                    if (bd.ordensProducao[i].parteMaterial[j].id == $routeParams.parteMaterialId) {
                        $scope.parteMaterial = bd.ordensProducao[i].parteMaterial[j];
                    }
                }
            }
        }

        console.log('Parte material: ' + $scope.parteMaterial.parte);

        /*
         for(var i=0; i<bd.ordemProducao[$routeParams.parteMaterialId].parteMaterial.length; i++)
         if(bd.ordemProducao[i].parteMaterial.id == $routeParams.parteMaterialId )
         bd.parteMaterial = bd.ordemProducao[i].parteMaterial;
         */
    };

    $scope.editarParteMaterial = function(ordemProducao, parteMaterial) {
        console.log('link: ' + ordemProducao.id + '-' + parteMaterial.id);
        window.location = '#/cadastropartematerial/' + ordemProducao.id + '/' + parteMaterial.id;
    };

    $scope.salvarParteMaterial = function() {
        $scope.parteMaterial.id = $scope.parteMaterial.parte;
        
        for (var i=0; i<bd.ordensProducao.length; i++) {
            if (bd.ordensProducao[i].id == $routeParams.ordemProducaoId) {
                console.log('Ordem id: ' + bd.ordensProducao[i].id);
                for (var j=0; j<bd.ordensProducao[i].parteMaterial.length; j++) {
                    if (bd.ordensProducao[i].parteMaterial[j].parte == $scope.parteMaterial.parte) {
                        return;
                    }else{
                        bd.ordensProducao[i].parteMaterial.push($scope.parteMaterial);
                        toastr.success('Parte : '+ $scope.parteMaterial.parte +" salva!");
                        $scope.parteMaterial = {};
                        console.log(bd.ordensProducao);
                        return;
                    }
                }
            }
        }
        

    };
    
    $scope.deletarParteMaterial = function(ordemProducao, parteMaterial) {
        console.log('link deletar parte material: ' + ordemProducao.id + ' ' + parteMaterial.id);

        var index = parteMaterial.id - 1;

        for (var i=0; i<bd.ordensProducao.length; i++) {
            if (bd.ordensProducao[i].id == ordemProducao.id) {
                for (var j=0; j<bd.ordensProducao[i].parteMaterial.length; j++) {
                    if (bd.ordensProducao[i].parteMaterial[j].id == parteMaterial.id) {
                        bd.ordensProducao[i].parteMaterial.splice(index,1);
                        toastr.success('Parte : '+ parteMaterial.id +" Deletada com sucesso!");
                        carregarParteMaterial(); 
                    }
                }
            }
        }                 
    };
    
    $scope.finalizarOrdemProducao = function(ordemProducao){
        console.log('Finalizar Ordem Produção: ' + ordemProducao.id);
        for (var i=0; i<bd.ordensProducao.length; i++) {
            if (bd.ordensProducao[i].id == ordemProducao.id) {
                for (var j = 0; j < bd.ordensProducao[i].parteMaterial.length; j++) {
                    if (bd.ordensProducao[i].parteMaterial[j].status != "FINALIZADO") {
                        toastr.success('A Ordem de Producao: '+ bd.ordensProducao[i].id +" nao pode ser finalizada, porque existe parte(s) que ainda nao foram finalizada(s)!");
                        carregarParteMaterial();
                    }else{
                        bd.ordensProducao[i].status = 'FINALIZADO';
                        toastr.success('Ordem de Producao: '+ bd.ordensProducao[i].id +" Finalizada!");
                        carregarParteMaterial();
                    }
                }
            }
        }  
    };
}
