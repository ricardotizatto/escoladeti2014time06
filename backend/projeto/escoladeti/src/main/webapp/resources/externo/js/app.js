'use strict';

angular.module('controllers', ['services']);
angular.module('services', []);

var appExterno = angular.module('appExterno',
        ['ngRoute',
        'ngResource',
        'ui.utils',
        'controllers']); 

appExterno.config(['$routeProvider',
    function ($routeProvider) {

        $routeProvider
            .when('/home', {
                templateUrl: './paginasexternas/principal.html'
                //controller: 'ExternoController'
            })
//            .when('/eventos', {
//                templateUrl: './paginasexternas/eventos.html',
//                //controller: 'EventoController'
//            })
            .when('/detalhes-evento/:eventoId', {
                templateUrl: './paginasexternas/detalhes-evento.html'
                //controller: 'ExternoController'
            })
            .when('/detalhes-evento', {
                templateUrl: './paginasexternas/detalhes-evento.html'
                //controller: 'ExternoController'
            })
            .when('/evento-realizado/:eventoId', {
                templateUrl: './paginasexternas/evento-realizado.html'
                //controller: 'ExternoController'
            })
            .when('/evento-realizado', {
                templateUrl: './paginasexternas/evento-realizado.html'
                //controller: 'ExternoController'
            })
            .when('/transcricoes', {
                templateUrl: './paginasexternas/transcricoes.html'
                //controller: 'MaterialController'
            })
            .when('/sobre', {
                templateUrl: './paginasexternas/sobre.html'
                //controller: 'ExternoController'
            })
            .when('/localizacao', {
                templateUrl: './paginasexternas/localizacao.html'
                //controller: 'ExternoController'
            })
            .when('/creditos', {
                templateUrl: './paginasexternas/creditos.html'
                //controller: 'ExternoController'
            })
            .otherwise({redirectTo: '/principal'
            });
    }
]);


