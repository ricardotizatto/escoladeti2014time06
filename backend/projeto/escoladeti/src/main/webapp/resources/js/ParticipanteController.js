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

    $scope.editar = function(participante) {
        console.log(participante);
        window.location = '#/cadastroparticipanteevento/' + participante.id;
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
          
        //alert($scope.participante.deficiente);      
        if($scope.participante.deficiente === undefined)
            return toastr.warning('Preencha o campo Possui necessidades especiais');
        
        if($scope.participante.necessidade === undefined)
            return toastr.warning('Quais');
       
        if ($scope.validacampos() !== "")
        {
            toastr.warning("Atenção: " + $scope.validacampos());
            
        }else{         
            $scope.participante.pagamento = "PENDENTE";
            $http.post("./rest/participanteSource/participante", $scope.participante)
                    .success(function(participante, status) {
                //$scope.participante = getNovoParticipante();
                console.log("participante salva = " + participante.nome);
                toastr.success("Participante cadastrado com sucesso!");
                setTimeout(function(){window.location="#/listaevento"}, 5000);
                $scope.novo();

            })
                    .error(function(data, status) {
                        $scope.info = {};
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao salvar participante: ' + $scope.nomeModal + ' - '+ data.message;
            });
        }   
    };

    $scope.salvarAlteracao = function() {


        $scope.participante.id = $scope.idModal;  
        $scope.participante.deficiente = $scope.deficienteModal;
        $scope.participante.email = $scope.emailModal;
        if ($scope.ideventoModal === null) {
            $scope.participante.idevento = $routeParams.idevento;
        } else {
            $scope.participante.idevento = $scope.ideventoModal;
        }
        $scope.participante.nome = $scope.nomeModal;
        $scope.participante.telefone = $scope.telefoneModal;
        $scope.participante.pagamento = $scope.pagamentoModal;
        $scope.participante.necessidade = $scope.necessidadeModal;
        
        console.log(angular.toJson($scope.participante, true));
  
            $http.post("./rest/participanteSource/participante", $scope.participante)
                    .success(function(participante, status) {
                //$scope.participante = getNovoParticipante();
                $scope.listarParticipantes();
                console.log("participante salva = " + participante);
                $scope.info = {};
                $scope.info.message = 'Participante ' + $scope.nomeModal + ' alterado com sucesso';
                $scope.info.status = 'success';
                $scope.novo();
            })
                    .error(function(data, status) {
                console.log("erro ao salvar participante" + data);
                        $scope.info = {};
                        $scope.info.status = 'danger';
                        $scope.info.message = 'Erro ao alterar participante: ' + $scope.nomeModal + ' - '+ data.message;
            });
    };

    $scope.novo = function() {
        $scope.idModal = {};
        $scope.cpfModal = {};
        $scope.deficienteModal = {};
        $scope.emailModal = {};
        $scope.ideventoModal = {};
        $scope.nomeModal = {};
        $scope.rgModal = {};
        $scope.sexoModal = {};
        $scope.telefoneModal = {};
        $scope.pagamentoModal = {};
        $scope.deficiente = {};
        $scope.sexo = {};
        $scope.participante = $scope.getNovoParticipante();
        //window.location = '#/cadastroparticipanteevento';
        console.log("novo");
    };
    
    $scope.novoParticipante = function(){
        $scope.idModal = {};
        $scope.cpfModal = {};
        $scope.deficienteModal = {};
        $scope.emailModal = {};
        $scope.ideventoModal = {};
        $scope.nomeModal = {};
        $scope.rgModal = {};
        $scope.sexoModal = {};
        $scope.telefoneModal = {};
        $scope.pagamentoModal = {};
        $scope.deficiente = {};
        $scope.sexo = {};
        $scope.participante = $scope.getNovoParticipante();
        window.location = '#/cadastroparticipanteevento';
        console.log("novo");
    }
    
    $scope.validacampos = function() {
        
       if(ValidarCPF($scope.participante.cpf) === false)
           return ("Por favor corrija o CPF digitado.");
       
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
        if ($routeParams.idParticipante) {
            $http.get('./rest/participanteSource/participante/' + $routeParams.idParticipante)
                    .success(function(participante) {
                $scope.participante = participante;
            });
        }
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

//    $scope.carregarParticipanteAlterar = function(idModal, cpfModal, deficienteModal, emailModal, ideventoModal, nomeModal, rgModal, sexoModal, telefoneModal, pagamentoModal) {
//
//        $scope.idModal = idModal;
//        $scope.cpfModal = cpfModal;
//        $scope.deficienteModal = deficienteModal;
//        $scope.emailModal = emailModal;
//        $scope.ideventoModal = ideventoModal;
//        $scope.nomeModal = nomeModal;
//        $scope.rgModal = rgModal;
//        $scope.sexoModal = sexoModal;
//        $scope.telefoneModal = telefoneModal;
//        $scope.pagamentoModal = pagamentoModal;
//
//    };

    $scope.listarParticipantes = function() {

        if ($routeParams.idevento) {
            $http.get("./rest/participanteSource/listaparticipantes/" + $routeParams.idevento)
                    .success(function(participantes, status) {
                $scope.participantes = participantes;
            })
                    .error(function(data, status) {
                console.log('erro ao buscar eventos');
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
        $scope.participante = {};
        //window.location = '#/listarparticipantes';
    }

}

