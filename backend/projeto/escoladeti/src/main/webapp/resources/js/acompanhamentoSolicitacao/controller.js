var controllers = angular.module('controllers');

function AcompanhamentoSolicitacaoController($scope, $location, $log, $http, $routeParams, SolicitacaoItem) {
    //var $this = this;
    
    $log.debug('listar todas as SolicitacaoItens');
    SolicitacaoItem.listartodos(function(SolicitacaoItens) {
        $scope.solicitacaoItens = SolicitacaoItens;
        for (var i=0; i< $scope.solicitacaoItens.length; i++) {
            $scope.solicitacaoItens[i].dataChegada = new Date();
        } 
    });

    $log.debug('carregando acomapanhamento solicitacao');
    
        $scope.solicitacoesDB = [
            {id: 001, status: 'aguardando', dataChegada: '01/08/2014', material: "Gerenciamento de Projetos", traducao: "brille", responsavel: "Jose da Silva"},
            {id: 005, status: 'cancelado', dataChegada: '02/08/2014', material: "Cinderela", traducao: "brille", responsavel: "Alisson Molinari"},
            {id: 010, status: 'cancelado', dataChegada: '03/08/2014', material: "Motoqueiro Fantasma", traducao: "brille", responsavel: "Diogo Wegner"},
            {id: 002, status: 'producao', dataChegada: '03/08/2014', material: "Matematica Discreta", traducao: "brille", responsavel: "Maria Pereira", ordem: '002'},
            {id: 003, status: 'produzido', dataChegada: '04/08/2014', material: "Branca de Neve e os 7 anoes", traducao: "brille", responsavel: "Winicius Wanderlei", ordem: '004', },
            {id: 004, status: 'finalizado', dataChegada: '05/08/2014', material: "Pocahontas", traducao: "brille", responsavel: "Jhonatan Catabriga", ordem: '006', dataEnvio: '10/09/2014'},
            {id: 006, status: 'aguardando', dataChegada: '06/08/2014', material: "Alice no Pais das Maravilhas", traducao: "brille", responsavel: "Lorhan Bozza"},
            {id: 007, status: 'producao', dataChegada: '07/08/2014', material: "Peter Pan", traducao: "brille", responsavel: "Walber Oliveira", ordem: '007'},
            {id: 008, status: 'produzido', dataChegada: '08/08/2014', material: "O Magico do OZ", traducao: "brille", responsavel: "Martinho Omura", ordem: '001', },
            {id: 009, status: 'finalizado', dataChegada: '06/08/2014', material: "Chapeuzinho Vermelho", traducao: "brille", responsavel: "Ricardo Tizatto", ordem: '003', dataEnvio: '11/09/2014'},
            {id: 011, status: 'producao', dataChegada: '05/08/2014', material: "A Pequena Sereia", traducao: "brille", responsavel: "Rafael Prando", ordem: '006'},
        ];

//    $scope.getTodos = function() {
//        $log.debug('acomapanhamento getTodos');
//        $scope.solicitacoes = $scope.solicitacoesDB;
//    };
    
    
    $scope.getSolicitacaoStatus = function(status) {
        $log.debug('acomapanhamento getSolicitacaoStatus');
        $scope.solicitacoes = [];
        for (var i=0; i< $scope.solicitacoesDB.length; i++) {
            if($scope.solicitacoesDB[i].status == status){
                $log.debug('status: '+ $scope.solicitacoesDB[i].status);
                $scope.solicitacoes.push($scope.solicitacoesDB[i]);
            }
        }   
    };
    
    $scope.produzir = function(soliciataoId) {
        window.location = '#/ordemproducao/' + soliciataoId;
    };
    
    $scope.expandir = function(soliciataoId) {
        window.location = '#/ordemproducao/' + soliciataoId;
    };
    
    $scope.cancelar = function(soliciataoId) {
        $log.debug('cancelar: '+ soliciataoId);
        BootstrapDialog.confirm('Deseja realmente cancelar a Solicitacao: <b>' + soliciataoId + '</b>?', function(result) {
            if (result) {
                for (var i=0; i < $scope.solicitacoes.length; i++) {
                    if ($scope.solicitacoes[i].id == soliciataoId) {
                        $scope.solicitacoes.splice(i ,1);
                    }
                }   
            }
        });
    };
    
    $scope.getStatus = function(status) {
        switch (status) {
            case "AGUARDANDO":
                return "warning";
                break;
            case "PRODUCAO":
                return "success";
                break;
            case "PRODUZIDO":
                return "info";
                break;
            case "FINALIZADO":
                return "primary";
                break;
            case "CANCELADO":
                return "danger";
                break;
            default :
            return "warning";
        }
    };
    
    $scope.getIcone = function(status) {
        switch (status) {
            case "AGUARDANDO":
                return "fa fa-spinner";
                break;
            case "PRODUCAO":
                return "fa fa-cogs";
                break;
            case "PRODUZIDO":
                return "fa fa-file-text-o";
                break;
            case "FINALIZADO":
                return "fa fa-check-circle-o";
                break;
            case "CANCELADO":
                return "fa fa-times";
                break;
            default : 
            return "fa fa-spinner";
        }
    };
}

controllers.controller('AcompanhamentoSolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$http',
		 '$routeParams',
                 'AcompanhamentoSolicitacaoFactory',
		 AcompanhamentoSolicitacaoController
		 ]);