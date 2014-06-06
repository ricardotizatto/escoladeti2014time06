function participanteController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    $scope.idModal;
    $scope.cpfModal;
    $scope.deficienteModal;
    $scope.emailModal;
    $scope.ideventoModal;
    $scope.nomeModal;
    $scope.rgModal;
    $scope.sexoModal;
    $scope.telefoneModal;
    $scope.pagamentoModal;

    $scope.editar = function(participante) {
        console.log(participante);
        window.location = '#/cadastroparticipante/' + participante.id;
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
        $http.post("./rest/participanteSource/participante", $scope.participante)
                .success(function(participante, status) {
            //$scope.participante = getNovoParticipante();
            window.location = '#/cadastroparticipante';
            console.log("participante salva = " + participante);
        })
                .error(function(data, status) {
            console.log("erro ao salvar participante" + data);
        });
    };

    $scope.salvarAlteracao = function() {


        $scope.participante.id = $scope.idModal;
        $scope.participante.cpf = $scope.cpfModal;
        $scope.participante.deficiente = $scope.deficienteModal;
        $scope.participante.email = $scope.emailModal;
        if ($scope.ideventoModal == null) {
            $scope.participante.idevento = $routeParams.idevento;
        } else {
            $scope.participante.idevento = $scope.ideventoModal;
        }
        $scope.participante.nome = $scope.nomeModal;
        $scope.participante.rg = $scope.rgModal;
        $scope.participante.sexo = $scope.sexoModal;
        $scope.participante.telefone = $scope.telefoneModal;
        $scope.participante.pagamento = $scope.pagamentoModal;

        console.log(angular.toJson($scope.participante, true));

        $http.post("./rest/participanteSource/participante", $scope.participante)
                .success(function(participante, status) {
            //$scope.participante = getNovoParticipante();
            $scope.listarParticipantes();
            console.log("participante salva = " + participante);
        })
                .error(function(data, status) {
            console.log("erro ao salvar participante" + data);
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
        $scope.participante = $scope.getNovoParticipante();
        //window.location = '#/cadastroparticipante';
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
        if ($routeParams.participanteId) {
            $http.get('./rest/participanteSource/participante/' + $routeParams.participanteId)
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
            $scope.eventos = eventos;
        })
                .error(function(data, status) {
            console.log('erro ao buscar eventos');
        });
    };

    $scope.carregarParticipanteAlterar = function(idModal, cpfModal, deficienteModal, emailModal, ideventoModal, nomeModal, rgModal, sexoModal, telefoneModal, pagamentoModal) {

        $scope.idModal = idModal;
        $scope.cpfModal = cpfModal;
        $scope.deficienteModal = deficienteModal;
        $scope.emailModal = emailModal;
        $scope.ideventoModal = ideventoModal;
        $scope.nomeModal = nomeModal;
        $scope.rgModal = rgModal;
        $scope.sexoModal = sexoModal;
        $scope.telefoneModal = telefoneModal;
        $scope.pagamentoModal = pagamentoModal;

    };

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

}

