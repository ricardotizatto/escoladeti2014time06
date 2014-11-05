angular.module('appExterno', [])
    .controller('AppCtrontroller',
                [    
                '$routeParams',
                '$http',
                '$routeParams',
                'ParticipanteFactory',
                'AppFactory',
                AppCtrontroller]);



function AppCtrontroller( $routeParams, $http) {
    this.routeParams = $routeParams;
    this.http = $http;
    this.iniciar();
}

AppCtrontroller.prototype = {

    iniciar: function () {
    }, 
    ativaBotao: function (pagina) {
        var self = this; 
        if(!pagina){
            self.ativa = '';
        }else{
            self.ativa = pagina;   
        }
        
    },
    getMateriaisProduzidos: function (pageNumber){
        var self = this;
        this.http({
            method: 'GET',
            url: './public/rest/materiaisproduzidos/pag/' + pageNumber
        }).success(function (materiaisProduzidos) {
            self.materiaisProduzidos = materiaisProduzidos;
        });
    },
    buscaMateriaisContendoNome: function (){
        var self = this;
        console.log('busca materiais: '+ self.busca);
        if (!self.busca.empty){
            this.http({
                method: 'GET',
                url: './public/rest/buscamateriaisproduzidos?q=' + self.busca.toUpperCase()
            }).success(function (materiaisProduzidos) {
                console.log('busca materiaisProduzidos', materiaisProduzidos);
                self.materiaisProduzidos = materiaisProduzidos;
            });
        }else{
           this.getMateriaisProduzidos(); 
        }    
    },
    getEventos: function (pageNumber){
        console.log('getEventos pag: ', pageNumber);
        var self = this;
        this.http({
            method: 'GET',
            url: './public/rest/proximoseventos'
        }).success(function (proximosEventos) {
            console.log('Proximos Eventos: ', proximosEventos);
            self.proximosEventos = proximosEventos;
        });
        this.http({
            method: 'GET',
            url: './public/rest/ultimoseventos'
        }).success(function (ultimosEventos) {
            console.log('Ultimos Eventos: ', ultimosEventos);
            self.ultimosEventos = ultimosEventos;
        });
    },
    detalhesEvento: function (eventoId){
        console.log('Detalhes Evento id :', eventoId);
        window.location = '#/detalhes-evento/' + eventoId;
    },
    carregaEvento: function (){
        console.log('Carrega Evento id :', this.routeParams.eventoId);
        var self = this;
        if(this.routeParams.eventoId){
            this.http({
                method: 'GET',
                url: './public/rest/evento/' + this.routeParams.eventoId
            }).success(function (evento) {
                console.log('Detalhes Evento: ', evento);
                self.evento = evento;               
            });
        }else{
            window.location = '#/eventos';
        }    
    },
    salvarParticipante: function(participante, eventoId) {
        var self = this;
        var info;
        self.participante = participante;
        self.participante.idevento = eventoId;
        self.participante.pagamento = "PENDENTE";
        
        if(self.participante.deficiente === 'N' || self.participante.deficiente === undefined){
            self.participante.deficiente = 'N';
            self.participante.necessidade = 'N/P';
        }
                           
        console.log('self.participante salvo: ', self.participante);
        
        this.http.post('./public/rest/salvarparticipante/', self.participante)
        .success(function(participante) {
            console.log('Participante Salvo: ' + participante);
            self.participante.deficiente = '';
            self.participante.necessidade = '';
            self.participante.nome = '';
            self.participante.email = '';
            self.participante.telefone = '';

        }).error(function(data) {
            console.log('Erro ao salvar Participante: ' + data);
        });
    }
};

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
            .when('/principal', {
                templateUrl: './paginasexternas/principal.html',
                //controller: 'ExternoController'
            })
            .when('/eventos', {
                templateUrl: './paginasexternas/eventos.html',
                //controller: 'EventoController'
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
                //controller: 'MaterialController'
            })
            .when('/sobre', {
                templateUrl: './paginasexternas/sobre.html',
                //controller: 'ExternoController'
            })
            .when('/contato', {
                templateUrl: './paginasexternas/contato.html',
                //controller: 'ExternoController'
            })
            .when('/localizacao', {
                templateUrl: './paginasexternas/localizacao.html',
                //controller: 'ExternoController'
            })
            .when('/creditos', {
                templateUrl: './paginasexternas/creditos.html',
                //controller: 'ExternoController'
            })
            .otherwise({redirectTo: '/principal'
            });
    }
]);


