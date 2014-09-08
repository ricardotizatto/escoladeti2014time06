'use strict';


angular.module('controllers', ['services']);
angular.module('services', []);
angular.module('directives', []);
var app = angular.module('app', 
		['ngRoute',
		 'ngResource',
		 'controllers',
         'directives',
		 'ui.select2',
		 'ui.bootstrap']);

app.config(['$routeProvider',
    function($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: './pages/Login.html',
                controller: 'LoginController'
            })
            .when('/pessoa', {
                templateUrl: './pages/pessoa/cadastro.html',
                controller: 'PessoaController'
            })
            .when('/pessoa/:pessoaId/:pessoaTipo', {
                templateUrl: './pages/pessoa/cadastro.html',
                controller: 'PessoaController'
            })
            .when('/listapessoa', {
                templateUrl: './pages/pessoa/lista.html',
                controller: 'PessoaController'
            })
            .when('/cadastrousuario', {
                templateUrl: './pages/CadastroUsuario.html',
                controller: 'UsuarioController'
            })
            .when('/cadastrousuario/:usuarioId', {
                templateUrl: './pages/CadastroUsuario.html',
                controller: 'UsuarioController'
            })
            .when('/cadastroperfilacessousuario/:usuarioId', {
                templateUrl: './pages/CadastroPerfilAcessoUsuario.html',
                controller: 'PerfilAcessoUsuarioController'
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
                templateUrl: './pages/pais/cadastro.html',
                controller: 'PaisController'
            })
            .when('/cadastropais', {
                templateUrl: './pages/pais/cadastro.html',
                controller: 'PaisController'
            })
            .when('/cadastroestado', {
                templateUrl: './pages/estado/cadastro.html',
                controller: 'EstadoController'
            })
            .when('/cadastroestado/:unidadeFederativaId', {
                templateUrl: './pages/estado/cadastro.html',
                controller: 'EstadoController'
            })
            .when('/cadastrocidade', {
                templateUrl: './pages/cidade/cadastro.html',
                controller: 'CidadeController'
            })
            .when('/cadastrocidade/:cidadeId', {
                templateUrl: './pages/cidade/cadastro.html',
                controller: 'CidadeController'
            })
            .when('/cadastrodistrito', {
                templateUrl: './pages/CadastroDistrito.html',
                controller : 'DistritoController'
            })
            .when('/cadastrodistrito/:distritoId', {
                templateUrl: './pages/CadastroDistrito.html',
                controller : 'DistritoController'
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
                controller : 'DistritoController'
            })
            .when('/listapais', {
                templateUrl: './pages/pais/lista.html',
                controller: 'PaisController'
            })
            .when('/listaestado', {
                templateUrl: './pages/estado/lista.html',
                controller : 'EstadoController'
            })
            .when('/listacidade', {
                templateUrl: './pages/cidade/lista.html',
                controller : 'CidadeController'
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
            .when('/acompanhamento', {
                templateUrl: './pages/acompanhamentoSolicitacao/acompanhamento.html',
                 controller: 'acompanhamentoSolicitacaoController'
            })
            .when('/cadastroparticipanteevento', {
                templateUrl: './pages/CadastroParticipanteEvento.html',
                controller: 'participanteController'
            })
            .when('/cadastroparticipanteevento/:idParticipante', {
                templateUrl: './pages/CadastroParticipanteEvento.html',
                controller: 'participanteController'
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

app.config([
             '$httpProvider',
             function ($httpProvider) {
                 $httpProvider.interceptors.push('AuthInterceptor');
             }
         ]);

app.factory('AuthInterceptor', ['$q',
                                AuthInterceptor
                                ]);
function  AuthInterceptor($q, $window) {
    return {

        responseError: function (rejection) {
            var data = rejection.data;

            if (data.message) {
                toastr.warning(data.message);
            }
            
            if (data.messageDeveloper) {
            	console.log(data.messageDeveloper);
            }

            return $q.reject(rejection);
        }

    };
}



