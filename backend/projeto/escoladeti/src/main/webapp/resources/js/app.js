'use strict';
var appCabecalho = angular.module('cabecalho', ['ngRoute']);

appCabecalho.config(['$routeProvider',
    function($routeProvider) {

        $routeProvider
            .when('/login', {
                templateUrl: './pages/Login.html',
                controller: 'LoginController'
            })
            .when('/pessoafisica', {
                templateUrl: './pages/CadastroPessoaFisica.html',
                controller: 'pessoaFisicaController'
            })
            .when('/pessoafisica/:pessoaFisicaId', {
                templateUrl: './pages/CadastroPessoaFisica.html',
                controller: 'pessoaFisicaController'
            })
            .when('/pessoajuridica', {
                templateUrl: './pages/CadastroPessoaJuridica.html',
                controller: 'CadastroPJController'
            })
            .when('/cadastrousuario', {
                templateUrl: './pages/CadastroUsuario.html',
                controller: 'usuarioController'
            })
            .when('/cadastrousuario/:usuarioId', {
                templateUrl: './pages/CadastroUsuario.html',
                controller: 'usuarioController'
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
                controller: 'paisController'
            })
            .when('/cadastropais', {
                templateUrl: './pages/CadastroPais.html',
                controller: 'paisController'
            })
            .when('/cadastroestado', {
                templateUrl: './pages/CadastroEstado.html',
                controller: 'EstadoController'
            })
            .when('/cadastroestado/:id', {
                templateUrl: './pages/CadastroEstado.html',
                controller: 'EstadoController'
            })
            .when('/cadastrocidade', {
                templateUrl: './pages/CadastroCidade.html',
                controller: 'cidadeController'
            })
            .when('/cadastrocidade/:cidadeId', {
                templateUrl: './pages/CadastroCidade.html',
                controller: 'cidadeController'
            })
            .when('/cadastrodistrito', {
                templateUrl: './pages/CadastroDistrito.html',
                // controller : 'nomeDoController'
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
                // controller : 'nomeDoController'
            })
            .when('/listapais', {
                templateUrl: './pages/ListaPais.html',
                controller: 'paisController'
            })
            .when('/listaestado', {
                templateUrl: './pages/ListaEstado.html',
                // controller : 'nomeDoController'
            })
            .when('/listapessoafisica', {
                templateUrl: './pages/ListaPF.html',
                controller: 'pessoaFisicaController'
            })
            .when('/listapessoajuridica', {
                templateUrl: './pages/ListaPessoaJuridica.html',
                controller: 'ListaPJController'
            })
            .when('/listacidade', {
                templateUrl: './pages/ListaCidade.html',
                // controller : 'nomeDoController'
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
                controller: 'perfilUsuarioController'
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
                controller: 'eventoController'
            })
            .when('/listaordemproducao', {
                templateUrl: './pages/ListaOrdemProducao.html',
                controller: 'OrdemProducaoController'
            })
            .when('/ordemproducao', {
                templateUrl: './pages/OrdemProducao.html',
                controller: 'OrdemProducaoController'
            })
            .when('/ordemproducaoparte', {
                templateUrl: './pages/OrdemProducaoParte.html',
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
            .when('/cadastroevento/:eventoId', {
                templateUrl: './pages/CadastroEvento.html',
                controller: 'eventoController'
            })		
            .when('/principal', {
                templateUrl: './pages/Principal.html'
            //    controller: 'principalController'
            })
            .otherwise({redirectTo: '/principal'
            });
    }
]);


appCabecalho.factory('bd', function() {
    return {name: 'banco de dados'};
});