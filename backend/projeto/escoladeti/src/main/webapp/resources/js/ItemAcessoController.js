'use strict;'

function itemAcessoController($scope, $http, $routeParams) {

    $scope.novo = function() {
        $scope.itemAcesso = getNovoItemAcesso();
        window.location = '#/cadastroitemacesso';
    };

    $scope.salvar = function() {
        $http.post('./rest/itemAcessoSource/itemAcesso', $scope.itemAcesso)
                .success(function(itemAcesso, status) {
                    $scope.itemAcesso = getNovoItemAcesso();
                    console.log('Item de Acesso salva ' + itemAcesso);
                })
                .error(function(data) {
                    console.log('Tela nao foi salva ' + data);
                });
    };
    $scope.carregarItemAcesso = function() {
        if ($routeParams.itemAcessoId) {
            $http.get('./rest/itemAcessoSource/itemAcesso/' + $routeParams.itemAcessoId)
                    .success(function(itemAcesso) {
                        $scope.itemAcesso = itemAcesso;
                    });
        }
    };

    $scope.getTodos = function() {
        $http.get('./rest/itemAcessoSource/itemAcesso')
                .success(function(itensAcesso) {
                    $scope.itensAcesso = itensAcesso;
                    console.log('Telas carregadas');
                });
    };

    $scope.editar = function(itemAcesso) {
        console.log(itemAcesso);
        window.location = '#/cadastroitemacesso/' + itemAcesso.id;
    };

    $scope.deletar = function(itemAcesso) {
        $http({
            method: 'DELETE',
            data: itemAcesso,
            url: './rest/itemAcessoSource/itemAcesso',
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
        window.location = '#/listaitemacesso';
    };

    function getNovoItemAcesso() {
        return {};
    }
}