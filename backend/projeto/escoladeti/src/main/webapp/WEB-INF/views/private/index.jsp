<%@page  pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

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
        <script type="text/javascript" src="./resources/libs/underscore-min.js"></script>
        <script type="text/javascript" src="./resources/libs/jquery.maskedinput-1.3.1.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap-dialog.min.js"></script>
        <script type="text/javascript" src="./resources/libs/funcoes.js"></script>		
        <script type="text/javascript" src="./resources/libs/toastr.js"></script>
        <script type="text/javascript" src="./resources/js/MascaraValidacao.js" ></script> 
        <script type="text/javascript" src="./resources/libs/jquery.maskMoney.min.js" ></script>

        <script type="text/javascript" src="./resources/libs/angular.min.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-bootstrap-tpls-0.11.0.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-ui.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-resource.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-locale_pt-br.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-select2/select2.js"></script>
        <script type="text/javascript" src="./resources/libs/select2.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-utils.min.js"></script>  

        <script type="text/javascript" src="./resources/js/app.js"></script>
        <script type="text/javascript" src="./resources/js/aplicacao/aplicacao.js"></script>
        <script type="text/javascript" src="./resources/js/upload/directives.js"></script>
        <script type="text/javascript" src="./resources/js/upload/service.js"></script>
        <script type="text/javascript" src="./resources/js/directives.js"></script>
        <script type="text/javascript" src="./resources/js/filters.js"></script>
        <script type="text/javascript" src="./resources/js/buscacep/service.js"></script>
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
        <script type="text/javascript" src="./resources/js/caracteristica/service.js" ></script>        
        <script type="text/javascript" src="./resources/js/estoque/ProdutoController.js" ></script>
        <script type="text/javascript" src="./resources/js/estoque/MovimentoController.js" ></script>
        <script type="text/javascript" src="./resources/js/estoque/MovimentoService.js"></script>
        <script type="text/javascript" src="./resources/js/estoque/ProdutoService.js"></script>

        <script type="text/javascript" src="./resources/js/ordemProducao/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/ordemProducao/service.js" ></script>
        <script type="text/javascript" src="./resources/js/volume/service.js" ></script>
        <script type="text/javascript" src="./resources/js/volume/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/acompanhamentoSolicitacao/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/acompanhamentoSolicitacao/service.js" ></script>

        <script type="text/javascript" src="./resources/js/usuario/controller.js" ></script>       
        <script type="text/javascript" src="./resources/js/ItemAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/PerfilAcessoController.js" ></script>
        <script type="text/javascript" src="./resources/js/PerfilAcessoUsuarioController.js"></script>
        <script type="text/javascript" src="./resources/js/ListaUsuarioController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaBairroController.js" ></script>
        <script type="text/javascript" src="./resources/js/CadastroCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/ListaCepController.js" ></script>
        <script type="text/javascript" src="./resources/js/LivroController.js" ></script>
        <script type="text/javascript" src="./resources/js/EventoController.js" ></script>
        <script type="text/javascript" src="./resources/js/ChamadaController.js" ></script>
        <script type="text/javascript" src="./resources/js/ParticipanteController.js" ></script>
        <script type="text/javascript" src="./resources/js/relatorioAssociado/RelatorioController.js" ></script>


        <link  rel="stylesheet" href="./resources/vendor/font-awesome/css/font-awesome.css" />
        <link  href="./resources/vendor/css/jquery.sidr.light.css">
        <link rel="stylesheet" href="./resources/vendor/css/custom-icons.css">
        <link rel="stylesheet" href="./resources/vendor/css/style.css">
        <link rel="stylesheet" href="./resources/vendor/css/responsive.css">
        <link rel="stylesheet" href="./resources/vendor/css/custom-icon-set.css">



        <script type="text/javascript" src="./resources/vendor/js/breakpoints.js"></script>
        <script type="text/javascript" src="./resources/vendor/js/core.js"></script>        
        <script type="text/javascript" src="./resources/vendor/js/moment.js"></script>
        <script type="text/javascript" src="./resources	/vendor/js/jquery.sidr.min.js"></script>

    </head>
    <body data-ng-controller="Appcontroller as ctrl" ng-cloak >
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
                            <a href="./" class="active">
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
                            <a href="javascript:void(0)">
                                <div class="user-details username">

                                    <a data-toggle="dropdown" class="dropdown-toggle  pull-right " href="javascript:void(0)" id="user-options">
                                        {{ctrl.user.username}}
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
            <div class="page-sidebar" id="main-menu" style="position: fixed">
                <ul>
                    <li data-ng-repeat="item in ctrl.menu">
                        <a href="#" >
                            <i class="fa {{item.icone}}"></i>
                            <span class="title">{{item.grupo}}</span>
                        </a>
                        <ul class="sub-menu">
                            <li data-ng-repeat="tela in item.telas">
                                <a href="#/{{tela.url}}">
                                    <span class="title">{{tela.nome}}</span>
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>

            <div class="page-content">
                <div class="clearfix"></div>
                <div class="content container">
                    <div ng-view></div>
                </div>
            </div>
        </div>

    </body>
</html>
