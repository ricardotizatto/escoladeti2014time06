var controllers = angular.module('controllers');

function ExternoController($scope, $http, $routeParams) {
    console.log('carregando controller externo');
    
    $scope.tituloLimit = 50;    
    $scope.descricaoLimit = 80;    
    $scope.localLimit = 40;    
    
    $scope.ativaBotao = function (pagina) {
        if(!pagina){
            $scope.ativa = '';
        }else{
            $scope.ativa = pagina;   
        }
    },
    $scope.getLivrosTranscritos = function (pageNumber){
        $http({
            method: 'GET',
            url: './public/rest/livrostranscritos/pag/' + pageNumber
        }).success(function (livrosTranscritos) {
            $scope.livrosTranscritos = livrosTranscritos;
        });
    },
    $scope.buscaMateriaisContendoNome = function (busca){
       console.log('busca materiais: ' + busca );
        if (!busca.empty){
        $http({
                method: 'GET',
                url: './public/rest/buscalivrostranscritos?q=' + busca.toUpperCase()
            }).success(function (livrosTranscritos) {
                console.log('busca livros Transcritos', livrosTranscritos);
                $scope.livrosTranscritos = livrosTranscritos;
            });
        }else{
           $scope.getLivrosTranscritos($scope.pageNumber); 
        }    
    },
    $scope.getEventos = function (){
        console.log('getEventos');
        $http({
            method: 'GET',
            url: './public/rest/ultimosperiodos'
        }).success(function (ultimosPeriodos) {
            console.log('Ultimos Periodos: ', ultimosPeriodos);
            $scope.ultimosPeriodos = ultimosPeriodos;
        });
        $scope.paginarProximosEventos(1);
        $scope.paginarUltimosEventos(1);
    },
    $scope.paginarProximosEventos = function (pageNumber) {
        console.log('paginarEventos pag: ', pageNumber);
        pageNumber = pageNumber - 1;
        $http({
            method: 'GET',
            url: './public/rest/proximoseventos/' + pageNumber
        }).success(function (proximosEventos) {
            console.log('Proximos Eventos: ', proximosEventos);
            $scope.proximosEventos = proximosEventos;
        });
    },
    $scope.paginarUltimosEventos = function (pageNumber) {
        console.log('paginarEventos pag: ', pageNumber);
        pageNumber = pageNumber - 1;
        $http({
            method: 'GET',
            url: './public/rest/ultimoseventos/' + pageNumber
        }).success(function (ultimosEventos) {
            console.log('Ultimos Eventos: ', ultimosEventos);
            $scope.ultimosEventos = ultimosEventos;
        });
    },        
    $scope.detalhesEvento = function (eventoId){
        console.log('Detalhes Evento id :', eventoId);
        window.location = '#/detalhes-evento/' + eventoId;
    },
    $scope.eventoRealizado = function (eventoId) {
        console.log('Detalhes Evento id :', eventoId);
        window.location = '#/evento-realizado/' + eventoId;
    },        
    $scope.carregaEvento = function (){
        console.log('Carrega Evento id :', $routeParams.eventoId);
        $scope.info = {};
        $scope.novoParticipante();
        if($routeParams.eventoId){
        $http({
                method: 'GET',
                url: './public/rest/evento/' + $routeParams.eventoId
            }).success(function (evento) {
                console.log('Detalhes Evento: ', evento);
                $scope.evento = evento;               
            });
        }else{
            window.location = '#/eventos';
        }    
    };
    $scope.salvarParticipante = function(eventoId) {
        console.log('Salvar Participante : eventoId: ' + eventoId);
        $scope.info = {};
        $scope.participante.idevento = eventoId;
        
        if($scope.participante.deficiente === 'S' && ( $scope.participante.necessidade === '' || $scope.participante.necessidade === undefined )){
            $scope.info.status = 'danger';
            $scope.info.message = 'Não foi preenchido o campo Quais Necessidades?';
            return;
        }
        if($scope.participante.deficiente === 'N'){
            $scope.participante.necessidade = 'N/P';
        }
        $scope.info = {};
        $http.post('./public/rest/salvarparticipante/', $scope.participante)
            .success(function (participante) {
                console.log('Participante Salvo: ' + participante);
                $scope.novoParticipante();
                $scope.info.status = 'success';
                $scope.info.message = participante.nome + " inscrição realizada com sucesso!";
            }).error(function (data) {
                console.log('Erro ao salvar Participante: ' + data.messageDeveloper);
                $scope.info.status = 'danger';
                $scope.message = data.message;
        });
    };
    $scope.novoParticipante = function (){
        $scope.participante = { deficiente: 'N', pagamento: "PENDENTE" };    
    };
};

controllers.controller('ExternoController', ['$scope', '$http', '$routeParams', ExternoController ]);