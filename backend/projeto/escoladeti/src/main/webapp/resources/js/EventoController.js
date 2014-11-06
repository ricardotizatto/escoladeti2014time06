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
    $scope.selected;
    $scope.indicePeriodo = {};

    $scope.editar = function (evento) {
        console.log(evento);
        window.location = '#/cadastroevento/' + evento.id;
    };
    $scope.chamadaPeriodo = function (id) {
        window.location = '#/chamada/' + id;
    };
    

    $scope.deletar = function (evento) {
        console.log('deletando evento ' + JSON.stringify(evento));

        BootstrapDialog.confirm('Deseja realmente deletar o Evento: <b>' + evento.titulo + '</b>?', function (result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: evento,
                    url: './rest/eventoSource/evento',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                        .success(function (data, status) {
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
                                        action: function (dialogRef) {
                                            dialogRef.close();
                                        }
                                    }]
                            });
                            $scope.voltar();
                        })
                        .error(function (data, status) {
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
                                        action: function (dialogRef) {
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


    $scope.listarParticipantes = function (evento) {
        window.location = '#/listaparticipantes/' + evento.id;
    };

    $scope.getTotalParticipantes = function (id) {
        var total;
        if (id) {
            $http.get("./rest/participanteSource/listaparticipantes/total/" + id)
                    .success(function (total, status) {
                        total = total;
                    })
                    .error(function (data, status) {
                        console.log('erro ao buscar eventos');
                    });
        }
        if (total > 0) {
            return total;
        } else {
            return 0;
        }
    };

    $scope.salvar = function (acao) {
        console.log(angular.toJson($scope.evento, true));
        if (!($scope.evento.id > 0)) {
            $scope.evento.statusevento = true;
        }
        $scope.evento.disponivel = $scope.evento.limite;
        console.log("evento antes do post = " + $scope.evento.periodos.length);
        $http.post("./rest/eventoSource/evento", $scope.evento)
                .success(function (evento, status) {
                    //carregarEvento();
                    window.location = '#/listaevento';
                    toastr.success("Evento " + acao + " com sucesso!");
                    console.log("evento salva = " + $scope.evento);
                })
                .error(function (data, status) {
                    console.log("erro ao salvar evento", data);
                    toastr.warning("Erro ao salvar evento!");
                });
    };

    $scope.novo = function () {
        window.location = '#/cadastroevento';
    };
    
    $scope.telaPeriodo = function (id) {
        window.location = '#/listaperiodos/'+id;
    };


    $scope.encerrar = function () {
        $scope.evento.statusevento = false;
        $scope.salvar("Encerrado");
    };

    $scope.reativar = function () {
        $scope.evento.statusevento = true;
        $scope.salvar("Reativado");
    };

    $scope.getTodos = function (numeroPagina) {

        $scope.selected = !$scope.selected;

        $http.get("./rest/eventoSource/listar/pag/" + numeroPagina)
                .success(function (listaEventos, status) {
                    $scope.eventos = listaEventos;
                })
                .error(function (data, status) {
                    console.log('erro ao buscar eventos' + data);
                });
    };

    $scope.carregarEvento = function () {
        if (!$routeParams.eventoId) {
            $scope.evento = {};
            $scope.evento.periodos = [];
            $scope.periodosModal = [];
            return;
        }
        $http.get('./rest/eventoSource/evento/' + $routeParams.eventoId)
                .success(function (ev) {
                    $scope.evento = ev;
                    $scope.periodo = ev.periodos[0];
                    return;
                });
    };
    
    $scope.carregaPeriodo = function(){
        console.log("carregando periodos para evento do id = " + $routeParams.idevento);
        $http.get('./rest/eventoSource/evento/' + $routeParams.idevento)
                .success(function (ev) {
                    $scope.periodosModal = ev.periodos;
                    return;
                });
    }

    $scope.carregarEventoDetalhes = function (indice, titulo, detalhes, local, data) {
        $scope.idCurso = indice;
        $scope.tituloCurso = titulo;
        $scope.DetalhesCurso = detalhes;
        $scope.localCurso = local;
        $scope.dataCurso = data;
    };


    $scope.voltar = function () {
        $scope.evento = {};
        window.location = '#/listaevento';
    };

    $scope.mensageEventoListado = function () {
        if ($scope.selected) {
            return 'Abertos';
        } else {
            return 'Finalizados';
        }
    };

    $scope.getTipoEvento = function (tipo) {
        switch (tipo) {
            case "1":
                return 'CURSO';
                break;
            case "2":
                return 'PALESTRA';
                break;
            case "3":
                return 'REUNIAO';
                break;
			case "4":
                return 'OUTROS';
                break;
            default:
                return 'CURSO';
                break;
        }
    };


//Novo periodo

    $scope.novoPeriodo = function () {
        $scope.periodo = {};
    };

    $scope.salvarPeriodo = function () {
        var dataAtual = dataHoje();
        if ($scope.indicePeriodo >= 0) {
            $scope.evento.periodos.splice($scope.indicePeriodo, 1);
        }
        
        if($scope.periodo.inicio >= $scope.periodo.fim){
            toastr.warning("Horário inválido");
        }else if($scope.periodo.data < dataAtual){
            console.log("data sis: " + $scope.periodo.data + "data atual " + dataAtual );
            toastr.warning("Data inválida!");
        }
        else{
            var periodo = removeFusoHorarioData($scope.periodo.data);
            $scope.periodo.data = periodo;
            $scope.evento.periodos.push($scope.periodo);
            console.log($scope.evento.periodos);
            toastr.success("Periodo adicionado com sucesso.");
            $scope.indicePeriodo = {};   
        } 
    };

    $scope.editarPeriodo = function (indice) {
        $scope.indicePeriodo = indice;
        $scope.periodo = angular.copy($scope.evento.periodos[indice]);
    };

    $scope.delPeriodo = function (index) {

        toastr.warning("Periodo removido!");
        $scope.evento.periodos.splice(index, 1);
        if ($scope.evento.periodos.length === 0) {
            $scope.periodo = {};
        }

    };
    
    function dataHoje() {
        var data = new Date();
        var dia = data.getDate();
        var mes = data.getMonth() + 1;
        var ano = data.getFullYear();
        if (dia < 10){
            dia = '0'+dia;
        }
        if(mes < 10){
            mes = '0'+mes;
        }
        
        return [ano, mes, dia].join('-');
    }

}
function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}



function removeFusoHorarioData(dataTemp){
    var data = new Date(dataTemp);
    var novaData = new Date(data.getTime() + data.getTimezoneOffset()*60000);
    
    return novaData;
    
    
}