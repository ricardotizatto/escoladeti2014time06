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

    $scope.getTodos = function() {
        $http.get('./rest/itemAcessoSource/itemAcesso')
                .success(function(itensAcesso) {
                    $scope.itensAcesso = itensAcesso;
                    console.log('Telas carregadas');
                });
    };

    $scope.cancelarTela = function() {
        window.location = '#/listaitemacesso';
    };

    function getNovoItemAcesso() {
        return {};
    }
}