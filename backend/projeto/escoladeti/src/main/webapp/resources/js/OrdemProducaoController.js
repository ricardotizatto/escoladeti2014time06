'use strict';

function OrdemProducaoController ($scope, $http, $routeParams){
    
    $scope.novo = function() {
        $scope.ordemProducao = getNovaOrdemProducao ();
        window.location = '#/ordemproducao';
    };
    
    $scope.salvar = function() {
        $http.post('.rest/ordemProducaoSource/ordemProducao', $scope.ordemProducao)
                .success(function(ordemProducao, status) {
                    $scope.ordemProducao = getNovaOrdemProducao();
                    console.log('Ordem de Producao salva ' + ordemProducao);
                })
                .error(function(data){
                    console.log('Ordem de Producao nao foi salva' + data);
                });
    };
    
    $scope.carregar = function() {
        //$scope.ordemProducao = { solicitacao : 1, material : "Livro", traducao:"brille", state : "Andamento" }; para testes
        if ($routeParams.ordemProducaoId) {
            $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
                    .success(function(ordemProducao) {
                        $scope.ordemProducao = ordemProducao;
            });
        }
    };
    
    $scope.getTodos = function() {
        $http.get('./rest/ordemProducaoSource/ordemproducao')
                .success(function(ordensProducao) {
                  $scope.ordensProducao = ordensProducao;
                  console.log('Ordens carregadas.');
                });
    };
    
    $scope.editar = function(ordemProducao) {
        console.log(ordemProducao);
        window.location = '#/ordemproducao' + ordemProducao.id;
    };
    
    $scope.deletar = function(ordemProducao) {
        $http({
            method: 'DELETE',
            data: ordemProducao,
            url: '.rest/ordemProducaoSource/ordemProducao',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
                    console.log('Deletado !');
                    $scope.getTodos();
        })
                .error(function(data) {
                    console.log('Nao foi possivel deletar ' + data);
        });
    };
    
    $scope.cancelar = function() {
        window.location = '#/listaordemproducao';
    };
    
    function getNovaOrdemProducao() {
        return {};
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
                return "";
        }
    };
    
    //
    //Início das funções da ParteMaterial
    //
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