'use strict';
var appCabecalho = angular.module('cabecalho', ['ngRoute']);

appCabecalho.config(['$routeProvider',
	function ($routeProvider) {
		
		$routeProvider
		.when('/login',{
			templateUrl : './pages/Login.html',
			controller : 'LoginController'
		})
		.when('/pessoafisica',{
			templateUrl : './pages/FormPF.html',
			controller : 'PessoaFisicaController'
		})
		.when('/pessoajuridica',{
			templateUrl : './pages/CadastroPessoaJuridica.html',
			controller : 'CadastroPJController'
		})
		.when('/cadastrousuario',{
			templateUrl : './pages/CadastroUsuario.html',
			controller : 'usuarioController'
		})
                .when('/cadastrousuario/:usuarioId',{
			templateUrl : './pages/CadastroUsuario.html',
			controller : 'usuarioController'
		})
		.when('/cadastroperfilacesso',{
			templateUrl : './pages/CadastroPerfilAcesso.html',
			controller : 'perfilAcessoController'
		})
                .when('/cadastroperfilacesso/:perfilAcessoId',{
			templateUrl : './pages/CadastroPerfilAcesso.html',
			controller : 'perfilAcessoController'
		})
		.when('/cadastrotela',{
			templateUrl : './pages/CadastroTela.html',
			controller : 'cadastroTelaController'
		})
		.when('/cadastropais/:paisId',{
			templateUrl : './pages/CadastroPais.html',
			controller : 'paisController'
		})
		.when('/cadastropais',{
			templateUrl : './pages/CadastroPais.html',
			controller : 'paisController'
		})
		.when('/cadastroestado',{
			templateUrl : './pages/CadastroEstado.html',
			controller : 'EstadoController'
		})
		.when('/cadastroestado/:id',{
			templateUrl : './pages/CadastroEstado.html',
			controller : 'EstadoController'
		})
		.when('/cadastrocidade',{
			templateUrl : './pages/CadastroCidade.html',
			controller : 'cidadeController'
		})
		.when('/cadastrodistrito',{
			templateUrl : './pages/CadastroDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrobairro',{
			templateUrl : './pages/CadastroBairro.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocep',{
			templateUrl : './pages/CadastroCep.html',
			// controller : 'nomeDoController'
		})
		.when('/listadistrito',{
			templateUrl : './pages/ListaDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/listapais',{
			templateUrl : './pages/ListaPais.html',
			controller : 'paisController'
		})
		.when('/listaestado',{
			templateUrl : './pages/ListaEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoafisica',{
			templateUrl : './pages/ListaPF.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoajuridica',{
			templateUrl : './pages/ListaPessoaJuridica.html',
			controller : 'ListaPJController'
		})
		.when('/listacidade',{
			templateUrl : './pages/ListaCidade.html',
			// controller : 'nomeDoController'
		})
		.when('/listabairro',{
			templateUrl : './pages/ListaBairro.html',
			// controller : 'nomeDoController'
		})
		.when('/listacep',{
			templateUrl : './pages/ListaCep.html',
			// controller : 'nomeDoController'
		})
		.when('/listausuario',{
			templateUrl : './pages/ListaUsuario.html',
                        controller : 'perfilUsuarioController'
		})
		.when('/listaperfilacesso',{
			templateUrl : './pages/ListaPerfilAcesso.html',
			controller : 'perfilAcessoController'
		})
		.when('/listatela',{
			templateUrl : './pages/ListaTela.html',
			controller : 'listaTelaController'
		})
		.otherwise({redirectTo: '/'
		});
	}
]);


appCabecalho.factory('bd', function(){	
	return { name : 'banco de dados' };
});