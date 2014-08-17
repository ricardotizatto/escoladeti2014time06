'use strict';


angular.module('controllers', ['services']);
angular.module('services', []);
var app = angular.module('app', ['ngRoute', 'controllers', 'ui.select2', 'ui.bootstrap']);

app.config(['$routeProvider',
    function($routeProvider) {

        $routeProvider
                .when('/login', {
                    templateUrl: './pages/Login.html',
                    controller: 'LoginController'
                })
                .when('/pessoafisica', {
                    templateUrl: './pages/CadastroPessoaFisica.html',
                    controller: 'PessoaFisicaController'
                })
                .when('/pessoafisica/:pessoaFisicaId', {
                    templateUrl: './pages/CadastroPessoaFisica.html',
                    controller: 'PessoaFisicaController'
                })
                .when('/pessoajuridica', {
                    templateUrl: './pages/CadastroPessoaJuridica.html',
                    controller: 'PessoaJuridicaController'
                })
                .when('/pessoajuridica/:pessoaJuridicaId', {
                    templateUrl: './pages/CadastroPessoaJuridica.html',
                    controller: 'PessoaJuridicaController'
                })
                .when('/cadastrousuario', {
                    templateUrl: './pages/CadastroUsuario.html',
                    controller: 'UsuarioController'
                })
                .when('/cadastrousuario/:usuarioId', {
                    templateUrl: './pages/CadastroUsuario.html',
                    controller: 'UsuarioController'
                })
                .when('/cadastroperfilacesso', {
                    templateUrl: './pages/CadastroPerfilAcesso.html',
                    controller: 'perfilAcessoController'
                })
                .when('/cadastroperfilacesso/:perfilAcessoId', {
                    templateUrl: './pages/CadastroPerfilAcesso.html',
                    controller: 'perfilAcessoController'
                })
                .when('/cadastroitemacesso', {
                    templateUrl: './pages/CadastroItemAcesso.html',
                    controller: 'itemAcessoController'
                })
                .when('/cadastroitemacesso/:itemAcessoId', {
                    templateUrl: './pages/CadastroItemAcesso.html',
                    controller: 'itemAcessoController'
                })
                .when('/cadastropais/:paisId', {
                    templateUrl: './pages/CadastroPais.html',
                    controller: 'PaisController'
                })
                .when('/cadastropais', {
                    templateUrl: './pages/CadastroPais.html',
                    controller: 'PaisController'
                })
                .when('/cadastroestado', {
                    templateUrl: './pages/CadastroEstado.html',
                    controller: 'EstadoController'
                })
                .when('/cadastroestado/:unidadeFederativaId', {
                    templateUrl: './pages/CadastroEstado.html',
                    controller: 'EstadoController'
                })
                .when('/cadastrocidade', {
                    templateUrl: './pages/CadastroCidade.html',
                    controller: 'CidadeController'
                })
                .when('/cadastrocidade/:cidadeId', {
                    templateUrl: './pages/CadastroCidade.html',
                    controller: 'CidadeController'
                })
                .when('/cadastrodistrito', {
                    templateUrl: './pages/CadastroDistrito.html',
                    controller: 'DistritoController'
                })
                .when('/cadastrodistrito/:distritoId', {
                    templateUrl: './pages/CadastroDistrito.html',
                    controller: 'DistritoController'
                })
                .when('/cadastrobairro', {
                    templateUrl: './pages/CadastroBairro.html',
                    // controller : 'nomeDoController'
                })
                .when('/cadastrocep', {
                    templateUrl: './pages/CadastroCep.html',
                    // controller : 'nomeDoController'
                })
                .when('/listadistrito', {
                    templateUrl: './pages/ListaDistrito.html',
                    controller: 'DistritoController'
                })
                .when('/listapais', {
                    templateUrl: './pages/ListaPais.html',
                    controller: 'PaisController'
                })
                .when('/listaestado', {
                    templateUrl: './pages/ListaEstado.html',
                    // controller : 'nomeDoController'
                })
                .when('/listapessoafisica', {
                    templateUrl: './pages/ListaPessoaFisica.html',
                    controller: 'PessoaFisicaController'
                })
                .when('/listapessoajuridica', {
                    templateUrl: './pages/ListaPessoaJuridica.html',
                    controller: 'PessoaJuridicaController'
                })
                .when('/listacidade', {
                    templateUrl: './pages/ListaCidade.html',
                    controller: 'CidadeController'
                })
                .when('/listabairro', {
                    templateUrl: './pages/ListaBairro.html',
                    // controller : 'nomeDoController'
                })
                .when('/listacep', {
                    templateUrl: './pages/ListaCep.html',
                    // controller : 'nomeDoController'
                })
                .when('/listausuario', {
                    templateUrl: './pages/ListaUsuario.html',
                    controller: 'UsuarioController'
                })
                .when('/listaperfilacesso', {
                    templateUrl: './pages/ListaPerfilAcesso.html',
                    controller: 'perfilAcessoController'
                })
                .when('/listaitemacesso', {
                    templateUrl: './pages/ListaItemAcesso.html',
                    controller: 'itemAcessoController'
                })
                .when('/cadastroparticipante', {
                    templateUrl: './pages/CadastroParticipante.html',
                    controller: 'participanteController'
                })
                .when('/listaordemproducao', {
                    templateUrl: './pages/ListaOrdemProducao.html',
                    controller: 'OrdemProducaoController'
                })
                .when('/ordemproducao', {
                    templateUrl: './pages/OrdemProducao.html',
                    controller: 'OrdemProducaoController'
                })
                .when('/ordemproducao/:ordemProducaoId', {
                    templateUrl: './pages/OrdemProducao.html',
                    controller: 'OrdemProducaoController'
                })
                .when('/cadastrolivro', {
                    templateUrl: './pages/CadastroLivro.html',
                    controller: 'livroController'
                })
                .when('/cadastrolivro/:livroId', {
                    templateUrl: './pages/CadastroLivro.html',
                    controller: 'livroController'
                })
                .when('/listalivro', {
                    templateUrl: './pages/ListaLivro.html',
                    controller: 'livroController'
                })
                .when('/listaevento', {
                    templateUrl: './pages/ListaEvento.html',
                    controller: 'eventoController'
                })
                .when('/listaparticipantes', {
                    templateUrl: './pages/ListaParticipantes.html',
                    controller: 'participanteController'
                })
                .when('/cadastroevento', {
                    templateUrl: './pages/CadastroEvento.html',
                    controller: 'eventoController'
                })
                .when('/listaparticipantes/:idevento', {
                    templateUrl: './pages/ListaParticipantes.html',
                    controller: 'participanteController'
                })
                .when('/cadastroevento/:eventoId', {
                    templateUrl: './pages/CadastroEvento.html',
                    controller: 'eventoController'
                })
                .when('/cadastropartematerial/:ordemProducaoId', {
                    templateUrl: './pages/CadastroParteMaterial.html',
                    controller: 'OrdemProducaoController'
                })
                .when('/cadastropartematerial/:ordemProducaoId/:parteMaterialId', {
                    templateUrl: './pages/CadastroParteMaterial.html',
                    controller: 'OrdemProducaoController'
                })
                .when('/principal', {
                    templateUrl: './pages/Principal.html'
                            //    controller: 'principalController'
                })
                .when('/cadastroparticipanteevento', {
                    templateUrl: './pages/cadastroparticipanteevento.html',
                    controller: 'CadastroParticipanteEventoController'
                })
                .when('/listasolicitacoes', {
                    templateUrl: './pages/solicitacao/lista.html',
                    controller: 'SolicitacaoController'
                })
                .when('/cadastrosolicitacao', {
                    templateUrl: './pages/solicitacao/cadastro.html',
                    controller: 'SolicitacaoController'
                })
                .when('/cadastrosolicitacao/:idSolicitacao', {
                    templateUrl: './pages/solicitacao/cadastro.html',
                    controller: 'SolicitacaoController'
                })
                .when('/consultalivro', {
                    templateUrl: './pages/consultalivro.html',
                    controller: 'ConsultaLivroController'
                })
                .when('/subMenu', {
                    controller: 'SubMenuController'
                })
                .when('/menu', {
                    controller: 'MenuController'
                })

                .otherwise({redirectTo: '/principal'
                });
    }
]);


app.directive('capitalize', function() {
    return {
        require: 'ngModel',
        link: function(scope, element, attrs, modelCtrl) {
            var capitalize = function(inputValue) {
                var capitalized = inputValue.toUpperCase();
                if (capitalized !== inputValue) {
                    modelCtrl.$setViewValue(capitalized);
                    modelCtrl.$render();
                }
                return capitalized;
            }
            modelCtrl.$parsers.push(capitalize);
            capitalize(scope[attrs.ngModel]);  // capitalize initial value
        }
    };
});


app.factory('bd', function() {
    return {name: 'banco de dados'};
});
