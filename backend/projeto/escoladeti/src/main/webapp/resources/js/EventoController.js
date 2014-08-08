function eventoController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.idCurso;
    $scope.tituloCurso;
    $scope.descricao;
    $scope.local;
    $scope.data;
    $scope.inicio;
    $scope.fim;
    $scope.ministrante;
    $scope.organizacao;
    $scope.tipoEvento;
    $scope.valor;

    $scope.editar = function(evento) {
        console.log(evento);
        window.location = '#/cadastroevento/' + evento.id;
    };

    $scope.deletar = function(evento) {
        $http({
            method: 'DELETE',
            data: evento,
            url: './rest/eventoSource/evento',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
                    console.log("evento deletado");
                    toastr.success("Evento apagado com sucesso!");
                    $scope.getTodos();
                }).error(function(data) {
            console.log("erro ao deletar evento ");
            toastr.warning("Erro ao apagar evento!");
        });
    };

    $scope.listarParticipantes = function(evento) {
        console.log(evento);
        window.location = '#/listaparticipantes/' + evento.id;

    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.evento, true));

        if($scope.evento.titulo === undefined)
            return toastr.warning('Preencha o campo titulo');
        
        if($scope.evento.tipoEvento === undefined)
            return toastr.warning('Escolha um tipo de evento');

        if($scope.evento.organizacao === undefined)
            return toastr.warning('Preencha o campo Realização');
         
        if($scope.evento.valor === undefined){
            return toastr.warning('Preencha o campo Valor');
        }else{
            $scope.evento.valor = $scope.evento.valor.replace(',', '.');
        }
        
        if($scope.evento.ministrante === undefined)
            return toastr.warning('Preencha o campo Ministrante');
        
        if($scope.evento.descricao === undefined)
            return toastr.warning('Preencha o campo Descrição do Evento');
        
        if($scope.evento.local === undefined)
            return toastr.warning('Preencha o campo Local');
        
        if($scope.evento.data === undefined)
            return toastr.warning('Preencha o campo Data');
        
        if($scope.evento.inicio === undefined)
            return toastr.warning('Preencha o campo Início');
        
        if($scope.evento.fim === undefined)
            return toastr.warning('Preencha o campo Término');
        
        if ($scope.evento.inicio > $scope.evento.fim) {
            toastr.warning('A hora de inicio não pode ser maior que a hora do encerramento do evento');
        } else {
            $http.post("./rest/eventoSource/evento", $scope.evento)
            .success(function(evento, status) {
                //$scope.evento = getNovoEvento();
                //window.location = '#/listaevento';
                toastr.success("Evento cadastrado com sucesso!");
                setTimeout(function(){window.location="#/listaevento"}, 5000);
                console.log("evento salva = " + evento);
            })
            .error(function(data, status) {
                console.log("erro ao salvar evento", data);
                toastr.warning("Erro ao salvar evento!");
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


