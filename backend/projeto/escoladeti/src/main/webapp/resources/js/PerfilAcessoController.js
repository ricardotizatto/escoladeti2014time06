'use strict';

function perfilAcessoController($scope, $http, $routeParams) {

    $scope.novo = function() {
        $scope.perfilAcesso = getNovoPerfilDeAcesso();
        window.location = '#/cadastroperfilacesso';
    };

    $scope.salvar = function() {
        console.log($scope.perfilAcesso);
        $http.post("./rest/perfilAcessoSource/perfilAcesso", $scope.perfilAcesso)
                .success(function(perfilAcesso, status) {
                    $scope.perfilAcesso = getNovoPerfilDeAcesso();
                    console.log('Perfil de acesso salvo ' + perfilAcesso);
                })
                .error(function(data, status) {
                    console.log('Erro ao salvar ' + data);
                });
    };
    
    $scope.itensAcesso = getItensAcesso();
    //$scope.itensAcesso = [{nomeComponente : 'Componente1'},{nomeComponente : 'Componente1'}]

    $scope.getTodos = function() {
        $http.get("./rest/perfilAcessoSource/perfilAcesso")
                .success(function(perfils, status) {
                    $scope.perfilsAcesso = perfils;
                }).error(function(data, status) {
            console.log('Erro ao carregar perfis de acesso! ' + data);
        });
    };

    $scope.carregarPerfil = function() {
        if ($routeParams.perfilAcessoId) {
            $http.get('./rest/perfilAcessoSource/perfilAcesso/' + $routeParams.perfilAcessoId)
                    .success(function(perfilAcesso, status) {
                        $scope.perfilAcesso = perfilAcesso;
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
    };
    
    function getItensAcesso(){
        console.log('Carregando itens');
        $http.get('./rest/itemAcessoSource/itemAcesso')
                .success(function(itensDeAcesso){
                    $scope.itensAcesso = itensDeAcesso;
                });
        };
}