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

		.otherwise({redirectTo: '/'
		});
	}
]);
