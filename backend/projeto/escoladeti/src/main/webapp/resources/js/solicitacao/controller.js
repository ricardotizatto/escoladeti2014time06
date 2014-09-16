var controllers = angular.module('controllers');

function SolicitacaoController($scope, $location, $log, $routeParams, $http, Solicitacao, Pessoa, Cidade, BuscaCep) {
    $log.debug('iniciando SolicitacaoController em teste6d');

	var ItemCorrente = function () {
		this.outro = "";
		this.traducaoMaterial = "BRAILLE";
		this.livro = null;
		this.status = 'AGUARDANDO';
        this.BuscaCep = BuscaCep;
	};	

	$scope.itemCorrente = new ItemCorrente();

    $scope.select2Options = {
      allowClear: true
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


    Cidade.buscarTodos().success(function (cidades) {
        //console.log('cidades:',cidades);
        $scope.cidades = cidades;
    });
	
	$scope.enviarSolicitacao = function () {
		$log.debug('enviando solicitacao');
		
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
			toastr.success('salvo com sucesso');
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
			
			solicitacao.itensSolicitacao.forEach(function (item) {
				item.livro = item.livro.id; 
			});

		});
	};
	
	Solicitacao.paginar({pagina: 1}, function (pagina) {
		$scope.pagina = pagina;
	});
	
    $log.debug('listar alunos');
    Pessoa.listarAlunos(function (alunos) {
        $scope.alunos = alunos.map(function (aluno) {
            return {
                nome: aluno.nome + ' ' + aluno.sobrenome,
                id: aluno.id
            };
        });
    });


    Pessoa.listarPessoasFisicas(function (pessoasFisicas) {
        $scope.pessoasFisicas = pessoasFisicas.map(function (pessoa) {
            return {
                nome: pessoa.nome + ' ' + pessoa.sobrenome,
                id: pessoa.id
            }
        });
    });
	
	$http({
		method: 'GET',
		url: './rest/livroSource/livros'			
	}).success(function (data) {
		$scope.livros = data;
	});
	
	
	$scope.getDescricaoMaterial = function (item) {		
		var livro = buscarLivro(item.livro);
		
		if (livro)
			return livro.nome;
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
        var livroId  = $scope.itemCorrente.livro,
            traducao = $scope.itemCorrente.traducaoMaterial,
            outro = $scope.itemCorrente.outro;

        $scope.solicitacao.itensSolicitacao.forEach(function (item) {
            console.log(item);
            if (livroId === item.livro
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