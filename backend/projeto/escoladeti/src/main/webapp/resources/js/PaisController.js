function paisController($scope, $http, $routeParams) {
    console.log('carregando controller');

    $scope.deletar = function(pais) {
        console.log('deletando pais ' + JSON.stringify(pais));
        
        BootstrapDialog.confirm('Deseja realmente deletar o Pais: <b>' + pais.nome +'</b>?', function(result) {
            if (result) {
                $http({
                    method: 'DELETE',
                    data: pais,
                    url: './rest/paisSource/pais',
                    headers: {'Content-Type': 'application/json; charset=UTF-8'}
                })
                    .success(function(data, status) {
                        $scope.getTodos(1);
                        console.log('pais deletado');
                        BootstrapDialog.show({
                            title: 'Notifica&ccedil;&atilde;o',
                            message: 'Pais <b>' + pais.nome + '</b> deletado com Sucesso!',
                            type: BootstrapDialog.TYPE_SUCCESS,
                            buttons: [{
                                    id: 'btn-ok',
                                    icon: 'glyphicon glyphicon-ok',
                                    label: ' OK',
                                    cssClass: 'btn-success btn-padrao',
                                    autospin: false,
                                    action: function(dialogRef) {
                                        dialogRef.close();
                                    }
                                }]
                        });
                    })
                    .error(function(data, status) {
                        console.log('erro ao deletar pais ' + data);
                        BootstrapDialog.show({
                            title: 'Notifica&ccedil;&atilde;o',
                            message: 'Ocorreu um erro ao deletar o Pais: <b>' + pais.nome + '</b>',
                            type: BootstrapDialog.TYPE_DANGER,
                            buttons: [{
                                    id: 'btn-ok',
                                    icon: 'glyphicon glyphicon-ok',
                                    label: ' OK',
                                    cssClass: 'btn-success btn-padrao',
                                    autospin: false,
                                    action: function(dialogRef) {
                                        dialogRef.close();
                                    }
                                }]
                        });
                    });
            } else {
                $scope.getTodos(1);
            }
        });
        

    };

    $scope.novo = function() {
        $scope.pais = getNovoPais();
        window.location = '#/cadastropais';
    }

    $scope.carregarPais = function() {
        console.log('carregando pais');
        if (!$routeParams.paisId)
            return;//se não tiver id não buscar

        $http.get('./rest/paisSource/pais/' + $routeParams.paisId)
                .success(function(pais, status) {
                    $scope.pais = pais;
                });
    }

    $scope.editar = function(pais) {
        window.location = '#/cadastropais/' + pais.id;
    }
    
    $scope.buscaPaisContendoNome = function () {
    	console.log($scope.busca);
    	$http.get('./rest/paisSource/pais?q=' + $scope.busca)
    		.then(function (retorno){
    			console.log(retorno.data.list);
    			$scope.paises = retorno.data;
    		});
    }   
    		

    $scope.salvar = function() {
        
        $scope.pais.nome = $scope.pais.nome.toUpperCase();
        $scope.pais.sigla = $scope.pais.sigla.toUpperCase();
        
        console.log($scope.pais)
        $http.post('./rest/paisSource/pais', $scope.pais)
            .success(function(pais, status) {
                $scope.pais = getNovoPais();
                console.log('pais editado = ' + pais);
                BootstrapDialog.show({
                    title: 'Notifica&ccedil;&atilde;o',
                    message: 'Pais <b>' + pais.nome + '</b> salvo com sucesso!',
                    type: BootstrapDialog.TYPE_SUCCESS,
                    buttons: [{
                            id: 'btn-ok',
                            icon: 'glyphicon glyphicon-ok',
                            label: ' OK',
                            cssClass: 'btn-success btn-padrao',
                            autospin: false,
                            action: function(dialogRef) {
                                dialogRef.close();
                            }
                        }]
                });
            })
            .error(function(data, status) {
                console.log('pais nao salvo = ' + data);
                BootstrapDialog.show({
                    title: 'Notifica&ccedil;&atilde;o',
                    message: 'Ocorreu um erro ao salvar o Pais: <b>' + pais.nome + '</b>',
                    type: BootstrapDialog.TYPE_DANGER,
                    buttons: [{
                            id: 'btn-ok',
                            icon: 'glyphicon glyphicon-ok',
                            label: ' OK',
                            cssClass: 'btn-success btn-padrao',
                            autospin: false,
                            action: function(dialogRef) {
                                dialogRef.close();
                            }
                        }]
                });
            });
    };

    $scope.getTodos = function(numeroPagina) {
    	console.log(numeroPagina);
        $http.get('./rest/paisSource/listar/pag/' + numeroPagina)
            .success(function(listaPaises, status) {
                $scope.paises = listaPaises;
            })
            .error(function(data, status) {
                console.log('erro ao buscar paises ' + data);
            });
    }

    function getNovoPais() {
        console.log('novo pais');
        return {};
    }

    $scope.voltar = function() {
        $scope.pais = {};
        window.location = '#/listapais';
    }

}