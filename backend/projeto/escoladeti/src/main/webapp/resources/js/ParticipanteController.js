function participanteController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.idModal;
    $scope.deficienteModal;
    $scope.necessidadeModal;
    $scope.emailModal;
    $scope.ideventoModal;
    $scope.nomeModal;
    $scope.telefoneModal;
    $scope.pagamentoModal;
    $scope.idCurso;
    $scope.tituloCurso;
    $scope.DetalhesCurso;
    $scope.localCurso;
    $scope.dataCurso;
    $scope.inicioCurso;
    $scope.fimCurso;
    $scope.ministranteCurso;
    $scope.deficiente;
    $scope.inicio;
    $scope.fim;
    $scope.tipoEvento;
    $scope.valor;
    $scope.presencaaux;
    $scope.idevento;

    $scope.editar = function(participante) {
        console.log(participante);
        window.location = '#/editarparticipante/' + participante.id;
    };

    $scope.deletar = function(participante) {
        alert(participante.titulo);
        $http({
            method: 'DELETE',
            data: participante,
            url: './rest/participanteSource/participante',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
            console.log("participante deletado");
            $scope.getTodos();
        }).error(function(data) {
            console.log("erro ao deletar participante ");
        });
    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.participante, true));
        
        if($scope.participante.nome === undefined)
            return toastr.warning('Preencha o campo Nome');
        
        if($scope.participante.email === undefined)
            return toastr.warning('Preencha o campo Email');
        
        if($scope.participante.telefone === undefined)
            return toastr.warning('Preencha o campo Telefone');
          
        if($scope.participante.deficiente === undefined)
            return toastr.warning('Preencha o campo Possui necessidades especiais');
        
        if ($scope.participante.deficiente === 'N'){
          $scope.participante.necessidade = 'N/P';  
        }
        if($scope.participante.necessidade === undefined)
            return toastr.warning('Quais');
       
        if ($scope.validacampos() !== "")
        {
            toastr.warning("Atenção: " + $scope.validacampos());
            
        }else{         
            $scope.participante.pagamento = "PENDENTE";
            $scope.participante.presente = true;
            $http.post("./rest/participanteSource/participante", $scope.participante)
                    .success(function(participante, status) {
                console.log("participante salva = " + participante.nome);
                toastr.success("Participante cadastrado com sucesso!");
                setTimeout(function(){window.location="#/listaevento"}, 500);

            })
                    .error(function(data, status) {
                        $scope.info = {};
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao salvar participante: ' + $scope.nomeModal + ' - '+ data.message;
            });
        }   
    };

    $scope.salvarAlteracao = function() {
        $http.post("./rest/participanteSource/participante", $scope.participante)
                    .success(function(participante, status) {
                toastr.success("Participante Alterado com sucesso!");
            })
                    .error(function(data, status) {
                        $scope.info = {};
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao salvar participante: ' + $scope.nomeModal + ' - '+ data.message;
            });
        window.location = '#/listaparticipantes/'+$scope.participante.idevento;
    };
    
     $scope.alteraPresenca = function(part) {
         participante = part;
        participante.presente = !participante.presente; 
        presencaaux = participante.presente;
        $http.post("./rest/participanteSource/participante", participante)
                    .success(function(participante, status) {
                console.log("Presenca confirmada , aluno: "+ participante.nome);
                window.location = '#/listaparticipantes/'+participante.idevento;
            })
                    .error(function(data, status) {
                        $scope.info = {};
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao registrar presenca. ';
            });
    };
    
    $scope.atualizaPresencaAux = function(part){
        $scope.presencaaux = part.presente;
        return  $scope.presencaaux;
    };

    $scope.novo = function() {
        $scope.idModal = {};
        $scope.deficienteModal = {};
        $scope.emailModal = {};
        $scope.ideventoModal = {};
        $scope.nomeModal = {};
        $scope.telefoneModal = {};
        $scope.pagamentoModal = {};
        $scope.deficiente = {};
        $scope.participante = $scope.getNovoParticipante();
        console.log("novo");
    };
    
    $scope.novoParticipante = function(){
        $scope.idModal = {};
        $scope.deficienteModal = {};
        $scope.emailModal = {};
        $scope.ideventoModal = {};
        $scope.nomeModal = {};
        $scope.telefoneModal = {};
        $scope.pagamentoModal = {};
        $scope.deficiente = {};
        $scope.participante = $scope.getNovoParticipante();
        window.location = '#/cadastroparticipante';
        console.log("novo");
    }
    
    $scope.validacampos = function() {
       
       if(ValidaEmail($scope.participante.email) === false)
           return "Por favor corrija o Email digitado.";
       
       if($scope.participante.idevento ===  undefined)
           return "Selecione um dos nossos cursos.";

       if( $scope.participante.nome  ===  undefined)
           return "Digite seu nome para efetuarmos o cadastro.";
       
       if($scope.participante.telefone ===  undefined)
           return "Por favor entre com um telefone.";
       
       return "";
    };

    $scope.getTodos = function() {

        $http.get("./rest/participanteSource/participante")
                .success(function(participantes, status) {
            $scope.participantes = participantes;
        })
                .error(function(data, status) {
            console.log('erro ao buscar participantes');
        });
    };

    $scope.carregarParticipante = function() {
        console.log('carregar participante',$routeParams.idParticipante)
        
        if (!$routeParams.idParticipante) {
           $scope.participante = {};
            return;
        }
        $http.get("./rest/participanteSource/participante/" + $routeParams.idParticipante)
                .success(function(ptcpnt) {
                    $scope.participante = ptcpnt;
                    console.log($scope.participante);
                    return;
                });
        
    };
    
    $scope.getById = function(id) {

        $http.get("./rest/participanteSource/participante/" + id)
                .success(function(ptcpnt) {
                    $scope.participante = ptcpnt;
                    return;
                });
        
    };

    $scope.getNovoParticipante = function() {
        console.log('novo participante');
        return {};
    };

    $scope.carregarEventos = function() {
        $http.get("./rest/eventoSource/evento")
                .success(function(eventos, status) {
            $scope.eventos = eventos.list;
            console.log("eventos carregados");
        })
                .error(function(data, status) {
            console.log('erro ao buscar eventos');
        });
    };

    $scope.listarParticipantes = function() {

        if ($routeParams.idevento) {
            $scope.idevento = $routeParams.idevento; 
            $http.get("./rest/participanteSource/listaparticipantes/" + $routeParams.idevento)
                    .success(function(participantes, status) {
                $scope.participantes = participantes;
            })
                    .error(function(data, status) {
                console.log('erro ao buscar eventos');
            });
        }
    };
    
    $scope.imprimirRelatorio = function () {
        if ($routeParams.idevento) {
            $http.get("./relatorio/participantes/" + $routeParams.idevento)
                .success(function(data, status) {
//                $scope.participantes = participantes;
                    console.log('entrou no método sucesso angular');
            })
                .error(function(data, status) {
                console.log('erro ao buscar eventos para impressão');
            });
        }
    };
    
    $scope.carregarEventoDetalhes = function(indice, titulo, detalhes, local, data, inicio, fim, ministrante) {
        $scope.idCurso = indice;
        $scope.tituloCurso = titulo;
        $scope.DetalhesCurso = detalhes;
        $scope.localCurso = local;
        $scope.dataCurso = data;
        $scope.inicioCurso = inicio;
        $scope.fimCurso = fim;
        $scope.ministranteCurso = ministrante;
    };
    
    $scope.voltar = function() {
        window.location = '#/listaparticipantes/'+$scope.participante.idevento;
    }

}

