var controllers = angular.module('controllers');

function PessoaController($scope, $location, $log, $routeParams, $http, Pessoa) {
    $scope.select2 = 'one';
    console.log('Carregando controller');
    
    $scope.initCadastro = function() {
        $scope.carregarPessoa();
    };

    $scope.initLista = function() {
        $scope.tipoPessoa = 'F';
        $scope.filtroPessoaFisica();
    };
//
//    $scope.modificarPais = function(paisId) {
//        $scope.unidadeFederativa = {};
//        $scope.cidade = {};
//        if (!paisId || paisId === null)
//            return;
//        estadoService.buscaEstadosPorPais(paisId)
//                .success(function(data, status) {
//                    $scope.unidadesFederativas = data;
//                });
//    };

    $scope.validaCpf = function(cpf) {
        if (!ValidarCPF(cpf)) {
            toastr.warning("CPF inválido!");
            $scope.pessoa.cpf = $scope.pessoa.c;
        }
    };

    $scope.validaCnpj = function(cnpj) {
        if (!ValidarCNPJ(cnpj) && $scope.pessoa.aluno !== 'true') {
            toastr.warning("CNPJ inválido!");
            $scope.pessoa.cnpj = $scope.pessoa.c;
        }
    };
    
    $scope.validaEmail = function() {
        if(ValidaEmail($scope.pessoa.email) === false)
           toastr.warning("E-mail inválido!"); 
    };

//    $scope.modificarEstado = function(estadoId) {
//        if (!$scope.endereco.cidade)
//            $scope.cidade = {};
//        if (!estadoId || estadoId === null)
//            return;
//        cidadeService.buscaCidadesPorEstado(estadoId)
//                .success(function(data, status) {
//                    $scope.cidades = data;
//                });
//    };

//    var buscarSelecionado = function() {
//
//        var selecionados = $.grep($scope.endereco.paises, function(item) {
//            return item.id === $scope.idPais;
//        });
//
//        console.log(selecionados[0]);
//
//        $scope.pais = selecionados[0];
//    };

    $scope.novo = function() {
        console.log('Nova Pessoa');
        window.location = '#/pessoa';
    };
    
    $scope.carregarPessoa = function() {
        console.log('carregando pessoa:');

        if (!$routeParams.pessoaId) {
            $scope.novaPessoa("F"); 
            $log.debug('criando pessoa');
            return;
        }
        
        $log.debug('buscando pessoa');
        Pessoa.get({id: $routeParams.pessoaId, tipo: $routeParams.pessoaTipo}, function(pessoa) {
            
            $scope.pessoa = pessoa;
            if(pessoa.tipo !== 'J'){
               $scope.pessoa.aluno = String(pessoa.aluno); 
            }
        });
    };


//    var carregaPaises = function() {
//        console.log('carregando pais');
//        paisService.buscarTodos()
//                .success(function(listaPaises) {
//                    console.log(listaPaises);
//                    $scope.paises = listaPaises;
//                })
//                .error(function(data) {
//                    console.log('erro ao buscar paises ' + data);
//                });
//    };


    $scope.editar = function(p) {
        window.location = '#/pessoa/' + p.id + '/' + p.tipo;
    };

    $scope.buscaPessoaContendoNome = function(tipoPessoa) {
        $scope.busca = $scope.busca.toUpperCase();
        if (tipoPessoa === 'F') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarFisica({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.construirPagina(pagina);
                });
            } else {
                $scope.filtroPessoaFisica();
            }
        }
        if (tipoPessoa === 'J') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarJuridica({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.construirPagina(pagina);
                });
            } else {
                $scope.filtroPessoaJuridica();
            }
        }
        if (tipoPessoa === 'A') {
            $scope.pagina = [];
            if ($scope.busca !== "") {
                Pessoa.buscarAluno({pagina: 1, busca: $scope.busca}, function(pagina) {
                    $scope.construirPagina(pagina);
                });
            } else {
                $scope.filtroAluno();
            }
        }
    };

    $scope.filtroPessoaJuridica = function() {
        console.log("filtro pessoa juridica");
        $scope.pagina = [];
        Pessoa.paginarJuridica({pagina: 1}, function(pagina) {
            $scope.construirPagina(pagina);
        });
    };

    $scope.filtroPessoaFisica = function() {
        console.log("filtro pessoa fisica");
        $scope.pagina = [];
        Pessoa.paginarFisica({pagina: 1}, function(pagina) {
            $scope.construirPagina(pagina);
        });
    };

    $scope.filtroAluno = function() {
        console.log("aluno");
        $scope.pagina = [];
        Pessoa.paginarAluno({pagina: 1}, function(pagina) {
            $scope.construirPagina(pagina);
        });
    };

    $scope.construirPagina = function(pagina) {
        for (i = 0; i < pagina.list.length; i++) {
            $scope.pagina[i] = {};
            $scope.pagina[i].id    = pagina.list[i].id;
            $scope.pagina[i].tipo  = pagina.list[i].tipo;
            $scope.pagina[i].email = pagina.list[i].email;
            if(pagina.list[i].tipo === 'J'){
                $scope.pagina[i].nome  = pagina.list[i].nome;
                $scope.pagina[i].doc   = pagina.list[i].cnpj;
                $scope.pagina[i].data  = pagina.list[i].dataCriacao;
            }else{
                $scope.pagina[i].aluno = pagina.list[i].aluno;
                $scope.pagina[i].nome  = pagina.list[i].nome + ' ' + pagina.list[i].sobrenome;
                $scope.pagina[i].doc   = pagina.list[i].cpf;
                $scope.pagina[i].data  = pagina.list[i].dataNascimento;
            }
        }
    };

    $scope.novaPessoa = function(tipo){
        if ($scope.tipo === "J") {
            $scope.pessoa = new Pessoa({
                tipo: "J",
                telefones: []
            });
        } else {
            $scope.pessoa = new Pessoa({
                tipo:  "F",
                aluno: "false",
                sexo:  "MASCULINO",
                telefones: []
            });
        }
    };

    $scope.salvar = function() {
 
        $scope.pessoa.nome = $scope.pessoa.nome.toUpperCase();
        $scope.pessoa.email = $scope.pessoa.email.toUpperCase();
        if($scope.pessoa.tipo === "J"){
            $scope.pessoa.razaoSocial = $scope.pessoa.razaoSocial.toUpperCase();
        }else{
            $scope.pessoa.sobrenome = $scope.pessoa.sobrenome.toUpperCase();
        }
        
        if ($scope.pessoa.id) {
            $scope.pessoa.$update(function() {
                toastr.success($scope.pessoa.nome + ' atualizado com sucesso');
                $scope.novaPessoa($scope.pessoa.tipo); 
            });
            return;
        }
        $scope.pessoa.$save(function() {
            toastr.success($scope.pessoa.nome + ' salvo com sucesso');           
            $scope.novaPessoa($scope.pessoa.tipo);
        });
    };
    
    $scope.deletar = function(pessoa) {

        BootstrapDialog.confirm('Deseja realmente deletar a Pessoa: <b>' + pessoa.nome + '</b>?', function(result) {
            if (result) {
                Pessoa.delete({id: pessoa.id, tipo: pessoa.tipo}, function() {
                    toastr.success(pessoa.nome + ' deletada com sucesso');
                    if ($scope.tipoPessoa === 'J') {
                        $scope.filtroPessoaJuridica();
                    } else {
                        if ($scope.tipoPessoa === 'A') {
                            $scope.filtroAluno();
                        } else {
                            $scope.filtroPessoaFisica();
                        }
                    }
                });
            }
            return;
        });
    };

    $scope.select2Options = {
    };

    $scope.voltar = function() {
        window.location = '#/listapessoa';
    };

//Novo telefone

    $scope.novoTelefone = function() {
        $scope.telefone = getNovoTelefone();
    };

    $scope.salvarTelefone = function() {
        if ($scope.indiceTelefone >= 0) {
            $scope.pessoa.telefones.splice($scope.indiceTelefone, 1);
        }
        $scope.pessoa.telefones.push($scope.telefone);
        console.log($scope.telefones);
        toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
        $scope.telefone = getNovoTelefone();
        $scope.indiceTelefone = {};
    };

    $scope.editarTelefone = function(indice) {
        $scope.indiceTelefone = indice;
        $scope.telefone = angular.copy($scope.pessoa.telefones[indice]);
    };

    $scope.delTelefone = function(index) {
        toastr.warning("Telefone removido  " + $scope.pessoa.telefones[index].numero + "!");
        $scope.pessoa.telefones.splice(index, 1);
    };


// Endereco    

    $scope.modificarCidade = function(cidadeId) {
        /*    	if($scope.endereco.cidade && $scope.indiceEndereco >= 0)
         return;*/
        cidadeService.buscar(cidadeId)
                .success(function(c, status) {
                    $scope.endereco.cidade = c;
                });
    };

    $scope.salvarEndereco = function() {

        $scope.endereco.logradouro = angular.uppercase($scope.endereco.logradouro);
        $scope.endereco.bairro = angular.uppercase($scope.endereco.bairro);
        if ($scope.endereco.complemento)
            $scope.endereco.complemento = angular.uppercase($scope.endereco.complemento);
        if ($scope.indiceEndereco >= 0) {
            $scope.pessoaJuridica.enderecos.splice($scope.indiceEndereco, 1);
        }
        $scope.pessoaJuridica.enderecos.push($scope.endereco);
        toastr.success("Endereço adicionado !");
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.indiceEndereco = {};
    };

    $scope.editarEndereco = function(indice) {
        $scope.indiceEndereco = indice;
        $scope.endereco = angular.copy($scope.pessoaJuridica.enderecos[indice]);

        console.log($scope.endereco);

        $scope.pais = $scope.endereco.cidade.unidadeFederativa.pais;

        $scope.modificarPais($scope.pais.id);

        $scope.unidadeFederativa = $scope.endereco.cidade.unidadeFederativa;

        $scope.cidade = $scope.endereco.cidade;

        $scope.modificarCidade($scope.cidade.id);

        console.log($scope.cidade);
    };

    $scope.delEndereco = function(index) {
        toastr.warning("Endereço removido !");
        $scope.pessoaJuridica.enderecos.splice(index, 1);
    };

    $scope.novoEndereco = function() {
        $scope.endereco = getNovoEndereco();
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        $scope.cidades = [];
        $scope.unidadesFederativas = [];
        $scope.pais = {};
    };

    function getNovoEndereco() {
        return {
            tipoEndereco: 'RUA',
            principal: 'S'
        };
    }

    function getNovoTelefone() {
        return {
            tipo: 'CELULAR'
        };
    }

    jQuery(function($) {
        $.mask.definitions['~'] = '[+-]';
        $("#numeroDdd").mask("99");
        $("#telefone").mask("9999-9999?9");
        $("#ramal").mask("9?");
        $("#cep").mask("99.999-999");
        $("#cpf").mask("999.999.999-99");
        //$("#rg").mask("9.999.999-*");
        $("#cnpj").mask("99.999.999/9999-99");
    });
}

controllers.controller('PessoaController',
        [
            '$scope',
            '$location',
            '$log',
            '$routeParams',
            '$http',
            'PessoaFactory',
            PessoaController
        ]);