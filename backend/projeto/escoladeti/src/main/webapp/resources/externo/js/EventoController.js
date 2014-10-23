angular.module('appExterno')
    .controller( 'EventoController',
                [ 
                '$scope',
                '$routeParams',
                'eventoService',
                EventoController]);
            
            
function EventoController($scope, $routeParams, eventoService) {
    $scope.select2 = 'one';
    console.log('Carregando controller');
    $scope.info = {};
    
    
     $scope.carregarEvento = function () {
        console.log('carregando evento com id: ' + $routeParams.eventoId);
        if (!$routeParams.eventoId) {
            $scope.evento = getNovoEvento();
            return;//
            
            
        }

        eventoService.buscar($routeParams.eventoId)
                .success(function (evento, status) {
                    console.log(evento);                    
                    $scope.evento = evento;
                });
    };
    
    
    $scope.buscaEventosContendoNome = function () {
        console.log($scope.busca);
        eventoService.buscarPorNome($scope.busca)
                .then(function (retorno) {
                    console.log(retorno.data);
                    $scope.eventos = retorno.data;
                });
    };
    
    
    $scope.getTodos = function () {
        console.log(1);
        eventoService.listar(1)
                .success(function (listaEventos) {
                    console.log(eventos);
                    $scope.eventos = listaEventos;
                        })
                        .error(function (data) {
                            console.log('erro ao buscar Evento ' + data.developerMessage);
                        });
            };
            

}

 controllers.controller('EventoController', ['$scope', '$routeParams', 'eventoService', EventoController]);