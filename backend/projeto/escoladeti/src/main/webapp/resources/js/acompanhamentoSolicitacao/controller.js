var controllers = angular.module('controllers');

function AcompanhamentoSolicitacaoController($scope, $location, $log, $http, $routeParams, PesquisaSolicitacao){ 

    $scope.init = function() {
        $scope.getPesquisaSolicitacao('TODOS');
    };
    
    $scope.getPesquisaSolicitacao = function(buscaStatus) {
        $log.debug('Pesquisando status: ' + buscaStatus);

        PesquisaSolicitacao.query({
                solicitacaoId: $scope.buscaSolicitacao,
                dataChegadaInicio : $scope.buscaDataChegadaIni,
                dataChegadaFim : $scope.buscaDataChegadaFim,
                status: buscaStatus,
                traducaoMaterial : $scope.buscaTraducaoMaterial,
                responsavel: $scope.buscaResponsavel,
                material: $scope.buscaMaterial,                
                revisor: $scope.buscaRevisor     
            }, function(solicitacaoItens) {
                $log.debug('solicitacaoItens.length: ' + solicitacaoItens.length);
                $log.debug('$scope.buscaSolicitacao: ' + $scope.buscaSolicitacao);
                $scope.solicitacaoItens = [];
                if($scope.buscaSolicitacao === undefined || $scope.buscaSolicitacao === "" || $scope.buscaSolicitacao === null){
                   $scope.solicitacaoItens = solicitacaoItens;
                }else{
                    for (i=0; i<solicitacaoItens.length; i++) {
                        $log.debug('solicitacaoItens[i].solicitacaoId: ' + solicitacaoItens[i].solicitacaoId);
                        if(solicitacaoItens[i].solicitacaoId === $scope.buscaSolicitacao){
                            $scope.solicitacaoItens.push(solicitacaoItens[i]); 
                        }
                    }
                }
            //$scope.solicitacaoItens = solicitacaoItens;
        });
    };
    
    $scope.limpar = function() {
        $scope.buscaSolicitacao = "";
        $scope.buscaDataChegadaIni = "";
        $scope.buscaDataChegadaFim = "";
        $scope.buscaTraducaoMaterial = "";
        $scope.buscaResponsavel = "";
        $scope.buscaMaterial = "";
        $scope.buscaRevisor = "";  
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