function eventoController($scope, $http, $routeParams) {
    console.log('carregando controller');

    $scope.deletar = function(evento) {
        /*  $http.delete('./rest/eventoSource/evento', evento)
         .success(function(data, status) {
         console.log('deletado');
         })
         .error(function(data, status) {
         console.log('erro ao deletar '+data);
         }); */
        console.log('deletando evento ' + JSON.stringify(evento));
        $http({
            method: 'DELETE',
            data: evento,
            url: './rest/eventoSource/evento',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data, status) {
                    $scope.getTodos();
                    console.log('evento deletado');
                }).error(function(data, status) {
            console.log('erro ao deletar evento ' + data);
        });
    };

    $scope.novo = function() {
        $scope.evento = getNovoEvento();
        window.location = '#/cadastroevento';
    }

    $scope.carregarEventos = function() {
        console.log('carregando evento');
        if (!$routeParams.eventoId)
            return;//se não tiver id não buscar

        $http.get('./rest/eventoSource/evento/' + $routeParams.eventoId)
                .success(function(evento, status) {
                    $scope.evento = evento;
                });
    }

    $scope.editar = function(evento) {
        window.location = '#/cadastroevento/' + evento.id;
    }

    $scope.salvar = function() {
        $http.post('./rest/eventoSource/evento', $scope.evento)
                .success(function(evento, status) {
                    $scope.evento = getNovoEvento();
                    console.log('evento salvo = ' + evento);
                })
                .error(function(data, status) {
                    console.log('erro ao salvar ' + data);
                });
        ;
    }

    $scope.getTodos = function() {
        $http.get('./rest/eventoSource/evento')
                .success(function(eventos, status) {
                    $scope.eventos = eventos;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar eventos ' + data);
                });
    }

    function getNovoEvento() {
        console.log('novo evento');
        return {};
    }


}