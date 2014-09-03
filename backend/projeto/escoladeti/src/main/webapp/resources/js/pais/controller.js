var controllers = angular.module('controllers');

function PaisController($scope, $routeParams, paisService) {
    console.log('carregando controller');

    $scope.deletar = function(pais) {
        console.log('deletando pais ' + JSON.stringify(pais));
        
        BootstrapDialog.confirm('Deseja realmente deletar o Pais: <b>' + pais.nome +'</b>?', function(result) {
            if (result) {
               paisService.deletar(pais)
               		.success(function (data, status) {
                        $scope.getTodos(1);
                        console.log('pais deletado');
                        toastr.success(pais.nome+" deletado com sucesso.");                       
                    })
                    .error(function (data, status) {
                        console.log('erro ao deletar pais ' + data);
                        console.log(data.messageDeveloper);
                        toastr.error(data.message);
                    });
            }
        });

    };

    $scope.novo = function() {
        $scope.pais = getNovoPais();
        window.location = '#/cadastropais';
    };
    
    $scope.carregarPais = function () {
        console.log('carregando pais');
        
        if (!$routeParams.paisId){
        	$scope.pais = getNovoPais();
            return;//se não tiver id não buscar
        }
        
        paisService.buscar($routeParams.paisId)
                .success(function(pais, status) {
                    $scope.pais = pais;
                });
    };

    $scope.editar = function(pais) {
        window.location = '#/cadastropais/' + pais.id;
    };
    
    $scope.buscaPaisContendoNome = function () {
    	console.log($scope.busca);    	
    	paisService.buscarPorNome($scope.busca)
    		.then(function (retorno){
    			console.log(retorno.data.list);
    			$scope.paises = retorno.data;
    		});
    };   		

    $scope.salvar = function() {
    	paisService.salvar($scope.pais)
                .success(function(pais, status) {
                    $scope.pais = getNovoPais();
                    toastr.success('Pais '+pais.nome+' salvo com sucesso.');
                    window.location = '#/listapais';
                })
                .error(function(data, status) {
                    console.log('pais não salvo ', data);
                    //toastr.warning(data.message);
                    console.log(data.messageDeveloper);
                });
    };
    
    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        paisService.listar(numeroPagina)
            .success(function(listaPaises, status) {
                $scope.paises = listaPaises;
            })
            .error(function(data, status) {
                console.log('erro ao buscar paises ' + data);
            });
    };

    function getNovoPais() {
        console.log('novo pais');
        return {
        	codigo: null,
        	nome: '',
        	sigla: ''        	
        };
    }

    $scope.voltar = function() {
        $scope.pais = {};
        //$location.path('/listapais');
        window.location = '#/listapais';
    };

}

controllers.controller('PaisController', ['$scope', '$routeParams', 'paisService', PaisController ]);