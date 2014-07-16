services = angular.module("services");

function PessoaJuridicaService($http) {	
	console.log('carregando service pessoa juridica');
	return {
		
		deletar: function (pessoaJuridica) {
			 return $http({
                 method: 'DELETE',
                 data: pessoaJuridica,
                 url: './rest/pessoaJuridicaSource/pessoaJuridica',
                 headers: {'Content-Type': 'application/json; charset=UTF-8'}
             });
		},
		
		buscarPorNome: function (filtro) {
			return $http.get('./rest/pessoaJuridicaSource/pessoaJuridica?q=' + filtro.toUpperCase());
		},
		
		buscar: function (pessoaJuridicaId) {
			return $http.get('./rest/pessoaJuridicaSource/pessoaJuridica/' +  pessoaJuridicaId);
		},
		editar : function(pessoaJuridica){
			return $http({
				method : 'PUT',
				data : pessoaJuridica,
				url : './rest/pessoaJuridicaSource/pessoaJuridica',
				headers: {'Content-Type': 'application/json; charset=UTF-8'}
			});
		},
		
		salvar: function (pessoaJuridica) {
			console.log(pessoaJuridica.telefones);
			return $http.post('./rest/pessoaJuridicaSource/pessoaJuridica', {
				id : pessoaJuridica.id,
				nome : pessoaJuridica.nome.toUpperCase(),
				razaoSocial : pessoaJuridica.razaoSocial.toUpperCase(),
				dataCriacao : pessoaJuridica.dataCriacao,
				inscricaoEstadual : pessoaJuridica.inscricaoEstadual,
				cnpj : pessoaJuridica.cnpj,
				inscricaoMunicipal : pessoaJuridica.inscricaoMunicipal,
				email : pessoaJuridica.email.toUpperCase(),
				telefones : pessoaJuridica.telefones,
				enderecos : pessoaJuridica.enderecos
			});
		},
	
		listar: function (nrPagina) {
			return $http.get('./rest/pessoaJuridicaSource/listar/pag/' + nrPagina);
		},
		buscarTodos: function () {
			return $http.get('./rest/pessoaJuridicaSource/listar');
		}
	};
}

services.factory('pessoaJuridicaService', ['$http', PessoaJuridicaService]);

