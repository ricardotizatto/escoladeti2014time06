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
			controller : 'CadastroUsuarioController'
		})
		.when('/cadastroperfilusuario',{
			templateUrl : './pages/CadastroPerfilUsuario.html',
			controller : 'cadastroPerfilUsuarioController'
		})
		.when('/cadastrotela',{
			templateUrl : './pages/CadastroTela.html',
			controller : 'cadastroTelaController'
		})
		.when('/cadastropais',{
			templateUrl : './pages/CadastroPais.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastroestado',{
			templateUrl : './pages/CadastroEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocidade',{
			templateUrl : './pages/CadastroCidade.html',
			// controller : 'nomeDoController'
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
			// controller : 'nomeDoController'
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
			// controller : 'nomeDoController'
		})
		.when('/listaperfilusuario',{
			templateUrl : './pages/ListaPerfilUsuario.html',
			controller : 'listaPerfilUsuarioController'
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