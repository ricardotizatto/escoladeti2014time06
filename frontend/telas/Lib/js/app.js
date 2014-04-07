'use strict';
var appCabecalho = angular.module('cabecalho', ['ngRoute']);

appCabecalho.config(['$routeProvider',
	function ($routeProvider) {
		
		$routeProvider
		.when('/pessoafisica',{
			templateUrl : 'partials/FormPF.html',
			controller : 'PessoaFisicaController'
		})
		.when('/pessoajuridica',{
			templateUrl : 'partials/FormPJ.html',
			controller : 'PessoaJuridicaController'
		})
		.when('/cadastrousuario',{
			templateUrl : 'partials/CadastroUsuario.html',
			controller : 'CadastroUsuarioController'
		})
		.when('/cadastroperfilusuario',{
			templateUrl : 'partials/CadastroPerfilUsuario.html',
			controller : 'CadastroPerfilUsuarioController'
		})
		.when('/cadastrotela',{
			templateUrl : 'partials/CadastroTela.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastropais',{
			templateUrl : 'partials/CadastroPais.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastroestado',{
			templateUrl : 'partials/CadastroEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocidade',{
			templateUrl : 'partials/CadastroCidade.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrodistrito',{
			templateUrl : 'partials/CadastroDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrobairro',{
			templateUrl : 'partials/CadastroBairro.html',
			// controller : 'nomeDoController'
		})
		.when('/cadastrocep',{
			templateUrl : 'partials/CadastroCep.html',
			// controller : 'nomeDoController'
		})
		.when('/listadistrito',{
			templateUrl : 'partials/ListaDistrito.html',
			// controller : 'nomeDoController'
		})
		.when('/listapais',{
			templateUrl : 'partials/ListaPais.html',
			// controller : 'nomeDoController'
		})
		.when('/listaestado',{
			templateUrl : 'partials/ListaEstado.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoafisica',{
			templateUrl : 'partials/ListaPF.html',
			// controller : 'nomeDoController'
		})
		.when('/listapessoajuridica',{
			templateUrl : 'partials/ListaPJ.html',
			// controller : 'nomeDoController'
		})
		.when('/listacidade',{
			templateUrl : 'partials/ListaCidade.html',
			// controller : 'nomeDoController'
		})
		.otherwise({redirectTo: '/'
		});
	}
]);
