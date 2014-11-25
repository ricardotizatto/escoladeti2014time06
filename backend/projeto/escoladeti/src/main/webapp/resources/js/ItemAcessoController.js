function itemAcessoController($scope, $http, $routeParams) {

    $scope.itemAcesso;
    $scope.meuMenu;
    $scope.menus;
    $scope.subMenus;

    $scope.novo = function() {
        $scope.itemAcesso = getNovoItemAcesso();
        $scope.menus = $scope.getMenus();
        window.location = '#/cadastroitemacesso';
    };

    $scope.salvar = function() {
        $http.post('./rest/itemAcessoSource/itemAcesso', $scope.itemAcesso)
                .success(function(itemAcesso, status) {
                    $scope.itemAcesso = getNovoItemAcesso();
                    toastr.success("Item de Acesso salvo com sucesso!");
                    console.log('Item de Acesso salva ' + itemAcesso);
                })
                .error(function(data) {
                    toastr.warning("Erro ao salvar o item de acesso!");
                    console.log('Tela nao foi salva ' + data);
                });
    };
    $scope.carregarItemAcesso = function() {
        if ($routeParams.itemAcessoId) {
            $http.get('./rest/itemAcessoSource/itemAcesso/' + $routeParams.itemAcessoId)
                    .success(function(itemAcesso) {
                        $scope.itemAcesso = itemAcesso;
                    });
        } else {
            $scope.novo();
        }
    };

    $scope.getTodos = function() {
        $http.get('./rest/itemAcessoSource/itemAcesso')
                .success(function(itensAcesso) {
                    $scope.itensAcesso = itensAcesso;
                    console.log('Telas carregadas');
                });
    };

    $scope.getSubMenus = function() {
        $http.post('./rest/subMenuSource/subMenu/', $scope.meuMenu.id)
                .success(function(subMenus) {
                    $scope.subMenus = subMenus;
                    console.log('Sub menus carregados');
                    console.log(angular.toJson($scope.meuMenu, true));
                    console.log(angular.toJson($scope.subMenus, true));
                })
                .error(function(data) {
                    console.log('Não foi possivel carregar os sub menus ' + data);
                });
    };

    $scope.getMenus = function() {
        $http.get('./rest/menuSource/menu/')
                .success(function(menus) {
                    $scope.menus = menus;
                    console.log('Menus carregados');
                })
                .error(function(data) {
                    console.log('Não foi possivel carregar os menus ' + data);
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