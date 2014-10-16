<%--
  Created by IntelliJ IDEA.
  User: Jhonatan
  Date: 15/10/2014
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html data-ng-app="appExterno">
    <script src="/resources/libs/angular.min.js"></script>
    <script src="/resources/externo/js/app.js"></script>
<head>
    <title>Aplicação Externa</title>
</head>
<body data-ng-controller="AppCtrontroller as ctrl">
    <h1>{{ctrl.nome}}</h1>
    <input data-ng-model="nome">
teste
{{2+2}}
    {{ctrl.eventos}}
</body>
</html>
