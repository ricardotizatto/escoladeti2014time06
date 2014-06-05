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
        if (!$routeParams.ordemProducaoId)
            return;//se não tiver id não buscar

        $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
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
    
    $scope.voltar = function() {
        $scope.OrdemProducao = {};
        window.location = '#/listaordemproducao';
    }
    
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