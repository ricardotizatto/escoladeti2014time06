<!DOCTYPE html>
<html lang="pt" ng-app="cabecalho">
	<head>
		<meta charset="UTF-8">
		<title> Escola de TI - Time 06 </title>
		<link href="./resources/css/submenudropdown.css" rel="stylesheet">
		<link href="./resources/css/bootstrap.css" rel="stylesheet">
		<link href="./resources/css/bootstrap-select.css" rel="stylesheet">
		<link href="./resources/css/estilo-geral.css" rel="stylesheet">
		<script type="text/javascript" src="./resources/libs/jquery.js"></script>
		<script type="text/javascript" src="./resources/libs/jquery.maskedinput-1.3.1.min.js"></script>
		<script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>
		<script src="./resources/libs/bootstrap-select.js"></script>
		<script type="text/javascript" src="./resources/libs/angular.min.js"></script>
		<script type="text/javascript" src="./resources/libs/angular-route.min.js"></script>
		<script src="./resources/js/funcoes.js"></script>
		<script type="text/javascript" src="./resources/js/MascaraValidacao.js" ></script>		
		<script type="text/javascript" src="./resources/js/app.js"></script>
		<script type="text/javascript" src="./resources/js/PessoaFisicaController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroPJController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaPJController.js" ></script>
		<script type="text/javascript" src="./resources/js/TelaController.js" ></script>
		<script type="text/javascript" src="./resources/js/PerfilUsuarioController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroUsuarioController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaUsuarioController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaPerfilUsuarioController.js"></script>
		<script type="text/javascript" src="./resources/js/ListaTelaController.js"></script>
		<script type="text/javascript" src="./resources/js/PaisController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroEstadoController.js" ></script>
		<script type="text/javascript" src="./resources/js/EstadoController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroCidadeController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaCidadeController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroDistritoController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaDistritoController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroBairroController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaBairroController.js" ></script>
		<script type="text/javascript" src="./resources/js/CadastroCepController.js" ></script>
		<script type="text/javascript" src="./resources/js/ListaCepController.js" ></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse" role="navigation">
		  <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
			    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
			    	<span class="sr-only">Toggle navigation</span>
			      	<span class="icon-bar"></span>
			      	<span class="icon-bar"></span>
			      	<span class="icon-bar"></span>
			    </button>
			    <a class="navbar-brand" href="#"> <span class="glyphicon glyphicon-globe"></span> Escola de TI - Time 06 </a>
		    </div>
		    <!-- Collect the nav links, forms, and other content for toggling -->
		   <div class="collapse navbar-collapse navbar-ex1-collapse">
			    <ul class="nav navbar-nav">
			        <!--dropdown listas-->
			        <li class="dropdown">
			        	<a class="dropdown-toggle" data-toggle="dropdown">Listas <b class="caret"></b></a>
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
		                  			<li><a href="#/listaperfilusuario">Perfil de acesso</a></li>
		                  			<li><a href="#/listatela">Tela</a></li>
		                		</ul>
		         			</li>
							<li class="dropdown-submenu">
						  		<a tabindex="-1">Localidade</a>
								<ul class="dropdown-menu">
									<li><a href="#/listapais">Lista Pais</a></li>
									<li><a href="#/listaestado">Lista Estado</a></li>
									<li><a href="#/listacidade">Lista Cidade</a></li>
									<li><a href="#/listadistrito">Lista Distrito</a></li>
									<li><a href="#/listabairro">Lista Bairro</a></li>
									<li><a href="#/listacep">Lista CEP</a></li>
								</ul>
							</li>
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
	                    		<a href="#/login">Sair</a>
	                    	</li>
	                    </ul>
		    		</li>
		   		</ul>
		  	</div><!-- /.navbar-collapse -->
		</nav>
			<div ng-view></div>
		<footer class="footer navbar-fixed-bottom">
			<div class="container">
				<p>&nbsp; ® Unicesumar 2014 - Escola de T.I. - Time 06</p>
			</div>
		</footer>
	</body>
</html>