<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta charset="UTF-8">
        <title> AMACAP </title>
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />
        <script type="text/javascript" src="./resources/libs/jquery.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>    
        <link rel="stylesheet" href="./resources/css/bootstrap.min.css" >
        <link href="./resources/css/estilo-geral.css" rel="stylesheet">
    </head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>AMACAP - Consulta de Livros</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="form-group col-sm-12">
                <legend><span class="glyphicon glyphicon-list-alt"></span> Livro</legend>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-5">
                <div class="input-group">
                    <span class="input-group-addon"> 
                        <span class="glyphicon glyphicon-search"></span>
                    </span> 
                    <input class="form-control" name="busca" type="text" onkeydown="toUpper(this)" placeholder="Busca por nome do livro" />
                </div>
            </div>
            <div class="form-group col-sm-7">
                <div>
                    <span class="pull-right">
                        <button type='submit' class='btn btn-primary btn-padrao' value='novo'>
                            <span class='glyphicon glyphicon-plus-sign'></span> Novo
                        </button>
                    </span>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12 table-responsive">
                <table class="table table-striped table-hover" id="livrosDisponiveis">
                    <tr>
                        <th class="col-md-4">Nome</th>
                        <th class="col-md-2">Autor</th>
                        <th class="col-md-2">Editora</th>
                        <th class="col-md-2">Disciplina</th>
                        <th class="col-md-1">Ano Ed.</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</body>
<script>
    $(document).ready(function() {
        $.getJSON("./rest/livroSource/livro", function(result) {
            $.each(result, function(i, field) {
                alert(field.list);/*
                $("#livrosDisponiveis").append("<tr>");
                $("#livrosDisponiveis").append("<td>"+1+"</td>");
                $("#livrosDisponiveis").append("<td>"+1+"</td>");
                $("#livrosDisponiveis").append("<td>"+1+"</td>");
                $("#livrosDisponiveis").append("<td>"+1+"</td>");
                $("#livrosDisponiveis").append("<td>"+1s+"</td>");
                $("#livrosDisponiveis").append("</tr>");*/
            });
        });
    });
</script>
</html>
