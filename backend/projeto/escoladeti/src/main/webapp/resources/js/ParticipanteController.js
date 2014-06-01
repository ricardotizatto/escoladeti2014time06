function participanteController($scope, $http, $routeParams) {
    console.log('Carregando controller');
	$scope.idCurso;
	$scope.tituloCurso;
	$scope.DetalhesCurso;
	$scope.localCurso;
	$scope.dataCurso;

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
					window.location = '#/listaparticipante';
                    console.log("participante salva = " + participante);
                })
                .error(function(data, status) {
                    console.log("erro ao salvar participante" + data);
                });
    };

    $scope.novo = function() {
        $scope.participante = getNovoParticipante();
        window.location = '#/cadastroparticipante';
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

    $scope.carregarParticipanteDetalhes = function(indice,titulo,detalhes,local,data) {
        
            $scope.idCurso = indice;
			$scope.tituloCurso = titulo;
			$scope.DetalhesCurso = detalhes;
			$scope.localCurso = local;
			$scope.dataCurso = data;
        
    };	
	
    function getNovoParticipante() {
        console.log('novo participante');
        return {};
    };
	
}

