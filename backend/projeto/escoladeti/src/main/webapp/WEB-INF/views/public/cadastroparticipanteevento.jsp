<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript" src="./resources/libs/jquery.js"></script>
        <script type="text/javascript" src="./resources/libs/bootstrap.min.js"></script>    
        <script type="text/javascript" src="./resources/libs/angular.min.js"></script>    
        <script type="text/javascript" src="./resources/js/CadastroParticipanteEventoController.js" ></script>
        <link rel="stylesheet" href="./resources/css/bootstrap.min.css" >
        <link rel="shortcut icon" type="image/png" href="./resources/imagens/icone-amacap.png" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Participante Evento</title>
    </head>
    <body>
        ?<script>
            function limpa() {

                document.getElementById('cpf').value = "";
                document.getElementById('rg').value = "";
                document.getElementById('nome').value = "";
                document.getElementById('email').value = "";
                document.getElementById('telefone').value = "";
                document.getElementById('data').value = "";

            }

        </script>

        <div class="container" ng-controller="CadastroParticipanteEventoController" ng-init="carregarEventos();novo()">
            <label>&nbsp;</label>
            <fieldset>
                <form action="" method="POST" name="participante" ng-submit="salvar()">
                    <div class="col-sm-7" style="height:400px; overflow:auto;">
                        <legend>Cursos Dispon�veis</legend>
                        <div class="blogShort" ng-repeat="evento in eventos">
                            <h1>{{evento.titulo}}</h1>
                            <!--<em>This snippet use <a href="http://bootsnipp.com/snippets/featured/sexy-sidebar-navigation" target="_blank">Sexy Sidebar Navigation</a></em>-->
                            <article><p>
                                    {{evento.descricao.substring(0,180)}}
                                </p></article>
                            <input type="radio" id="chk{{evento.id}}" ng-model="participante.idevento" value="{{evento.id}}">
                            <button type="submit" class="btn btn-blog pull-right marginBottom10" ng-click="carregarEventoDetalhes(evento.id,evento.titulo,evento.descricao,evento.local,evento.data)" data-toggle="modal" data-target="#modalDetalhes">
                                + Detalhes
                            </button><br>
                            <hr/>
                        </div>

                    </div>
                    <div class="col-sm-1"></div>
                    <div class="form-group col-sm-4">
                        <legend>Dados Pessoais</legend>
                        <br>
                        <label>CPF</label>
                        <input class="form-control" type="text" ng-change="ValidarCPF(participante.cpf)"  onKeyPress="MascaraCPF(participante.cpf);" maxlength="14" placeholder="N�mero do CPF" ng-model="participante.cpf" required>
                        <label>RG</label>
                        <input class="form-control"  type="text" placeholder="R.G." ng-model="participante.rg" required>
                        <label>Nome</label>
                        <input class="form-control" type="text"  placeholder="Nome" ng-model="participante.nome" required>
                        <label>Email</label>
                        <input class="form-control" type="text"  placeholder="Endere�o de email" ng-model="participante.email" required>
                        <label>Telefone</label>
                        <input class="form-control" type="text" ng-model="participante.telefone" onKeyPress="MascaraTelefone(participante.telefone);" maxlength="15" placeholder="Telefone" required>
                        <input name="sexo" value="M" type="radio" ng-model="participante.sexo" > <label>Masculino</label>
                        <input name="sexo" value="F" type="radio" ng-model="participante.sexo" >  <label>Feminino</label>
                        <br>    
                        <label>Deficiente</label>
                        <input name="deficiente" value="S" type="radio" ng-model="participante.deficiente" > <label>Sim</label>
                        <input name="deficiente" value="N" type="radio" ng-model="participante.deficiente" >  <label>N�o</label>
                    </div>
                    <div align="right">
                        <button type="button"  class="btn btn-danger"  ng-click="novo()">Limpar</button>
                        <button class="btn btn-success">Confirmar</button>
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
                                            <article><p>
                                                    {{DetalhesCurso}}
                                                </p></article>

                                            <article><p>
                                                    <b>Data:<b> {{dataCurso}}
                                                            </p></article>
                                                            <article><p>
                                                                    <b>Localiza��o:<b> {{localCurso}}
                                                                            </p></article>
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
                                                                            </html>
