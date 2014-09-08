function eventoController($scope, $http, $routeParams) {

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
        console.log('id lopuca' + evento.id);
        window.location = '#/cadastroevento/' + evento.id;
    };

    $scope.deletar = function(evento) {
        console.log('deletando evento ' + JSON.stringify(evento));

        BootstrapDialog.confirm('Deseja realmente deletar o Evento: <b>' + evento.titulo + '</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: evento,
                    url: './rest/eventoSource/evento',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                        .success(function(data, status) {
                            $scope.getTodos(1);
                            console.log('evento deletado');
                            BootstrapDialog.show({
                                title: 'Notifica&ccedil;&atilde;o',
                                message: 'Evento <b>' + evento.titulo + '</b> deletado com Sucesso!',
                                type: BootstrapDialog.TYPE_SUCCESS,
                                buttons: [{
                                        id: 'btn-ok',
                                        icon: 'glyphicon glyphicon-ok',
                                        label: ' OK',
                                        cssClass: 'btn-success btn-padrao',
                                        autospin: false,
                                        action: function(dialogRef) {
                                            dialogRef.close();
                                        }
                                    }]
                            });
                        })
                        .error(function(data, status) {
                            console.log('erro ao deletar evento ' + data);
                            BootstrapDialog.show({
                                title: 'Notifica&ccedil;&atilde;o',
                                message: 'Ocorreu um erro ao deletar o Evento: <b>' + evento.titulo + '</b>',
                                type: BootstrapDialog.TYPE_DANGER,
                                buttons: [{
                                        id: 'btn-ok',
                                        icon: 'glyphicon glyphicon-ok',
                                        label: ' OK',
                                        cssClass: 'btn-success btn-padrao',
                                        autospin: false,
                                        action: function(dialogRef) {
                                            dialogRef.close();
                                        }
                                    }]
                            });
                        });
            } else {
                $scope.getTodos(1);
            }
        });
    };


    $scope.listarParticipantes = function(evento) {
        console.log(evento);
        window.location = '#/listaparticipantes/' + evento.id;

    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.evento, true));
//          $http.post("./rest/eventoSource/evento", $scope.evento)
        $http.post("./rest/eventoSource/evento", $scope.evento)
                .success(function(evento, status) {
                    $scope.evento = getNovoEvento();
                    window.location = '#/listaevento';
                    toastr.success("Evento cadastrado com sucesso!");
                    console.log("evento salva = " + evento);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar evento", data);
                    toastr.warning("Erro ao salvar evento!");
                });
//        }
    };

    $scope.novo = function() {
        $scope.evento = getNovoEvento();
        window.location = '#/cadastroevento';
    };

    $scope.getTodos = function(numeroPagina) {

        $http.get("./rest/eventoSource/listar/pag/" + numeroPagina)
                .success(function(listaEventos, status) {
                    $scope.eventos = listaEventos;
                })
                .error(function(data, status) {
                    console.log('erro ao buscar eventos' + data);
                });
    };           

    $scope.carregarEvento = function() {
        if (!$routeParams.eventoId) {
            $scope.evento = {};
            return;
        }
        $http.get('./rest/eventoSource/evento/' + $routeParams.eventoId)
                .success(function(ev) {
                    $scope.evento = ev;
                    return;
                });
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


    $scope.voltar = function() {
        $scope.evento = {};
        window.location = '#/listaevento';
    };
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}



