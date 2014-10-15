(function() {
	'use strict';
	angular.module('filters', [])
		.filter('mascaraTelefoneNaLista',mascaraTelefoneNaLista)
		.filter('mascaraCpfNaLista',mascaraCpfNaLista)
		.filter('mascaraDataNaLista', mascaraDataNaLista)
		.filter('mascaraTelefoneNaListaPessoa', mascaraTelefoneNaListaPessoa);

	function mascaraTelefoneNaLista() {
		return function(telefone) {
			if (telefone) {
				var tel = String(telefone);
				var telefoneMascarado = '(' + tel.substring(0, 2) + ')' + ' '
						+ tel.substring(2, 6) + '-'
						+ tel.substring(6, tel.length);
				return telefoneMascarado;
			}
		};
	}
	function mascaraTelefoneNaListaPessoa() {
		return function(telefone) {
			if (telefone) {
				var tel = String(telefone);
				var telefoneMascarado = tel.substring(0, 4) + '-'
						+ tel.substring(4,tel.length);
				return telefoneMascarado;
			}
		};
	}	
	function mascaraCpfNaLista() {
		return function(cpfCnpj) {
			if (cpfCnpj) {
				if (cpfCnpj.length < 12) {
					var cpf = String(cpfCnpj);
					var cpfCnpjMascarado = cpf.substring(0, 3) + '.'
							+ cpf.substring(3, 6) + '.' + cpf.substring(6, 9)
							+ '-' + cpf.substring(9, cpf.length);
					return cpfCnpjMascarado;
				} else {
					var cnpj = String(cpfCnpj);
					var cpfCnpjMascarado = cnpj.substring(0, 2) + '.'
							+ cnpj.substring(2, 5) + '.' + cnpj.substring(5, 8)
							+ '/' + cnpj.substring(8, 12) + '-' + cnpj.substring(12, cpfCnpj.length);
					return cpfCnpjMascarado;
				}
			}
		};
	}
	function mascaraDataNaLista() {
		return function(data) {
			if (data) {
				var dt = String(data);
				var dataMascarada = dt.substring(6, 8) + '-'
						+ dt.substring(4, 6) + '-' + dt.substring(0, 4);
				return dataMascarada;
			}
		};
	}
}());