function eventoController($scope, $http, $routeParams) {
    console.log('Carregando controller');

    $scope.editar = function(evento) {
        console.log(evento);
        window.location = '#/cadastroevento/' + evento.id;
    };

    $scope.deletar = function(evento) {
        alert(evento.titulo);
        $http({
            method: 'DELETE',
            data: evento,
            url: './rest/eventoSource/evento',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
            .success(function(data) {
                console.log("evento deletado");
                 $scope.getTodos();
            }).error(function(data) {
            console.log("erro ao deletar evento ");
        });
    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.evento, true));
        $http.post("./rest/eventoSource/evento", $scope.evento)
                .success(function(evento, status) {
                    $scope.evento = getNovoEvento();
                    console.log("evento salva = " + evento);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar evento" + data);
                });
    };

    $scope.novo = function() {
        $scope.evento = getNovoEvento();
        window.location = '#/cadastroevento';
    };

    $scope.getTodos = function() {

        $http.get("./rest/eventoSource/evento")
            .success(function(eventos, status) {
                $scope.eventos = eventos;
            })
            .error(function(data, status) {
                console.log('erro ao buscar eventos');
            });
    };

    $scope.carregarEvento = function() {
        if ($routeParams.eventoId) {
            $http.get('./rest/eventoSource/evento/' + $routeParams.eventoId)
                .success(function(evento) {
                    $scope.evento = evento;
                });
        }
    };

    function getNovoEvento() {
        console.log('novo evento');
        return {};
    };
}