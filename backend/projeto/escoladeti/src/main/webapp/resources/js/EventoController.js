function eventoController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.idCurso;
    $scope.tituloCurso;
    $scope.DetalhesCurso;
    $scope.localCurso;
    $scope.dataCurso;
    $scope.inicio;
    $scope.fim;
    $scope.ministrante;
    $scope.tipoEvento;
    $scope.valor;

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

    $scope.listarParticipantes = function(evento) {
        console.log(evento);
        window.location = '#/listaparticipantes/' + evento.id;

    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.evento, true));
        
            if ($scope.evento.inicio > $scope.evento.fim){
                $scope.info = {};
                $scope.info.status = 'danger';
                $scope.info.message = 'A hora de inicio não pode ser maior que a hora do encerramento do evento';   
            }
            else{
                    $http.post("./rest/eventoSource/evento", $scope.evento)
                            .success(function(evento, status) {
                                //$scope.evento = getNovoEvento();
                                window.location = '#/listaevento';
                                console.log("evento salva = " + evento);
                            })
                            .error(function(data, status) {
                                console.log("erro ao salvar evento", data);
                            });
                }
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

    $scope.carregarEventoDetalhes = function(indice, titulo, detalhes, local, data) {
        $scope.idCurso = indice;
        $scope.tituloCurso = titulo;
        $scope.DetalhesCurso = detalhes;
        $scope.localCurso = local;
        $scope.dataCurso = data;
    };

    function getNovoEvento() {
        console.log('novo evento');
        return {};
    }
    ;
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}
