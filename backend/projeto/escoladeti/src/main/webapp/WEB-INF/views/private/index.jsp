 <!DOCTYPE html>
<html lang="pt-br" ng-app="app">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <title> AMACAP </title>
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />

        <link href="./resources/css/submenudropdown.css" rel="stylesheet">
        <link href="./resources/css/bootstrap.css" rel="stylesheet">
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
        <script type="text/javascript" src="./resources/libs/ui-bootstrap-tpls-0.11.0.min.js"></script>        
        <script type="text/javascript" src="./resources/libs/angular-ui.js"></script>        
        <script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
        <script type="text/javascript" src="./resources/libs/angular-locale_pt-br.js"></script>
        <script type="text/javascript" src="./resources/libs/ui-select2/select2.js"></script>        

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
        <script type="text/javascript" src="./resources/js/pessoaFisica/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/pessoaFisica/service.js" ></script>
        <script type="text/javascript" src="./resources/js/pessoaJuridica/controller.js" ></script>
        <script type="text/javascript" src="./resources/js/pessoaJuridica/service.js" ></script>
      
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
        <script type="text/javascript" src="./resources/js/ParticipanteController.js" ></script>
        <script type="text/javascript" src="./resources/js/OrdemProducaoController.js" ></script>
        
        <link rel="stylesheet" href="./resources/vendor/css/jquery.sidr.light.css">
        <link rel="stylesheet" href="./resources/vendor/css/custom-icons.css">
        <link rel="stylesheet" href="./resources/vendor/css/custom-icon-set.css">        
        <link rel="stylesheet" href="./resources/vendor/css/responsive.css">
        <link rel="stylesheet" href="./resources/vendor/css/style.css">
        
        <script type="text/javascript" src="./resources/vendor/js/core.js"></script>
        <script type="text/javascript" src="./resources	/vendor/js/jquery.sidr.min.js"></script>
    </head>
    <body>
		<div class="header navbar navbar-inverse "> 
  <!-- BEGIN TOP NAVIGATION BAR -->
  			<div class="navbar-inner">
				<div class="header-seperation"> 
					<ul class="nav pull-left notifcation-center" id="main-menu-toggle-wrapper" style="display:none">
					</ul>
					<img src="./resources/imagens/icone-amacap-cinza.png" class="logo"/>
		
					<ul class="nav pull-right notifcation-center">	
        				<li class="dropdown" id="header_task_bar"> 
        					<a href="index.html" class="dropdown-toggle active" data-toggle=""> 
        						<div class="iconset top-home"></div> 
        					</a> 
        				</li>
        			</ul>
				</div>			
			</div>
		</div>    	
		<div class="page-container row">
			<div class="page-sidebar">
				<ul>
					<li>
						<a>
							<i class="icon-custom-form"></i>
							<span class="title"> Cadastros</span>
						</a>
					</li>
					<li>
						<a>
							<i class="icon-custom-portlets"></i>
							<span class="title">Operações</span>
						</a>
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
