var controllers = angular.module('controllers');

function AcompanhamentoSolicitacaoController($scope, $location, $log, $http, $routeParams, PesquisaSolicitacao){ 

    $scope.init = function() {
        $scope.getPesquisaSolicitacao();
    };
    
    $scope.getPesquisaSolicitacao = function(status) {
        $log.debug('Pesquisando status: ' + status);
        $log.debug('Data ini: ' + $scope.buscaDataChegadaIni + ' Fim ' + $scope.buscaDataChegadaFim);

        PesquisaSolicitacao.query({
                status: status,
                dataInicio: $scope.buscaDataChegadaIni,
                dataFim: $scope.buscaDataChegadaFim,
                solicitacaoId: $scope.buscaSolicitacao,
                ordemId: $scope.buscaOrdem,
                material: $scope.buscaMaterial,
                responsavel: $scope.buscaResponsavel,
                revisor: $scope.buscaRevisor
                
            }, function(solicitacaoItens) {
            $scope.solicitacaoItens = solicitacaoItens;
        });
    };
    
    $scope.produzir = function(soliciataoId) {
        window.location = '#/ordemproducao/' + soliciataoId;
    };
    
    $scope.expandir = function(soliciataoId) {
        $location.path('/cadastrosolicitacao/'+ soliciataoId);
    };
    
    $scope.cancelar = function(soliciataoId) {
        $log.debug('cancelar: '+ soliciataoId);
        BootstrapDialog.confirm('Deseja realmente cancelar a Solicitacao: <b>' + soliciataoId + '</b>?', function(result) {
            if (result) {
                return;
            }
            return;
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