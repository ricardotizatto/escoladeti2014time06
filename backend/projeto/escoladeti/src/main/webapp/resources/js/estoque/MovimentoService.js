services = angular.module("services");

function movimentoService($http) {
    return {
//        deletar: function(movimento) {
//
//            var movimentacao = {
//                tipo: movimento.tipo,
//                quantidade: movimento.quantidade,
//                dataMovimentacao: movimento.dataMovimentacao,
//                pessoaOrigem: movimento.pessoaOrigem.id,
//                pessoaDestino: movimento.pessoaDestino.id,
//                produto: movimento.produto.id
//            }
//            return $http({
//                method: 'DELETE',
//                data: movimentacao,
//                url: './rest/movimentacaoSource/movimentacao/' + movimento.id,
//                headers: {'Content-Type': 'application/json; charset=UTF-8'}
//            });
//        },
        buscarPorNome: function(filtro) {
            return $http.get('./rest/movimentacaoSource/movimento?q=' + filtro.toUpperCase());
        },
        buscar: function(movimentoId) {
            return $http.get('./rest/movimentacaoSource/movimentacao/' + movimentoId);
        },
        salvar: function(movimentacao) {
            return $http.post('./rest/movimentacaoSource/movimentacao', {
                tipo: movimentacao.tipo,
                quantidade: movimentacao.quantidade,
                dataMovimentacao: movimentacao.dataMovimentacao,
                referencia: movimentacao.referencia,
                produto: movimentacao.produto
            });
        },
        extornar: function(movimentacao) {
            return $http.post('./rest/movimentacaoSource/extornar/'+movimentacao.id);
        },
//        atualizar: function(movimento, $routeParams) {
//            return $http.post("./rest/movimentacaoSource/movimentacao/" + $routeParams.movimentoId, {
//                tipo: movimento.tipo,
//                quantidade: movimento.quantidade,
//                dataMovimentacao: movimento.dataMovimentacao,
//                pessoaOrigem: movimento.pessoaOrigem,
//                pessoaDestino: movimento.pessoaDestino,
//                produto: movimento.produto
//            });
//        },
        listar: function(nrPagina) {
            return $http.get("./rest/movimentacaoSource/paginar/" + nrPagina);
        },
        listarPessoas: function() {
            return $http.get('./rest/pessoas/getTodos');
        },
        listarProdutos: function() {
            return $http.get('./rest/produtoSource/produtos');
        },
        buscarTodos: function() {
            return $http.get("./rest/movimentacaoSource/listar/pag/" + numeroPagina);
        }
    };
}

services.factory('movimentoService', ['$http', movimentoService]);

