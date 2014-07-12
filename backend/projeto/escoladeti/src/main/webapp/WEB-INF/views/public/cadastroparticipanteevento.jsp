<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="./resources/libs/jquery.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>     
        <script type="text/javascript" src="./resources/js/CadastroParticipanteEventoController.js" ></script>
        <link rel="stylesheet" href="./resources/css/bootstrap.min.css" >
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Participante Evento</title>
    </head>
    <body>
        <div class="container">
            <label>&nbsp;</label>
            <fieldset>
                <form action="" method="POST" name="participante" id="participante">
                    <div class="col-sm-7" style="height:400px; overflow:auto;" id="eventosDisponiveis">
                        <legend>Cursos Disponíveis</legend>
                    </div>
                    <div class="col-sm-1"></div>
                    <div class="form-group col-sm-4">
                        <legend>Dados Pessoais</legend>
                        <br>
                        <label>CPF</label>
                        <input class="form-control" type="text" onKeyPress="MascaraCPF(participante.cpf);" maxlength="14" placeholder="Número do CPF" name="cpf" id="cpf" required>
                        <label>RG</label>
                        <input class="form-control" type="text" placeholder="R.G." name="rg" id="rg" required>
                        <label>Nome</label>
                        <input class="form-control" type="text" placeholder="Nome" name="nome" id="nome" required>
                        <label>Email</label>
                        <input class="form-control" type="text" placeholder="Endereço de email" name="email" id="email" required>
                        <label>Telefone</label>
                        <input class="form-control" type="text" onKeyPress="MascaraTelefone(participante.telefone);" maxlength="15" placeholder="Telefone" name="telefone" id="telefone" required>
                        <input name="sexo" value="M" type="radio" name="masculino" id="masculino"><label>Masculino</label>
                        <input name="sexo" value="F" type="radio" name="feminino" id="feminino"><label>Feminino</label>
                        <br>    
                        <label>Deficiente</label>
                        <input name="deficiente" value="S" type="radio"><label>Sim</label>
                        <input name="deficiente" value="N" type="radio"><label>Não</label>
                    </div>
                    <div align="right">
                        <button type="button" class="btn btn-danger" id="limpar" >Limpar</button>
                        <button type="button" class="btn btn-success" id="confirmar" >Confirmar</button>
                    </div>
                    <!-- Modal detalhamento-->
                    <div class="modal fade" id="modalDetalhes" tabindex="-1" role="dialog" aria-labelledby="modalDetalhesLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                    <h4 class="modal-title" id="modalEnderecoLabel">Detalhes do Curso</h4>
                                </div>
                                <div class="modal-body">
                                    <div class="row">
                                        <div class="blogShort">
                                            <h1>{{tituloCurso}}</h1>
                                            <!--<em>This snippet use <a href="http://bootsnipp.com/snippets/featured/sexy-sidebar-navigation" target="_blank">Sexy Sidebar Navigation</a></em>-->
                                            <article>
                                                <p>{{DetalhesCurso}}</p>
                                            </article>
                                            <article>
                                                <p><b>Data:</b>{{dataCurso}}</p>
                                            </article>
                                            <article>
                                                <p><b>Localização:<b> {{localCurso}}</p>
                                            </article>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-danger" data-dismiss="modal" ><span class="glyphicon glyphicon-remove" ></span>Fechar</button>
                                </div>
                            </div>
                        </div>
                    </div>	<!--fim modal-->
                </form>
            </fieldset>
        </div>
    </body>
    <script>
        $(document).ready(function(){
            $.getJSON("./rest/eventoSource/evento", function(result){
                $.each(result, function(i, field){                
                    $("#eventosDisponiveis").append("<div class='blogShort'>");
                    $("#eventosDisponiveis").append("<h1>"+field.titulo+"</h1>");
                    $("#eventosDisponiveis").append("<article><p>"+field.descricao+"</p></article>");
                    $("#eventosDisponiveis").append("<input type='radio' id='"+field.id+"' value='"+field.id+"'>");
                    $("#eventosDisponiveis").append("<button type='submit' class='btn btn-blog pull-right marginBottom10' data-toggle='modal' data-target='#modalDetalhes'>+ Detalhes</button>");
                    $("#eventosDisponiveis").append("<br>");
                    $("#eventosDisponiveis").append("<hr/>");
                    $("#eventosDisponiveis").append("</div>");
                });
            });
            $("#limpar").click(function(){
                $("#participante").trigger("reset");
            });
       
            $("#confirmar").click(function(){
                //alert($("#nome").val());
                var participante = {
                    nome: $("#nome").val(),
                    cpf : $("#cpf").val(),
                    rg : $("#rg").val(),
                    email: $("#email").val(),
                    telefone: $("#telefone").val(),
                    sexo: $("#sexo").val(),
                    deficiente: $("#deficiente").val()
                };
                $.post("./rest/participanteSource/participante", participante, function(data, status){
                    alert("Data: "+ data + "Status: "+status);
                });
            });
        });
    </script>
</html>