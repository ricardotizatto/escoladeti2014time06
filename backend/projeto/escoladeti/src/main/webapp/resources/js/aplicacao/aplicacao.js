angular.module('controllers')
    .controller('Appcontroller', ['$http', Appcontroller]);

function Appcontroller($http) {
    var vm = this,
        itens = [];


    $http.get('./rest/sessao').success(function (userDetails) {
        vm.user = userDetails;
        vm.menu = montarMenu(userDetails.authorities, itens);
    });

    function montarMenu(authorities, items) {
        var auths = authorities
            .map(function (auth) {
                return auth.authority;
            });


        return items
            .filter(function grupoPermitidosOuPublicos(item) {
                if (item.auth) {
                    return _.contains(auths, item.auth);
                }

                return true;
            })
            .map(function ajustarTelas(item) {

                var telas = item.telas
                    .filter(function filtrarTelas(tela) {
                        if (tela.auth) {
                            return _.contains(auths, tela.auth);
                        }

                        return true;
                    });

                var grupo = {
                    grupo: item.grupo,
                    telas: telas,
                    icone: item.icone
                };

                return grupo;
            })
            .filter(function possuiTelas(item) {
                return item.telas.length > 0;
            });
    }

    itens = [

        {
            grupo: 'LOCALIDADE',
            auth: 'LOCALIDADE',
            icone: 'fa-location-arrow',

            telas: [
                {
                    nome: 'PAIS',
                    url: 'listapais'
                },

                {
                    nome: 'ESTADO',
                    url: 'listaestado'
                },

                {
                    nome: 'CIDADE',
                    url: 'listacidade'
                }
            ]
        },

        {
            grupo: 'USUÁRIOS',
            auth: 'SEGURANCA',
            icone: 'fa-user',

            telas: [
                {
                    nome: 'USUÁRIO',
                    url: 'listausuario'
                },
                {
                    nome: 'PERFIL DE ACESSO',
                    url: 'listaperfilacesso'
                },
                {
                    nome: 'ITEM DE ACESSO',
                    url: 'listaitemacesso'
                }
            ]
        },

        {

            grupo: 'PESSOAS',
            icone: 'fa-male',

            telas: [
                {
                    nome: 'CADASTRO',
                    url: 'listapessoa',
                    auth: 'CADASTRO_PESSOA'
                },
                {
                    nome: 'RELATÓRIO ASSOCIADO',
                    url: 'relatorio/associados',
                    auth: 'RELATORIO_ASSOCIADO'
                }
            ]
        },

        {

            grupo: 'EVENTOS',
            icone: 'fa-star-half-o',

            telas: [
                {
                    nome: 'INSCRIÇÕES',
                    url: 'cadastroparticipante',
                    auth: 'INCRICAO_EVENTOS'
                },
                {
                    nome: 'EVENTOS',
                    url: 'listaevento',
                    auth: 'LISTA_EVENTOS'
                },
                {
                	nome : 'RELATÓRIO EVENTOS',
                	url : 'relatorio/eventos',
                	auth : 'RELATORIO_EVENTO'
                }
            ]
        },

        {

            grupo: 'PRODUÇÃO',
            icone: 'fa-cog',

            telas: [
                {
                    nome: 'SOLICITAÇÃO',
                    url: 'listasolicitacoes',
                    auth: 'SOLICITACAO'
                },
                {
                    nome: 'ACOMPANHAMENTO DE SOLICITAÇÃO',
                    url: 'acompanhamento',
                    auth: 'ACOMPANHAMENTO_SOLICITACAO'
                },
                {
                    nome: 'RELATÓRIO DE PRODUÇÃO',
                    url: 'relatorio/producao',
                    auth: 'RELATORIO_PRODUCAO'
                }                
            ]
        },

        {

            grupo: 'MATERIAIS',
            icone: 'fa-folder',

            telas: [
                {
                    nome: 'LIVRO',
                    url: 'listalivro',
                    auth: 'CADASTRO_LIVRO'
                }
            ]
        },

        {

            grupo: 'ESTOQUE',
            icone: 'fa-dropbox',

            telas: [
                {
                    nome: 'PRODUTO',
                    url: 'listaproduto',
                    auth: 'CADASTRO_PRODUTO'
                },
                {
                    nome: 'MOVIMENTO',
                    url: 'listamovimento',
                    auth: 'MOVIMENTO'
                }
            ]
        }
    ]

}


