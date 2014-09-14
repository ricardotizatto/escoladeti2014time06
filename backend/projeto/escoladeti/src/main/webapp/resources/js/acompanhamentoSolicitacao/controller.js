var controllers = angular.module('controllers');

function AcompanhamentoSolicitacaoController($scope, $location, $log, $http, $routeParams, SolicitacaoItem){ 

    $scope.getTodos = function() {
        $log.debug('listar todas as SolicitacaoItens');
        //$scope.carregaPesquisaSolicitacao(null);
        SolicitacaoItem.listartodos(function(SolicitacaoItens) {
            $scope.solicitacaoItens = SolicitacaoItens;
            for (var i=0; i< $scope.solicitacaoItens.length; i++) {
                $scope.solicitacaoItens[i].dataChegada = new Date();
            } 
        });
    };
    
    $scope.getPesquisar  = function() {
        $log.debug('PESQUISANDO');
        $scope.carregaPesquisaSolicitacao("AGUARDANDO");
        $log.debug('Status: ' + $scope.pesquisaSolicitacao.status);
        
	$scope.pesquisaSolicitacao.$listarPesquisa(function () {
            toastr.success('Pesquisa salvo com sucesso');
	});
    };
    
    $scope.carregaPesquisaSolicitacao = function(status) {
        $scope.pesquisaSolicitacao = {
            status: status,
            dataInicio: $scope.buscaDataChegadaIni.toUpperCase(),
            dataFim: $scope.buscaDataChegadaFim.toUpperCase(),
            solicitacaoId: $scope.buscaSolicitacao.toUpperCase(),
            ordemId: $scope.buscaOrdem.toUpperCase(),
            material: $scope.buscaMaterial.toUpperCase(),
            responsavel: $scope.buscaResponsavel.toUpperCase(),
            revisor: $scope.buscaRevisor.toUpperCase()
        };
    };
    
    $scope.getSolicitacaoStatus = function(status) {
        $log.debug('acomapanhamento getSolicitacaoStatus');
        $scope.solicitacoes = [];
//        for (var i=0; i< $scope.solicitacoesDB.length; i++) {
//            if($scope.solicitacoesDB[i].status == status){
//                $log.debug('status: '+ $scope.solicitacoesDB[i].status);
//                $scope.solicitacoes.push($scope.solicitacoesDB[i]);
//            }
//        }   
    };
    
    $scope.produzir = function(soliciataoId) {
        window.location = '#/ordemproducao/' + soliciataoId;
    };
    
    $scope.expandir = function(soliciatao) {
        $location.path('/cadastrosolicitacao/'+ 80);
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