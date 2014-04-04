'use strict';
var appCabecalho = angular.module('cabecalho', ['ngRoute']);

appCabecalho.config(['$routeProvider',
	function ($routeProvider) {
		
		$routeProvider
		.when('/pessoafisica',{
			templateUrl : 'partials/FormPF.html'
		})
		.when('/pessoajuridica',{
			templateUrl : 'partials/FormPJ.html'
		});
	}
]);