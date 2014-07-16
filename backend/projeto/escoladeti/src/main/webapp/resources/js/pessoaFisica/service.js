services = angular.module("services");

function PessoaFisicaService($http) {	
	console.log('carregando service pessoa fisica');
	return {
		
		deletar: function (pessoaFisica) {
			 return $http({
                 method: 'DELETE',
                 data: pessoaFisica,
                 url: './rest/pessoaFisicaSource/pessoaFisica',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/pessoaFisicaSource/pessoaFisica?q=' + filtro.toUpperCase());
		},
		
		buscar: function (pessoaFisicaId) {
			return $http.get('./rest/pessoaFisicaSource/pessoaFisica/' +  pessoaFisicaId);
		},
		editar : function(pessoaFisica){
			return $http({
				method : 'PUT',
				data : pessoaFisica,
				url : './rest/pessoaFisicaSource/pessoaFisica',
				headers: {'Content-Type': 'application/json; charset=UTF-8'}
			});
		},
		
		salvar: function (pessoaFisica) {
			console.log(pessoaFisica.telefones);
			return $http.post('./rest/pessoaFisicaSource/pessoaFisica', {
				id : pessoaFisica.id,
				nome : pessoaFisica.nome.toUpperCase(),
				sobrenome : pessoaFisica.sobrenome.toUpperCase(),
				sexo : pessoaFisica.sexo,
				rg : pessoaFisica.rg,
				cpf : pessoaFisica.cpf,
				dataNascimento : pessoaFisica.dataNascimento,
				email : pessoaFisica.email.toUpperCase(),
				telefones : pessoaFisica.telefones,
				enderecos : pessoaFisica.enderecos
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/pessoaFisicaSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/pessoaFisicaSource/listar');
		}
	};
}

services.factory('pessoaFisicaService', ['$http', PessoaFisicaService]);

