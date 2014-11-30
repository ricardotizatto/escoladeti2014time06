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
	$scope.vagasDisponiveisTemp;
	$scope.vagasLimiteTemp;
//    $scope.selected;
    $scope.getFoto = function () {
       var foto = $('#imagem').attr('src');
       return foto;
       //$scope.evento.foto = foto.substring(22);
//       console.log('Foto sem trat: ', foto);
//       console.log('Foto com trat: ', $scope.evento.foto);
    };	


    $scope.indicePeriodo = {};
    $scope.inicializar = function () {
        $scope.getTodosAbertos(1);
        $scope.status = 'aberto';
    };
    $scope.editar = function (evento) {
        console.log(evento);
        window.location = '#/cadastroevento/' + evento.id;
    };
    $scope.chamadaPeriodo = function (id, evento) {
        if (id == undefined || ($scope.evento.limite == $scope.evento.disponivel)) {
            toastr.warning("Não existem participantes inscritos neste evento.");
        } else {
            window.location = '#/chamada/' + id;
        }
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
                            console.log($scope.status);
                            if ($scope.status == 'aberto') {
                                $scope.getTodosAbertos(1);
                            } else {
                                $scope.getTodosFechados(1);
                            }
                            console.log('evento deletado');
                            toastr.success("Evento deletado com sucesso");
                            $scope.voltar();
                        })
                        .error(function (data, status) {
                            console.log('erro ao deletar evento ' + data);
                        });
            } else {
                return;
            }
        });
    };

    $scope.buscaEventoContendoTitulo = function () {
        console.log($scope.busca);
        console.log($scope.status);
        $http.get('./rest/eventoSource/evento/' + $scope.status + '?q=' + $scope.busca.toUpperCase())
                .then(function (retorno) {
                    $scope.eventos = retorno.data;
                });
    };


    $scope.listarParticipantes = function (evento) {
        if (evento.limite === evento.disponivel) {
            toastr.warning("Não existem participantes inscritos neste evento.");
        } else {
            window.location = '#/listaparticipantes/' + evento.id;
        }
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
            $scope.evento.disponivel = $scope.evento.limite;
        }else{
			if($scope.evento.limite > $scope.vagasLimiteTemp){
			   $scope.evento.disponivel = $scope.evento.disponivel + ($scope.evento.limite - $scope.vagasLimiteTemp); 
			}else if(($scope.evento.limite < $scope.vagasLimiteTemp)&&($scope.evento.disponivel > $scope.evento.limite)){
			   $scope.evento.disponivel = ($scope.evento.disponivel - ($scope.vagasLimiteTemp - $scope.evento.limite)); 
                           if($scope.evento.disponivel < 0)  {
                               $scope.evento.disponivel = $scope.evento.disponivel * -1;
                           }
			}else{
				$scope.evento.disponivel = $scope.vagasDisponiveisTemp;
				$scope.evento.limite = $scope.vagasLimiteTemp; 
			}
		}

        $scope.evento.foto = $('#imagem').attr('src');
        console.log('FOTO:', $scope.evento.foto);
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
        window.location = '#/listaperiodos/' + id;
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
        //$scope.selected = false;
        $http.get("./rest/eventoSource/listar/pag/" + numeroPagina)
                .success(function (listaEventos, status) {
                    $scope.eventos = listaEventos;
                })
                .error(function (data, status) {
                    console.log('erro ao buscar eventos' + data);
                });
    };

    $scope.getTodosAbertos = function (numeroPagina) {
        console.log("listando todos eventos abertos");
        $http.get("./rest/eventoSource/listartodosabertos/pag/" + numeroPagina)
                .success(function (listaEventos, status) {
                    $scope.eventos = listaEventos;
                    console.log($scope.eventos.list);
                })
                .error(function (data, status) {
                    console.log('erro ao buscar eventos' + data);
                });
    };
    $scope.getTodosFechados = function (numeroPagina) {
        console.log("listando todos eventos fechados");
        $http.get("./rest/eventoSource/listartodosfechados/pag/" + numeroPagina)
                .success(function (listaEventos, status) {
                    $scope.eventos = listaEventos;
                    console.log($scope.eventos.list);
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
            $scope.desabilidaEditPeriodo = false;
            $scope.desabilidaDelPeriodo = false;
            return;
        }
        $http.get('./rest/eventoSource/evento/' + $routeParams.eventoId)
                .success(function (ev) {
                    $scope.evento = ev;
                    $scope.periodo = ev.periodos[0];
                    $scope.desabilidaEditPeriodo = true;
                    $scope.desabilidaDelPeriodo = true;
                    var foto = ev.foto;
                    console.log('Foto:', foto);
                    $scope.evento.foto = 'data:image/png;base64,' + ev.foto;
//                    $scope.evento.foto = foto.substring(0, 3) ;
					$scope.vagasDisponiveisTemp = $scope.evento.disponivel;
					$scope.vagasLimiteTemp = $scope.evento.limite;
                    // if ($scope.evento.limite == $scope.evento.disponivel) {
                        // $scope.alterarLimite = false;
                    // }else{
                         // $scope.alterarLimite = true;
                    // }
                    return;
                });
    };

    $scope.carregaPeriodo = function () {
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

//    $scope.mensageEventoListado = function () {
//        if ($scope.selected) {
//            return 'Abertos';
//        } else {
//            return 'Finalizados';
//        }
//    };

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

        if ($scope.periodo.inicio >= $scope.periodo.fim) {
            toastr.warning("Horário inválido");
            return;
        }
        if ($scope.periodo.data < dataAtual) {
            console.log("data sis: " + $scope.periodo.data + "data atual " + dataAtual);
            toastr.warning("Data inválida!");
            return;
        }
        if ($scope.evento.periodos) {
            var periodoExistente = false;
            console.log('entrou na funcao que valida data/hora');
            $scope.evento.periodos.forEach(function (value, key) {
                var novaData = transformaData(value.data)
                if (novaData == $scope.periodo.data && value.inicio == $scope.periodo.inicio && value.fim == $scope.periodo.fim) {
                    periodoExistente = true;
                    toastr.warning("Periodo inválido.");
                    return;
                }
            });
        }
        if (periodoExistente == false) {
            console.log('entrou no else para salvar');
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
        $scope.periodo.data = transformaData($scope.periodo.data);
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
        if (dia < 10) {
            dia = '0' + dia;
        }
        if (mes < 10) {
            mes = '0' + mes;
        }

        return [ano, mes, dia].join('-');
    }

    function transformaData(data) {
        var dia = data.getDate();
        var mes = data.getMonth() + 1;
        var ano = data.getFullYear();
        if (dia < 10) {
            dia = '0' + dia;
        }
        if (mes < 10) {
            mes = '0' + mes;
        }

        return [ano, mes, dia].join('-');
    }
}
function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}



function removeFusoHorarioData(dataTemp) {
    var data = new Date(dataTemp);
    var novaData = new Date(data.getTime() + data.getTimezoneOffset() * 60000);

    return novaData;


}