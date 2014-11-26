var controllers = angular.module('controllers');

function SolicitacaoController($scope, $location, $log, $routeParams, $http, Solicitacao, Pessoa, Cidade, BuscaCep) {
    $log.debug('iniciando SolicitacaoController em teste6d');

	var ItemCorrente = function () {
		this.outro = "";
		this.traducaoMaterial = "BRAILLE";
//		this.livro = {};
		this.status = 'AGUARDANDO';
        this.BuscaCep = BuscaCep;
	};	

	$scope.itemCorrente = new ItemCorrente();

    $scope.select2Options = {
      allowClear: true
    };

    $scope.buscarEndereco = function () {
//
//        var endereco = $scope.pessoasOriginal.filter(function (pessoa) {
//                console.log(pessoa);
//                return $scope.solicitacao.responsavel == pessoa.id;
//            })
//            .pop()
//            .enderecos
//            .filter(function (endereco) {
//                return endereco.principal == 'S';
//            })
//            .pop();
//
//        var solicitacao = $scope.solicitacao;
//        solicitacao.cep = endereco.cep;
//        solicitacao.numeroEndereco = endereco.numero;
//        solicitacao.endereco = endereco.logradouro;
//        solicitacao.municipio = {
//            text: endereco.cidade.nome + ' - ' + endereco.cidade.unidadeFederativa.sigla,
//            id: endereco.cidade.id
//        };
//

    };

	$scope.select2Cidade = {
		allowClear: true,
		placeholder: 'selecione',

        ajax: {
            url: './rest/cidadeSource/cidade',

            data: function (termo) {
                var termoPesquisa;

                if (termo)  {
                    termoPesquisa = termo.toUpperCase();
                }
                return {
                    q: termoPesquisa
                };

            },
            results: function (data, page) {

                var cidades = data.list.map(function (cidade) {
                    return {
                        text: cidade.nome + ' - ' + cidade.unidadeFederativa.sigla,
                        id: cidade.id
                    };
                });

                return {
                    results: cidades
                };
            }         
        },
        
        initSelection: function(element, callback) {
        	var valor = element.val();
        	console.log('valor busca cidade',valor);
        	Cidade.buscar(valor).success(function (cidade) {
        		console.log('cidade', cidade);
        		callback({
        			text: cidade.nome,
        			id: cidade.id
        		});
        		
        	});        	
        }
	

	};

    $scope.select2Livro = {
        allowClear: true,
        placeholder: 'selecione',

        ajax: {
            url: './rest/livroSource/livro',

            data: function (termo) {
                var termoPesquisa;

                if (termo)  {
                    termoPesquisa = termo.toUpperCase();
                }
                return {
                    q: termoPesquisa
                };

            },
            results: function (data, page) {

                var livros = data.list.map(function (livro) {
                    return {
                        text: livro.nome,
                        id: livro.id
                    };
                });

                $scope.livros = livros;

                return {
                    results: livros
                };
            }
        },

        initSelection: function(element, callback) {
            var valor = element.val();

            $http({
                method: 'GET',
                url: './rest/livroSource/livro/'+valor
            }).success(function (livro) {

                callback({
                    text: livro.nome,
                    id: livro.id
                })

            });

        }


    };


    Cidade.buscarTodos().success(function (cidades) {
        //console.log('cidades:',cidades);
        $scope.cidades = cidades;
    });
	
	$scope.enviarSolicitacao = function () {
		$log.debug('enviando solicitacao');

        $scope.solicitacao.itensSolicitacao.forEach(function (item) {
            item.livro = item.livro.id
        });
		
		if ($scope.solicitacao.municipio) {
			$scope.solicitacao.municipio = $scope.solicitacao.municipio.id;
		}
		
		if ($scope.solicitacao.nre) {
			$scope.solicitacao.nre = $scope.solicitacao.nre.id;
		}
		
		if ($scope.solicitacao.id) {
			$scope.solicitacao.$update(function () {
				toastr.success('salvo com sucesso');
                $location.path('/listasolicitacoes');
			});
			
			return;
		} 
				
		$scope.solicitacao.$save(function () {
			toastr.success('Salvo com sucesso.');
            $location.path('/listasolicitacoes');
		});
	};
	
	$scope.editar = function(solicitacao) {
		$location.path('/cadastrosolicitacao/'+ solicitacao.id);
	};

    $scope.excluirItem = function (item) {
        console.log('excluindo item');
        var index = $scope.solicitacao.itensSolicitacao.indexOf(item);
        $scope.solicitacao.itensSolicitacao.splice(index, 1);
    };
	
	$scope.carregarSolicitacao = function () {
		$log.debug('carrgegando solicitacao x');
		
		if (!$routeParams.idSolicitacao) {
			
			$scope.solicitacao = new Solicitacao({
				ensino: 'FUNDAMENTAL',
				serie: '1-SERIE',
				itensSolicitacao : []
			});
			
			$log.debug('criando solicitacao', $scope.solicitacao);
			return;
		}
		
		$log.debug('buscando solicitacao', Solicitacao);
		Solicitacao.get({id: $routeParams.idSolicitacao}, function(solicitacao) {
			$scope.solicitacao = solicitacao;
			$scope.solicitacao.aluno = solicitacao.aluno ? solicitacao.aluno.id : null;
			$scope.solicitacao.nre = solicitacao.nre ? solicitacao.nre.id : null;
			$scope.solicitacao.municipio = solicitacao.municipio ? solicitacao.municipio.id : null;
			$scope.solicitacao.responsavel = solicitacao.responsavel ? solicitacao.responsavel.id : null;
			$scope.solicitacao.escola = solicitacao.escola ? solicitacao.escola.id : null;
			
//			solicitacao.itensSolicitacao.forEach(function (item) {
//				item.livro = item.livro.id;
//			});

		});
	};
	
	Solicitacao.paginar({pagina: 1}, function (pagina) {
		$scope.pagina = pagina;
	});
	
    $log.debug('listar pessoas');
    Pessoa.listarTodasPessoaFisicas(function (pessoas) {
        $scope.pessoasOriginal = pessoas;
        $scope.pessoas = pessoas;
    });
    
    Pessoa.listarTodasAsEscolas(function (escolas) {
        $scope.escolasOriginal = escolas;

            $scope.escolas = escolas.map(function (escola) {
            return {
                nome: escola.nome,
                id: escola.id
            };
        });
    });

	
	$http({
		method: 'GET',
		url: './rest/livroSource/livros'
	}).success(function (data) {
		$scope.livros = data;

        $scope.livros.forEach(function (livro) {
            livro.text = livro.nome
        })
	});

	
	$scope.getDescricaoMaterial = function (item) {		
		var livro = buscarLivro(item.livro.id);
		
		if (livro)
			return livro.text;
	};
	
	function buscarLivro(idLivro) {
		var selecionados = $.grep($scope.livros, function (item) {
    		return item.id == idLivro;
    	});
		return angular.copy(selecionados[0]);
	}
	
	$scope.novo = function () {
		$location.path('/cadastrosolicitacao');		
		$scope.solicitacao = new Solicitacao();
	};
	
	$scope.voltar = function(){
		$location.path('/listasolicitacoes');
	};
	
	$scope.adicionarMaterial = function () {
        var livroId  = $scope.itemCorrente.livro.id,
            traducao = $scope.itemCorrente.traducaoMaterial,
            outro = $scope.itemCorrente.outro;

        $scope.solicitacao.itensSolicitacao.forEach(function (item) {
            console.log(item);
            if (livroId === item.livro.id
                && traducao == item.traducaoMaterial) {
                toastr.warning('Livro já adicionado para esta tradução.');
                livroId = null;
            }
        });

        console.log(traducao);
        if (traducao === 'OUTRO' && !outro) {
            toastr.warning('É necessário especificar a tradução.');
            return;
        }

        if (outro) {
            $scope.itemCorrente.outro = outro.toUpperCase();
        }

        if (!livroId) {
            return;
        }

        $('#modalLivro').modal('hide');
		$scope.solicitacao.itensSolicitacao.push($scope.itemCorrente);
		$scope.itemCorrente = new ItemCorrente();
	};
        
    $("#cep").mask("99999-999");

    $scope.buscarSolicitacao = function () {
        var  param = {
            termo: $scope.buscaSolicitacao,
            pagina: 1
        };

        Solicitacao.paginar(param, function (pagina) {
            $scope.pagina = pagina;
        });
    };

    $scope.buscarPagina = function (numero) {
        Solicitacao.paginar({pagina: numero}, function (pagina) {
            $scope.pagina = pagina;
        });
    };

	
	$scope.getStatusItem = function (status) {
		console.log(item);
		switch (status) {
			case 'AGUARDANDO':
				return 'warning';
			case 'PRODUCAO':
				return 'primary';
			case 'CANCELADO':
				return 'danger';
		}
	};
	
}

controllers.controller('SolicitacaoController',  
		[
		 '$scope',
		 '$location',
		 '$log',
		 '$routeParams',
		 '$http',
		 'SolicitacaoFactory',
         'PessoaFactory',
         'cidadeService',
         'BuscaCepFactory',
		 SolicitacaoController
		 ]);