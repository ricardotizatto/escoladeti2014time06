angular.module('appExterno', [])
    .controller('AppCtrontroller', 
                '$routeParams',
                '$http',
                'AppFactory',
                AppCtrontroller);

function AppCtrontroller($routeParams,$http) {
    this.routeParams = $routeParams;
    this.http = $http;
    this.iniciar();
    
    this.ativa = "home";
}

AppCtrontroller.prototype = {

    iniciar: function () {
        var self = this;
        this.getMateriaisProduzidos();

        this.http.get('./public/rest/eventos')
            .success(function (eventos) {
               self.eventos = eventos;
            });
    }, 
    paginaAtiva: function (pagina) {
        var self = this;        
        self.ativa = 'home';
    },
    getMateriaisProduzidos: function (){
        var self = this;
        console.log('materiaisProduzidos');
        this.http({
            method: 'GET',
            url: './public/rest/materiaisproduzidos'
        }).success(function (materiaisProduzidos) {
            console.log('materiaisProduzidos', materiaisProduzidos);
            self.materiaisProduzidos = materiaisProduzidos;
        });
    }
//    buscaMateriaisContendoNome: function (){
//        var self = this;
//        console.log('busca materiais'+ self.busca);
//        this.http({
//            method: 'GET',
//            url: './public/rest/materiais/' + self.busca
//        }).success(function (materiais) {
//            console.log('materiais', materiais);
//            self.materiais = materiais;
//        });
//    }
                
};

angular.module('controllers', ['services']);
angular.module('services', []);

var appExterno = angular.module('appExterno',
        ['ngRoute',
        'ngResource',
        'controllers']); 

appExterno.config(['$routeProvider',
    function ($routeProvider) {

        $routeProvider
            .when('/principal', {
                templateUrl: './paginasexternas/principal.html',
                //controller: 'ExternoController'
            })
            .when('/eventos', {
                templateUrl: './paginasexternas/eventos.html',
                //controller: 'ExternoController'
            })
            .when('/detalhes-evento/:eventoId', {
                templateUrl: './paginasexternas/detalhes-evento.html',
                //controller: 'ExternoController'
            })
            .when('/detalhes-evento', {
                templateUrl: './paginasexternas/detalhes-evento.html',
                //controller: 'ExternoController'
            })
            .when('/evento-realizado/:eventoId', {
                templateUrl: './paginasexternas/evento-realizado.html',
                //controller: 'ExternoController'
            })
            .when('/evento-realizado', {
                templateUrl: './paginasexternas/evento-realizado.html',
                //controller: 'ExternoController'
            })
            .when('/transcricoes', {
                templateUrl: './paginasexternas/transcricoes.html',
                //controller: 'ExternoController'
            })
            .when('/sobre', {
                templateUrl: './paginasexternas/sobre.html',
                //controller: 'ExternoController'
            })
            .when('/localizacao', {
                templateUrl: './paginasexternas/localizacao.html',
                //controller: 'ExternoController'
            })
            .otherwise({redirectTo: '/principal'
            });
    }
]);


