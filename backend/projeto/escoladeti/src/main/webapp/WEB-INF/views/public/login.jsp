<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
        <meta charset="UTF-8">
        <script type="text/javascript" src="./resources/libs/jquery.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>    
        <link rel="stylesheet" href="./resources/css/bootstrap.min.css" >
        <link href="./resources/css/estilo-geral.css" rel="stylesheet">
        <title>Escola de TI - 2014 - Time 6</title>
	</head>
	<body>
            <nav class="navbar navbar-inverse" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" > <span class="glyphicon glyphicon-globe"></span> AMACAP</a>
                </div>
            </nav>
		<div class="container">
			<div class="row text-center">
	            <div class="form-group col-md-4 col-md-offset-4">
					<h1>Login</h1>
				</div>
			</div>
			<form name='f' action="j_spring_security_check" method='POST'>
				<div class="row">
		            <div class="form-group col-md-4 col-md-offset-4">
		                <input type="text" class="form-control" placeholder="Usuário" name="j_username"/>
		            </div>
				</div>
				<div class="row">
		            <div class="form-group col-md-4 col-md-offset-4">
		                <input type="password" class="form-control" placeholder="Senha" name="j_password"/>
		            </div>
				</div>
	            <div class="row">
	                <div class="form-group col-md-4 col-md-offset-4">
	                    <button type="submit" class="btn btn-success form-control"><i class="glyphicon glyphicon-ok"></i> Entrar</button>
	                </div>
	            </div>
				<c:if test="${loginError}">
		            <div class="row">
						<div class="col-md-4 col-md-offset-4 alert alert-danger text-center">
							Falha na autenticação.
						</div>
					</div>
				</c:if>
			</form>
		</div>
            <footer class="footer navbar-fixed-bottom">
                <div class="container">
                    <p>Unicesumar 2014 - Escola de T.I. - Time 06</p>
                </div>
            </footer>
	</body>
</html>