<!DOCTYPE html>
<html lang="pt-br" ng-app="app">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title> AMACAP </title>
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />

        <link href="./resources/css/submenudropdown.css" rel="stylesheet">
        <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
        <link href="./resources/css/bootstrap-dialog.min.css" rel="stylesheet">        
        <link href="./resources/css/toastr.css" rel="stylesheet">        
        <link href="./resources/css/jquery-ui.css" rel="stylesheet">
        <link href="./resources/css/select2.css" rel="stylesheet">
        <link href="./resources/css/estilo-geral.css" rel="stylesheet">

        <script type="text/javascript" src="./resources/libs/jquery.min.js"></script>
        <script type="text/javascript" src="./resources/libs/select2.js"></script>
        <script type="text/javascript" src="./resources/libs/jquery.maskedinput-1.3.1.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="./resources/libs/funcoes.js"></script>		
        <script type="text/javascript" src="./resources/libs/toastr.js"></script>
        <script type="text/javascript" src="./resources/js/MascaraValidacao.js" ></script>

        <script type="text/javascript" src="./resources/libs/angular.min.js"></script>        
        <script type="text/javascript" src="./resources/libs/angular-resource.min.js"></script>        
        <script type="text/javascript" src="./resources/libs/ui-bootstrap-tpls-0.11.0.min.js"></script>        
        <script type="text/javascript" src="./resources/libs/angular-ui.js"></script>        
        <script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-locale_pt-br.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-select2/select2.js"></script>  
        <script type="text/javascript" src="./resources/libs/ui-utils.min.js"></script>  

        <script type="text/javascript" src="./resources/js/app.js"></script>        
        <script type="text/javascript" src="./resources/js/pais/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/pais/service.js" ></script>
        <script type="text/javascript" src="./resources/js/estado/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/estado/service.js" ></script>
        <script type="text/javascript" src="./resources/js/cidade/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/cidade/service.js" ></script>
        <script type="text/javascript" src="./resources/js/distrito/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/distrito/service.js" ></script>
        <script type="text/javascript" src="./resources/js/solicitacao/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/solicitacao/service.js" ></script>           
        <script type="text/javascript" src="./resources/js/pessoa/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/pessoa/service.js" ></script>

        <script type="text/javascript" src="./resources/js/acompanhamentoSolicitacao/controller.js" ></script>

        <script type="text/javascript" src="./resources/js/ItemAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/PerfilAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/UsuarioController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaUsuarioController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/LivroController.js" ></script>
        <script type="text/javascript" src="./resources/js/EventoController.js" ></script>
        <script type="text/javascript" src="./resources/js/CepController.js" ></script>
        <script type="text/javascript" src="./resources/js/ParticipanteController.js" ></script>
        <script type="text/javascript" src="./resources/js/OrdemProducaoController.js" ></script>

        <link  rel="stylesheet" href="./resources/vendor/font-awesome/css/font-awesome.css" />
        <link  href="./resources/vendor/css/jquery.sidr.light.css">
        <link rel="stylesheet" href="./resources/vendor/css/custom-icons.css">
        <link rel="stylesheet" href="./resources/vendor/css/style.css">
        <link rel="stylesheet" href="./resources/vendor/css/responsive.css">     
        <link rel="stylesheet" href="./resources/vendor/css/custom-icon-set.css">        



        <script type="text/javascript" src="./resources/vendor/js/breakpoints.js"></script>
        <script type="text/javascript" src="./resources/vendor/js/core.js"></script>        
        <script type="text/javascript" src="./resources	/vendor/js/jquery.sidr.min.js"></script>

    </head>
    <body>
        <div class="header navbar navbar-inverse "> 
            <!-- BEGIN TOP NAVIGATION BAR -->
            <div class="navbar-inner">
                <div class="header-seperation"> 
                    <ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">
                        <li class="dropdown">
                            <a id="main-menu-toggle"
                               href="#main-menu" class="">
                                <div class="iconset top-menu-toggle-white"></div>
                            </a>
                        </li>
                    </ul>

                    <a href="./">
                        <img class="logo" src="./resources/imagens/icone-amacap-cinza.png" class="logo"/>
                    </a>	 

                    <ul class="nav pull-right notifcation-center">	
                        <li class="dropdown" > 
                            <a href="./" class="dropdown-toggle active" data-toggle=""> 
                                <div class="iconset top-home"></div> 
                            </a> 
                        </li>
                    </ul>

                </div>

                <div class="header-quick-nav" > 
                    <!-- BEGIN TOP NAVIGATION MENU -->
                    <div class="pull-left"> 
                        <ul class="nav quick-section">
                            <li class="quicklinks"> 
                                <a href="javascript:;" class="" id="layout-condensed-toggle" >
                                    <div class="iconset top-menu-toggle-dark"></div>
                                </a> 
                            </li>
                        </ul>
                    </div>
                    <div class="pull-right">
                        <div class="chat-toggler">
                            <a href="#">
                                <div class="user-details username">
                                    <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="#" id="user-options">	
                                        ADMIN
                                    </a>
                                    <ul class="dropdown-menu  pull-right" role="menu" aria-labelledby="user-options">
                                        <li><a href="./logout"><i class="fa fa-power-off"></i>&nbsp;&nbsp;Sair</a></li>
                                    </ul>
                                </div>
                            </a>
                        </div>
                    </div>			
                </div>
            </div>
        </div>    	
        <div class="page-container row">
            <div class="page-sidebar" id="main-menu">
                <ul>
                    <li>
                        <a href="#">
                            <i class="fa fa-location-arrow"></i>
                            <span class="title">Localidade</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="#/listapais">Pais</a></li>
                            <li><a href="#/listaestado">Estado</a></li>
                            <li><a href="#/listacidade">Cidade</a></li>
                            <li><a href="#/listadistrito">Distrito</a></li>
                            <li><a href="#/listabairro">Bairro</a></li>
                            <li><a href="#/listacep">Faixa de CEP</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#/listalivro">
                            <i class="fa fa-book"></i>
                            <span class="title">Livros</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-user"></i>
                            <span class="title">Usuários</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="#/listausuario">Usuário</a></li>
                            <li><a href="#/listaperfilacesso">Perfil de acesso</a></li>
                            <li><a href="#/listaitemacesso">Item de acesso</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#/listapessoa">
                            <i class="fa fa-male"></i>
                            <span class="title">Pessoas</span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-star-half-o"></i>
                            <span class="title">EVENTOS</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="#/cadastroparticipante">Participante</a></li>
                            <!--<li><a href="#/cadastroevento">Evento</a></li>-->
                            <li><a href="#/listaevento">Eventos</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-cog"></i>
                            <span class="title">PRODUÇÃO</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="#/listasolicitacoes">Solicitação</a></li>
                            <li><a href="#/acompanhamento">Acompanhamento de Solicitação</a></li>
                            <li><a href="#/listaordemproducao">Ordem de Produção</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-folder"></i>
                            <span class="title">Materiais</span>
                        </a>
                        <ul class="sub-menu">
                            <li><a href="#/listalivro">Livro</a></li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="page-content">
                <div class="clearfix"></div>
                <div class="content">
                    <div ng-view></div>
                </div>
            </div>
        </div>

    </body>
</html>
