'use strict';
var controllers = angular.module('controllers');

function PessoaController($scope, $routeParams, pessoaService, paisService, estadoService, cidadeService) {
    $scope.select2='one';
    console.log('Carregando controller');
    
    $scope.modificarPais = function(paisId){
    	$scope.unidadeFederativa = {};
    	$scope.cidade = {};
    	if(!paisId || paisId == null)
    		return ;
    	estadoService.buscaEstadosPorPais(paisId)
    	.success(function(data,status){
    		$scope.unidadesFederativas = data;
    	});
    };
    
    $scope.validaCpf = function(cpf) {
        if (!ValidarCPF(cpf)) {
            toastr.warning("CPF inválido.");
            $scope.pessoaFisica.cpf = $scope.pessoaFisica.c;
        }
    };
    
    $scope.validaCnpj = function(cnpj){
    	if(!ValidarCNPJ(cnpj)){
    		toastr.warning("CNPJ inválido.");
    		$scope.pessoaJuridica.cnpj = $scope.pessoaJuridica.c;
    	}
    };    
    
    $scope.modificarEstado = function(estadoId){
    	if(!$scope.endereco.cidade)
    		$scope.cidade = {};
    	if(!estadoId || estadoId == null)
    		return;
    	cidadeService.buscaCidadesPorEstado(estadoId)
    	.success(function(data,status){
    		$scope.cidades = data;
    	});
    };
    
    var buscarSelecionado = function () {
    	
    	var selecionados = $.grep($scope.endereco.paises, function (item) {
    		return item.id == $scope.idPais;
    	});
    	
    	console.log(selecionados[0]);
    	
    	$scope.pais = selecionados[0];
    };

    $scope.deletar = function(pessoa) {
        console.log('deletando pessoa ' + JSON.stringify(pessoa));
        
        BootstrapDialog.confirm('Deseja realmente deletar a Pessoa: <b>' + pessoa.nome +'</b>?', function(result) {
            if (result) {
            	pessoaJuridicaService.deletar(pessoa)
               		.success(function (data) {
                        $scope.getTodos(1);
                        console.log('Pessoa deletada');
                        toastr.success(pessoa.nome+" deletado com sucesso.");                       
                    })
                    .error(function (data) {
                        console.log('erro ao deletar pessoa ' + data);
                        console.log(data.messageDeveloper);
                        toastr.error(data.message);
                    });
            }
        });

    };
    
    $scope.novo = function() {
        console.log('Nova Pessoa');
        window.location = '#/pessoa';
    };    
	
    $scope.carregarPessoa = function() {
    	console.log('carregando pessoa');
        
        if (!$routeParams.pessoaId){
            $scope.pessoa = $scope.getNovaPessoaFisica();
            $scope.tipoPessoa = 'F';
            $scope.papeis = [
                {id: '01', nome:'ALUNO'}
            ];
            return;//se não tiver id não buscar
        }
        
        pessoaJuridicaService.buscar($routeParams.pessoaJuridicaId)
                .success(function(p) {
                    $scope.pessoaJuridica = p;
                });
    };
    
	var carregaPaises = function() {
    	console.log('carregando pais');
        paisService.buscarTodos()
            .success(function(listaPaises) {
                console.log(listaPaises);
                $scope.paises = listaPaises;
            })
            .error(function(data) {
                console.log('erro ao buscar paises ' + data);
            });
    };
    
    $scope.editar = function(p) {
        window.location = '#/pessoa/' + p.id;
    };
    
    $scope.init = function(){
        $scope.endereco = {};
        $scope.enderecos = [];
        $scope.pais = {};
        $scope.unidadeFederativa = {};
        $scope.cidade = {};
        carregaPaises();
    };
    
    $scope.buscaPessoaContendoNome = function () {
    	console.log($scope.busca);    	
    	pessoaJuridicaService.buscarPorNome($scope.busca)
            .then(function (retorno){
                console.log(retorno.data.list);
                $scope.pessoas = retorno.data;
            });
    }; 

    $scope.filtroPessoaJuridica = function() {
        console.log("filtro pessoa juridica");
        $scope.pessoas = [
            {nome: 'Unicesumar', cpfCnpj: '11111111111', data: '01/01/1980', email: 'unicesumar@email.com'}
        ];
    };
    
    $scope.filtroPessoaFisica = function() {
        console.log("filtro pessoa fisica");
        $scope.pessoas = [
            {nome: 'Winicius', cpfCnpj: '988888888-99', data: '01/01/1995', email: 'contato@email.com'}
        ];
    };
    
    $scope.filtroAluno = function() {
        console.log("aluno");
        $scope.pessoas = [
            { nome : 'Martinho', cpfCnpj : '999999999-99', data : '16/03/1990', email : 'contato@email.com' }
        ];
    };

    $scope.salvar = function() {
    	pessoaJuridicaService.salvar($scope.pessoaJuridica)
            .success(function(pf) {
                $scope.pessoaJuridica = getNovaPessoaJuridica();
                toastr.success('Pessoa Juridica '+pf.nome+' salvo com sucesso.');
            })
            .error(function(data) {
                console.log('Pessoa juridica não salva ', data);
                toastr.warning(data.message);
                console.log(data.messageDeveloper);
            });
    };
    
    $scope.getTodos = function(numeroPagina) {
        /*
    	console.log(numeroPagina);
    	$scope.pessoasJuridicas = [];
    	pessoaJuridicaService.listar(numeroPagina)
            .success(function(listaPessoasJuridicas, status) {
                $scope.pessoasJuridicas = listaPessoasJuridicas;
            })
            .error(function(data, status) {
                console.log('erro ao buscar paises ' + data);
            });
        */
    };
    
    $scope.getNovaPessoaJuridica = function(){
        return {
            id: null,
            nome: null,
            razaoSocial: null,
            dataCriacao: null,
            inscricaoMunicipal: null,
            cnpj: null,
            inscricaoEstadual: null,
            email: null,
            telefones: [],
            enderecos: []
        };
    };
    
    $scope.getNovaPessoaFisica = function() {
        return {
            id: null,
            papel: 'ALUNO',
            nome: null,
            sobrenome: null,
            sexo: 'M',
            rg: null,
            cpf: null,
            dataNascimento: null,
            email: null,
            telefones: [],
            enderecos: []
        };
    };
	
    $scope.select2Options = {
        	
    };
    
    $scope.voltar = function() {
        //$scope.pessoaJuridica = getNovaPessoaJuridica();
        window.location = '#/listapessoa';
    };

//Novo telefone
    
    $scope.novoTelefone = function(){
    	$scope.telefone = getNovoTelefone();
    };

    $scope.salvarTelefone = function() {
        if ($scope.indiceTelefone >= 0){
            $scope.pessoaJuridica.telefones.splice($scope.indiceTelefone, 1);
        }
        $scope.pessoaJuridica.telefones.push($scope.telefone);
        console.log($scope.telefones);
        toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
        $scope.telefone = getNovoTelefone();
        $scope.indiceTelefone = {};
    };

    $scope.editarTelefone = function(indice) {
    	$scope.indiceTelefone = indice;
        $scope.telefone = angular.copy($scope.pessoaJuridica.telefones[indice]);
    };

    $scope.delTelefone = function(index) {
    	toastr.warning("Telefone removido  " + $scope.pessoaJuridica.telefones[index].numero + "!");
        $scope.pessoaJuridica.telefones.splice(index, 1);
    };
    
    
// Endereco    
    
    $scope.modificarCidade = function(cidadeId){
/*    	if($scope.endereco.cidade && $scope.indiceEndereco >= 0)
    		return;*/
    	cidadeService.buscar(cidadeId)
    		.success(function(c,status){
    			$scope.endereco.cidade = c;
    		});
    };

    $scope.salvarEndereco = function() {

        $scope.endereco.logradouro = angular.uppercase($scope.endereco.logradouro);
        $scope.endereco.bairro = angular.uppercase($scope.endereco.bairro);
        if($scope.endereco.complemento)
        	$scope.endereco.complemento = angular.uppercase($scope.endereco.complemento);
        if($scope.indiceEndereco >= 0){
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
    
    $scope.novoEndereco = function(){
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
    		tipoEndereco : 'RUA',
                principal : 'S'
    	};
    }
    
    function getNovoTelefone(){
    	return {
    		tipo : 'RESIDENCIAL'
    	};
    }
    
    jQuery(function($) {
        $.mask.definitions['~'] = '[+-]';
        $("#telefone").mask("(99) 9999-9999?9");
        $("#ramal").mask("9?");
        $("#cep").mask("99.999-999");
        $("#cpf").mask("999.999.999-99");
        $("#rg").mask("9.999.999-*");
        $("#cnpj").mask("99.999.999/9999-99");
    });
}

controllers.controller('PessoaController', ['$scope', '$routeParams', 'pessoaService', 'paisService', 'estadoService', 'cidadeService', PessoaController ]);