var controllers = angular.module('controllers');
            
            
function EventoController($scope ,$routeParams, Evento) {    
    console.log('Carregando controller');
    $scope.info = {};
    
    
     $scope.carregarEvento = function () {
        console.log('carregando evento com id: ' + $routeParams.eventoId);
        if (!$routeParams.eventoId) {
            $scope.evento = getNovoEvento();
            return;//
            
            
        }

        EventoService.buscar($routeParams.eventoId)
                .success(function (evento, status) {
                    console.log(evento);                    
                    $scope.evento = evento;
                });
    };
    
    
    $scope.buscaEventosContendoNome = function () {
        console.log($scope.busca);
        EventoService.buscarPorNome($scope.busca)
                .then(function (retorno) {
                    console.log(retorno.data);
                    $scope.eventos = retorno.data;
                });
    };
    
  
         $scope.getTodos = function (numeroPagina) {
             console.log('Carregando eventos ');
        Evento.buscaEventos({pagina: numeroPagina}, function (eventos) {
            $scope.eventos = eventos;
        });
    };
            

}

controllers.controller( 'EventoController',
                [ 
                '$scope',
                '$routeParams',
                'EventoFactory',
                EventoController]);
