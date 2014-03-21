<!DOCTYPE html>
<html lang="pt">
	<head>
		<meta charset="UTF-8">
		<title> Esola de TI - Time 06</title>
		<link href="./Lib/css/bootstrap.css" rel="stylesheet">
		<script src="./Lib/js/jquery.js"></script>
		<script src="./Lib/js/bootstrap.min.js"></script>		
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
			      <li class="dropdown">
			        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Cadastros <b class="caret"></b></a>
			        <ul class="dropdown-menu">
			          <li><a href="#">Cliente</a></li>
			        </ul>
			      </li>
			    </ul>
		    	<ul class="nav navbar-nav navbar-right">
		      		<li><a href="#">Sair</a></li>
		   		</ul>
		  	</div><!-- /.navbar-collapse -->
		</nav>
		<div class="container">
			<label> &nbsp; </label>
			<fieldset>
					<div class="row">
						<div class="form-group col-sm-6 col-sm-offset-3">
							<legend> 
								<span class="glyphicon glyphicon-user"></span> Cadastro de Usuário 
							</legend>
						</div>
					</div>
					<form action="" method="POST" role="form">		
						<div class="row">
							<div class="form-group col-sm-6 col-sm-offset-3">
								<label> Nome </label>
								<input class="form-control" name="nome" type="text" />
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6 col-sm-offset-3">
								<label> E-mail </label>
								<input class="form-control" name="email" type="text" />
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-3 col-sm-offset-3">
								<label>Senha</label>
								<input  class="form-control" name="senha" type="password"/>
							</div>
							<div class="form-group col-sm-3">
								<label>Confirmar senha</label>
								<input  class="form-control" name="senha" type="password"/>
							</div>
						</div>	
						<div class="row">
							<div class="form-group col-sm-3 col-sm-offset-3">
								<label>Perfil</label>
								<select class="form-control" name="tipoEndereco">
										<option>Vendedor</option>
										<option>Estagiario</option>
										<option>Outros</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>Data de expiração</label>
								<input  class="form-control" name="dataExpiracao" type="text"/>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3  col-sm-offset-7">	
								<a href="#" class="btn btn-danger ">
									<span class="glyphicon glyphicon-remove" ></span>Cancelar 
								</a>
								<button type="submit" class="btn btn-success" >
									<span class="glyphicon glyphicon-ok" ></span>Salvar </a>	
								</button>		
							</div>
						</div>			
					</form>
			</fieldset>
			<hr>
		</div>
	</body>
</html>