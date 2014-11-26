services = angular.module("services");

function produtoService($http) {
    return {
        deletar: function(produto) {
            return $http({
                method: 'DELETE',
                data: produto,
                url: './rest/produtoSource/produto',
                headers: {'Content-Type': 'application/json; charset=UTF-8'}
            });
        },
        buscarPorNome: function(filtro) {
            return $http.get('./rest/produtoSource/produto?q=' + filtro.toUpperCase());
        },
        buscar: function(produtoId) {
            return $http.get('./rest/produtoSource/produto/' + produtoId);
        },
        salvar: function(produto) {
            return $http.post('./rest/produtoSource/produto', {
            });
        },
        atualizar: function(produto, $routeParams) {
            return $http.put("./rest/produtoSource" + $routeParams.produtoId, {
            });
        },
        listar: function(nrPagina) {
            return $http.get("./rest/produtoSource/paginar/" + nrPagina);
        },
        buscarTodos: function() {
            return $http.get('./rest/produtoSource/listar');
        }
    };
}

services.factory('produtoService', ['$http', produtoService]);

