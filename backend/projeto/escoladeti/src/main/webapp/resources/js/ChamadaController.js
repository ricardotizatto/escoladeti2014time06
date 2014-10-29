function chamadaController($scope, $http, $routeParams) {

   
    $scope.getTodos = function (numeroPagina) {

        $http.get("./rest/participanteperiodoSource/participanteperiodo/" + $routeParams.idperiodo)
                .success(function (listaParticipantes, status) {
                    $scope.participantesperiodos = listaParticipantes;
                })
                .error(function (data, status) {
                    console.log('erro ao buscar periodos' + data);
                });
    };


    $scope.salvar = function (pp) {
        console.log(angular.toJson(pp, true));
        pp.presente = !pp.presente;
        $http.post("./rest/participanteperiodoSource/participanteperiodo/", pp)
                .success(function (pp, status) {
                    toastr.success("Presença registrada com sucesso!");
                    console.log("Presença salva = " + pp);
                })
                .error(function (data, status) {
                    console.log("erro ao salvar Presença", data);
                    toastr.warning("Erro ao salvar Presença!");
                });
    };
    
    $scope.voltar = function () {
        window.history.back();
    };
    

    

}
function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}



