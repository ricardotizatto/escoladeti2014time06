'use strict';

function OrdemProducaoController ($scope, $http, $routeParams){
    
    $scope.novo = function() {
        $scope.ordemProducao = getNovaOrdemProducao ();
        window.location = '#/listaordemproducao';
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
        if ($routeParams.ordemProducaoId) {
            $http.get('./rest/ordemProducaoSource/ordemProducao/' + $routeParams.ordemProducaoId)
                    .success(function(ordemProducao) {
                        $scope.ordemProducao = ordemProducao;
            });
        }
    };
    
    $scope.getTodos = function() {
        $http.get('./rest/ordemProducaoSource/ordemProducao')
                .success(function(ordemProducao) {
                  $scope.ordemProducao = ordemProducao;
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
        window.location = '$/listaordemproducao';
    };
    
    function getNovaOrdemProducao() {
        return {};
    }
}