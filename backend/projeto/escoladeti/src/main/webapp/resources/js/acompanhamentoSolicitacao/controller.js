var controllers = angular.module('controllers');

function acompanhamentoSolicitacaoController($scope, $location, $log, $http, $routeParams) {
    var $this = this;

    $log.debug('carregando acomapanhamento solicitacao');
    
    $scope.mostrar = true;
    
    $scope.solicitacoes = [
        {id: 001, status: 'aguardando',  dataChegada: '01/08/2014', material: "Gerenciamento de Projetos",   traducao: "brille", responsavel: "Jose da Silva"},
        {id: 005, status: 'cancelado',  dataChegada: '02/08/2014', material: "Cinderela",                   traducao: "brille", responsavel: "Alisson Molinari"},
        {id: 002, status: 'producao',   dataChegada: '03/08/2014', material: "Matemática Discreta",         traducao: "brille", responsavel: "Maria Pereira",      ordem:'002'},
        {id: 003, status: 'produzido',  dataChegada: '04/08/2014', material: "Branca de Neve e os 7 anões", traducao: "brille", responsavel: "Winicius Wanderlei", ordem:'004',},
        {id: 004, status: 'finalizado', dataChegada: '05/08/2014', material: "Pocahontas",                  traducao: "brille", responsavel: "Jhonatan Catabriga", ordem:'006', dataEnvio: '10/09/2014'},    
    ];

    $scope.getTodos = function() {
         $log.debug('acomapanhamento getTodos');
    };
    
    $scope.getStatus = function(status) {
        switch (status) {
            case "aguardando":
                return "warning";
                break;
            case "producao":
                return "success";
                break;
            case "produzido":
                return "info";
                break;
            case "finalizado":
                return "primary";
                break;
            case "cancelado":
                return "danger";
                break;
        }
    };
    
    $scope.getIcone = function(status) {
        switch (status) {
            case "aguardando":
                return "fa fa-spinner";
                break;
            case "producao":
                return "fa fa-cogs";
                break;
            case "produzido":
                return "fa fa-file-text-o";
                break;
            case "finalizado":
                return "fa fa-check-circle-o";
                break;
            case "cancelado":
                return "fa fa-times";
                break;
        }
    };
    
    $scope.getBotoes = function(status) {
        switch (status) {
            case "aguardando":
                return "fa fa-spinner";
                break;
            case "producao":
                return "fa fa-cogs";
                break;
            case "produzido":
                return "fa fa-file-text-o";
                break;
            case "finalizado":
                return "<button type='submit' class='btn btn - primary btn - small'>" +
                        "< i class = 'fa fa-arrows-alt' > < /i> Expandir" +
                        "< /button>";
                break;
            case "cancelado":
                return "";
                break;
        }
    };
}

controllers.controller('acompanhamentoSolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$http',
		 '$routeParams',
		 acompanhamentoSolicitacaoController
		 ]);