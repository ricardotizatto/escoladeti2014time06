var services = angular.module('services');

function EstadoService($http) {
    return {
        salvar: function(estado) {
            return $http.post("./rest/unidadeFederativaSource/unidadeFederativa", {
                nome: estado.nome.toUpperCase(),
                pais: estado.pais,
                sigla: estado.sigla.toUpperCase(),
                id: estado.id
            });
        },
        deletar: function(unidadeFederativa) {
            return $http({
                method: 'DELETE',
                data: unidadeFederativa,
                url: './rest/unidadeFederativaSource/unidadeFederativa',
                headers: {'Content-Type': 'application/json; charset=UTF-8'}
            });
        },
        buscar: function(estadoId) {
            return $http.get('./rest/unidadeFederativaSource/unidadeFederativa/' + estadoId);
        },
        buscarPorNome: function(filtro) {
            return $http.get('./rest/unidadeFederativaSource/unidadeFederativa?q=' + filtro.toUpperCase());
        },
        listar: function(nrPagina) {
            return $http.get('./rest/unidadeFederativaSource/listar/pag/' + nrPagina);
        },
        buscarTodos: function () {
			return $http.get('./rest/unidadeFederativaSource/listar');
		}

    };
}

services.factory('estadoService', ['$http', EstadoService]); 