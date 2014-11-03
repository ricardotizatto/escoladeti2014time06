<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="appExterno" lang="pt">
    <head>
        <title>AMACAP - Associação Maringaense de Amigos do CAP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A Associação Maringaense dos Amigos do Centro de Apoio Pedagógico (Amacap) é uma entidade assistencial que dá suporte ao Centro de Apoio Pedagógico (CAP) em Maringá, que produz material educacional adaptado para alunos com visão prejudicada, cegueira e surdez.">
        <meta name="author" content="Alunos da Escola de T.I. 2014 - Unicesumar - Time 6">
            
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,400">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Droid+Sans">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lobster">
        <link href="./resources/externo/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="./resources/externo/assets/prettyPhoto/css/prettyPhoto.css" rel="stylesheet">
        <link href="./resources/externo/assets/css/flexslider.css" rel="stylesheet">
        <link href="./resources/externo/assets/css/font-awesome.css" rel="stylesheet">
        <link href="./resources/externo/assets/css/style.css" rel="stylesheet">
    
        <!-- Favicon and touch icons -->
        <link href="./resources/externo/assets/img/icone-amacap.png" rel="shortcut icon">

    </head>
    <body ng-controller="ExternoController">
        
        <!-- Header -->
        <div class="container">
            <div class="header row">
                <div class="span12">
                    <div class="navbar">
                        <div class="navbar-inner">
                            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </a>
                            <h1>
                                <a href="#/home"> <img src="./resources/externo/assets/img/logo-amacap.png"></a>
                            </h1>
                            <div class="nav-collapse collapse">
                                <ul class="nav pull-right">
                                    <li class="{{ ativa == 'home' ? 'current-page' : '' }}"  ng-click="ativaBotao('home')" >
                                        <a href="#/home"><i class="icon-home"></i><br />Home</a>
                                    </li>
                                    <li class="{{ ativa == 'eventos' ? 'current-page' : '' }}" ng-click="ativaBotao('eventos')" >
                                        <a href="#/eventos"><i class="icon-camera"></i><br />Eventos</a>
                                    </li>
                                    <li class="{{ ativa == 'transcricoes' ? 'current-page' : '' }}"  ng-click="ativaBotao('transcricoes')" >
                                        <a href="#/transcricoes"><i class="icon-book"></i><br />Transcrições</a>
                                    </li>
                                    <li class="{{ ativa == 'sobre' ? 'current-page' : '' }}" ng-click="ativaBotao('sobre')" >
                                        <a href="#/sobre"><i class="icon-group"></i><br />Sobre</a>
                                    </li>
                                    <li class="{{ ativa == 'localizacao' ? 'current-page' : '' }}" ng-click="ativaBotao('localizacao')" >
                                        <a href="#/localizacao"><i class="icon-map-marker"></i><br />Localização</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>    

        <div class="page-content">
            <div class="clearfix"></div>
            <div class="content">
                <div ng-view></div>
            </div>
        </div>
        
        <!-- Footer -->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="widget span12">
                        <h4>Contato</h4>
                        <div class="span4">
                            <p><i class="icon-map-marker"></i>Endereço: <a href="#/localizacao">R. Martin Afonso, 50 - CEP 87010-410</a> </p>
                        </div>
                        <div class="span2">
                            <p><i class="icon-phone"></i> Tel: <a>(44) 3255-5498</a></p>
                        </div>
                        <div class="span3">
                            <p><i class="icon-envelope-alt"></i> Email: <a href="mailto:ricalex77@gmail.com">ricalex77@gmail.com</a></p>
                        </div>
                    </div>
                </div>
                <div class="footer-border"></div>
                <div class="row">
                    <div class="copyright span12">
                        Copyright 2014 Amacap - Todos os direitos reservados.
                        <span class="pull-right" >
                            <a class="link-credito" href="#/creditos" ng-click="ativaBotao('')">Sistema desenvolvido pelos alunos da Escola de T.I. 2014 - Unicesumar - Time 6</a>
                        </span>
                    </div>
                </div>
            </div>
        </footer>
    
        <!-- Javascript -->
        <script type="text/javascript" src="./resources/libs/angular.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-resource.min.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-utils.min.js"></script> 
        <script src="./resources/externo/assets/js/jquery-1.8.2.min.js"></script>
        <script src="./resources/externo/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="./resources/externo/assets/js/jquery.flexslider.js"></script>
        <script src="./resources/externo/assets/js/jquery.tweet.js"></script>
        <script src="./resources/externo/assets/js/jflickrfeed.js"></script>
        <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="./resources/externo/assets/js/jquery.ui.map.min.js"></script>
        <script src="./resources/externo/assets/js/jquery.quicksand.js"></script>
        <script src="./resources/externo/assets/prettyPhoto/js/jquery.prettyPhoto.js"></script>
        <script src="./resources/externo/assets/js/scripts.js"></script>
        <script src="./resources/externo/js/app.js"></script>
        <script src="./resources/externo/js/controller.js"></script>
    
    </body>
</html>
