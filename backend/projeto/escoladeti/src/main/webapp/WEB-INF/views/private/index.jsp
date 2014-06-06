 <!DOCTYPE html>
<html lang="pt-br" ng-app="app">
    <head>
        <meta charset="UTF-8">
        <title> AMACAP </title>
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />
        <link href="./resources/css/submenudropdown.css" rel="stylesheet">
        <link href="./resources/css/bootstrap.css" rel="stylesheet">
        <link href="./resources/css/bootstrap-select.css" rel="stylesheet">
        <link href="./resources/css/bootstrap-dialog.min.css" rel="stylesheet">
        <link href="./resources/css/estilo-geral.css" rel="stylesheet">
        <script type="text/javascript" src="./resources/libs/jquery.js"></script>
        <script type="text/javascript" src="./resources/libs/jquery.maskedinput-1.3.1.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap-dialog.min.js"></script>
        <script src="./resources/libs/bootstrap-select.js"></script>
        <script type="text/javascript" src="./resources/libs/angular.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
        <script src="./resources/js/funcoes.js"></script>
        <script type="text/javascript" src="./resources/js/MascaraValidacao.js" ></script>		
        <script type="text/javascript" src="./resources/js/app.js"></script>
        <script type="text/javascript" src="./resources/js/PessoaFisicaController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroPJController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaPJController.js" ></script>
        <script type="text/javascript" src="./resources/js/ItemAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/PerfilAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/UsuarioController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaUsuarioController.js" ></script>
        <script type="text/javascript" src="./resources/js/PaisController.js" ></script>
        <script type="text/javascript" src="./resources/js/CidadeController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroEstadoController.js" ></script>
        <script type="text/javascript" src="./resources/js/EstadoController.js" ></script>
        <script type="text/javascript" src="./resources/js/DistritoController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/LivroController.js" ></script>
        <script type="text/javascript" src="./resources/js/EventoController.js" ></script>
        <script type="text/javascript" src="./resources/js/ParticipanteController.js" ></script>
        <script type="text/javascript" src="./resources/js/OrdemProducaoController.js" ></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="./resources/imagens/icone-amacap-cinza.png"/><span class="titulo-menu-amacap" >AMACAP</span> </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <!--dropdown listas-->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">Cadastros<b class="caret"></b></a>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                            <li class="dropdown-submenu">
                                <a tabindex="-1">Cliente</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#/listapessoafisica">Pessoa Física</a></li>
                                    <li><a href="#/listapessoajuridica">Pessoa Jurídica</a></li>
                                </ul>
                            </li>
                            <li class="dropdown-submenu">
                                <a tabindex="-1">Usuário</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#/listausuario">Usuário</a></li>
                                    <li><a href="#/listaperfilacesso">Perfil de acesso</a></li>
                                    <li><a href="#/listaitemacesso">Item de acesso</a></li>
                                </ul>
                            </li>
                            <li class="dropdown-submenu">
                                <a tabindex="-1">Localidade</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#/listapais">Pais</a></li>
                                    <li><a href="#/listaestado">Estado</a></li>
                                    <li><a href="#/listacidade">Cidade</a></li>
                                    <li><a href="#/listadistrito">Distrito</a></li>
                                    <li><a href="#/listabairro">Bairro</a></li>
                                    <li><a href="#/listacep">Faixa de CEP</a></li>
                                </ul>
                            </li>
                            <li class="dropdown-submenu">
                                <a tabindex="-1">Materiais</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#/listalivro">Livro</a></li>
                                </ul>
                            </li>
                            <li class="dropdown-submenu">
                                <a tabindex="-1">Eventos</a>
                                <ul class="dropdown-menu">
                                    <li><a href="#/cadastroparticipante">Participante</a></li>
                                    <!--<li><a href="#/cadastroevento">Evento</a></li>-->
                                    <li><a href="#/listaevento">Lista Eventos</a></li>
                                </ul>
                            </li>
                        </ul>	
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <!--dropdown listas-->
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown">Operações<b class="caret"></b></a>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                            <li><a href="#/listaordemproducao">Ordem de Produção</a></li>
                        </ul>    
                    </li>
                </ul>      
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a class=dropdown-toggle" data-toggle="dropdown" href="">
                            <span class="glyphicon glyphicon-user"></span> escoladeti@unicesumar.br <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
                            <li>
                                <a href="./logout">Sair</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
        <div ng-view></div>
    </body>
</html>
