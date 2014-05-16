'use strict';

function perfilAcessoController($scope, $http, $routeParams) {

    $scope.novo = function() {
        $scope.perfilDeAcesso = getNovoPerfilDeAcesso();
        window.location = '#/cadastroperfilacesso';
    };

    $scope.salvar = function() {
        console.log($scope.perfilDeAcesso);
        $http.post("./rest/perfilAcessoSource/perfilAcesso", $scope.perfilDeAcesso)
                .success(function(perfilDeAcesso, status) {
                    $scope.perfilDeAcesso = getNovoPerfilDeAcesso();
                    console.log('Perfil de acesso salvo ' + perfilDeAcesso);
                })
                .error(function(data, status) {
                    console.log('Erro ao salvar ' + data);
                });
    };

    $scope.getTodos = function() {
        $http.get("./rest/perfilAcessoSource/perfilAcesso")
                .success(function(perfils, status) {
                    $scope.perfilsDeAcesso = perfils;
                }).error(function(data, status) {
            console.log('Erro ao carregar perfils ! ' + data);
        });
    };

    $scope.carregarPerfil = function() {
        if ($routeParams.perfilAcessoId) {
            $http.get('./rest/perfilAcessoSource/perfilAcesso/' + $routeParams.perfilAcessoId)
                    .success(function(perfilAcesso, status) {
                        $scope.perfilDeAcesso = perfilAcesso;
                    });
        }
    };

    $scope.editar = function(perfil) {
        window.location = '#/cadastroperfilacesso/' + perfil.id;
    };

    $scope.deletar = function(perfil) {
        $http({
            method: 'DELETE',
            data: perfil,
            url: './rest/perfilAcessoSource/perfilAcesso',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data, status) {
                    $scope.getTodos();
                    console.log('Perfil deletado!' + data)
                })
                .error(function(data, status) {
                    console.log('Perfil não foi deletado' + data);
                });
    };

    $scope.cancelar = function() {
        window.location = '#/listaperfilacesso';
    };

    function getNovoPerfilDeAcesso() {
        return {};
    }
    ;
}