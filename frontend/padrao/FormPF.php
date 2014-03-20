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
			<ul class="nav nav-tabs">
  				<li class="active"><a href="FormPF.php">Pessoa Física</a></li>
 				<li><a href="FormPJ.php">Pessoa Jurídica</a></li>
			</ul>
			<label> &nbsp; </label>
			<fieldset>
				<legend> <span class="glyphicon glyphicon-user"></span> Cadastro de Cliente </legend>
					<form action="" method="POST" role="form">
						<input type="hidden" name="metodo" value="salvar"/>
						
						<div class="row ">
							<div class="form-group col-sm-6">
									<label> Nome </label>
									<input class="form-control" name="nome" type="text" />
							</div>
							<div class="form-group col-sm-6">
									<label> Sobrenome </label>
									<input class="form-control" name="sobrenome" type="text" />
							</div>
						</div>	
						<div class="row">
							<div class="form-group col-sm-4">
								<label>Sexo</label>
								<div>
									<div class="btn-group" data-toggle="buttons">
										 <label class="btn btn-primary ">
											<input name="sexo" value="M" type="radio" /> <label>Masculino</label>
										 </label>
										 <label class="btn btn-primary">
											<input name="sexo" value="F" type="radio" />  <label>Feminino</label
										 </label>
									</div>
								</div>
							</div>
							<div class="form-group col-sm-2">
									<label> Data de Nascimento </label>
									<input class="form-control" name="dataNascimento" type="text" />
							</div>
							<div class="form-group col-sm-3">
									<label> RG </label>
									<input class="form-control" name="dataNascimento" type="text" />
							</div>
							<div class="form-group col-sm-3">
									<label> CPF </label>
									<input class="form-control" name="dataNascimento" type="text" />
							</div>	
						</div>
						<div class="row">
							<div class="form-group col-sm-3">
								<label>Telefone Fixo</label>
								<div class="input-group">
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-phone-alt"></span>
									</span>
									<input class="form-control" name="telefoneFixo" type="text">
								</div>
							</div>
							<div class="form-group col-sm-3">
								<label>Celular</label>
								<div class="input-group">
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-phone"></span>
									</span>
							  		<input class="form-control" name="celular" type="text">			  
								</div>
							</div>	
							<div class="form-group col-sm-6">
								<label>Email</label>
								<div class="input-group" >
									<span class="input-group-addon" >
										<span class="glyphicon glyphicon-envelope"></span>
									</span>
								<input class="form-control" name="email" type="text">
								</div>
							</div>
						</div>
						<legend> <span class="glyphicon glyphicon-home"></span> Endereço </legend>
						<div class="row">
							<div class="form-group col-sm-2">
								<label>Tipo</label>
								<select class="form-control" name="tipoEndereco">
										<option>Avenida</option>
										<option>Rua</option>
										<option>Praça</option>
										<option>Estrada</option>
										<option>Alameda</option>
										<option>Ladeira</option>
										<option>Travessa</option>
										<option>Rodovia</option>
										<option>Outros</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>Logradouro</label>
								<input  class="form-control" name="descEndereco" type="text"/>
							</div>
							<div class="form-group col-sm-2">
								<label>Número</label>
								<input  class="form-control" name="numero" type="number"/>
							</div>
							<div class="form-group col-sm-4">
								<label>Cep</label>
								<input  class="form-control" name="cep" type="text"/>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<label>Bairro</label>
								<input  class="form-control" name="complemento" type="text"/>
							</div>
							<div class="form-group col-sm-6">
								<label>Complemento</label>
								<input  class="form-control" name="complemento" type="text"/>
							</div>
						</div>
						<div class="row">
							<div class="form-group col-sm-6">
								<label>Cidade</label>
								<input  class="form-control" name="cidade" type="text"/>
							</div>
							<div class="form-group col-sm-3">
								<label>Estado</label>
								<select class="form-control" name="estado">
										<option>Estado</option>
										<option>Estado</option>
										<option>Estado</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>Pais</label>
								<select class="form-control" name="estado">
										<option>Pais</option>
										<option>Pais</option>
										<option>Pais</option>
								</select>
							</div>
						</div>
						
						<div class="row pull-right">
							<div class="col-sm-12">	
								<a href="AcaoCliente.php" class="btn btn-danger">
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