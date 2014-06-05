function CadastroParticipanteEventoController($scope, $http, $routeParams) {
    console.log('Carregando controller');
    
    $scope.novo = function() {
        $scope.participante = $scope.getNovoParticipante();
    };

    $scope.carregarEventos = function(){
        $http.get("./rest/eventoSource/evento")
            .success(function(eventos, status) {
                $scope.eventos = eventos;
            })
            .error(function(data, status) {
                console.log('erro ao buscar eventos');
            });
    };

}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}

