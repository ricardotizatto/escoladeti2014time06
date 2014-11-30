var controllers = angular.module('controllers');

function ItemAcessoController($scope, $routeParams, itemAcessoService) {
    console.log('carregando controller');

    $scope.deletar = function(itemAcesso) {
        console.log('deletando item de acesso ' + JSON.stringify(itemAcesso));
        
        BootstrapDialog.confirm('Deseja realmente deletar o item de acesso: <b>' + itemAcesso.nome +'</b>?', function(result) {
            if (result) {
               itemAcessoService.deletar(itemAcesso)
               		.success(function (data, status) {
                        $scope.getTodos(1);
                        console.log('item de acesso deletado');
                        toastr.success(itemAcesso.nomeComponente+" deletado com sucesso.");                       
                    })
                    .error(function (data, status) {
                        console.log('erro ao deletar item de acesso ' + data);
                        console.log(data.messageDeveloper);
                        toastr.error(data.message);
                    });
            }
        });

    };

    $scope.novo = function() {
        $scope.itemAcesso = getNovoItemAcesso();
        window.location = '#/cadastroItemAcesso';
    };
    
    $scope.carregarItemAcesso = function () {
        console.log('carregando item de acesso');
        
        if (!$routeParams.itemAcessoId){
        	$scope.itemAcesso = getNovoItemAcesso();
            return;//se não tiver id não buscar
        }
        
        itemAcessoService.buscar($routeParams.itemAcessoId)
                .success(function(itemAcesso, status) {
                    $scope.itemAcesso = itemAcesso;
                });
    };

    $scope.editar = function(itemAcesso) {
        window.location = '#/cadastroitemAcesso/' + itemAcesso.id;
    };
    
    $scope.buscaItemAcessoContendoNome = function () {
    	console.log($scope.busca);    	
    	itemAcessoService.buscarPorNome($scope.busca)
    		.then(function (retorno){
    			console.log(retorno.data.list);
    			$scope.itensDeAcesso = retorno.data;
    		});
    };   		

    $scope.salvar = function() {
    	itemAcessoService.salvar($scope.itemAcesso)
                .success(function(itemAcesso, status) {
                    $scope.itemAcesso = getNovoItemAcesso();
                    toastr.success('Item de acesso '+itemAcesso.nomeComponente+' salvo com sucesso.');
                    window.location = '#/listaitemAcesso/';
                })
                .error(function(data, status) {
                    console.log('item de acesso não salvo ', data);
                    toastr.warning(data.message);
                    console.log(data.messageDeveloper);
                });
    };
    
    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        itemAcessoService.listar(numeroPagina)
            .success(function(listaItensDeAcesso, status) {
                $scope.itensDeAcesso = listaItensDeAcesso;
            })
            .error(function(data, status) {
                console.log('erro ao buscar itens de acesso ' + data);
            });
    };

    function getNovoItemAcesso() {
        console.log('novo item de acesso');
        return {
        	nomeComponente: ''
              };
    }

    $scope.voltar = function() {
        $scope.itemAcesso = {};
        window.location = '#/listaitemacesso';
    };

}

controllers.controller('ItemAcessoController', ['$scope', '$routeParams', 'itemAcessoService', ItemAcessoController ]);