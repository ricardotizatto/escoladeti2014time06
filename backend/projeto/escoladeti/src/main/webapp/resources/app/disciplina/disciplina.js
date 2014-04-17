var moduleDisciplina = angular.module('escoladeti.disciplina', ['ngRoute']);

moduleDisciplina.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
                when('/cadastros/disciplina/listar', {
            templateUrl: './pages/disciplina/listarDisciplina.html',
            controller: 'DisciplinaController'
        }).
                when('/cadastros/disciplina/editar/:objeto', {
            templateUrl: './pages/disciplina/editarDisciplina.html',
            controller: 'DisciplinaController'
        });
        $locationProvider.html5Mode(false);
    }]);

moduleDisciplina.controller('DisciplinaController', ['$scope', '$http', '$routeParams', function($scope, $http, $routeParams) {

        $scope.message = 'Controller das Disciplinas!';
        $scope.page = {pageNumber : 1};
        $scope.disciplinaAtual = undefined;

        $scope.init = function() {
            $scope.loadDisciplinas(1);
        };

        $scope.incluir = function() {            
            window.location.href = "#cadastros/disciplina/editar/new";
        };

        $scope.initEditarDisciplina = function() {
            if ($routeParams.objeto === 'new') {
                $scope.disciplinaAtual = {"nome" : "", id : ""};
            } else {                
                $scope.disciplinaDadoId($routeParams.objeto);
            }
        };
        
        $scope.remover = function(index) {
            var disciplina = $scope.page.list[index];
            if (confirm('Deseja excluir a disciplina ' + disciplina.nome + '?')) {
                $scope.removerServidor(disciplina);
            }
        };
        
        $scope.removerServidor = function(disciplina) {
            console.log(JSON.stringify(disciplina));
            $http({
                method: "DELETE",
                url: "./rest/disciplina/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(disciplina))
            }).success(function(data, status) {
                $scope.loadDisciplinas($scope.page.pageNumber);
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir disciplinas!");
            });
        };

        $scope.loadDisciplinas = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/disciplina/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                console.log(JSON.stringify(data));
                $scope.page = data;
                console.log(JSON.stringify(status));                
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao buscar disciplinas!");
            });
        };
        
        $scope.salvar = function() {
            $http({
                method: "POST",
                url: "./rest/disciplina/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify($scope.disciplinaAtual)
            }).success(function(data, status) {
                window.location.href = "#cadastros/disciplina/listar";
                console.log(JSON.stringify(status));
            }).error(function(data, status) {
                console.log(JSON.stringify(data));
                console.log(JSON.stringify(status));
                alert("Erro ao excluir disciplinas!");
            });
        };
        
        $scope.disciplinaDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/disciplina/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.disciplinaAtual = data;
        	}).error(function(data, status) {
        		$("<div></div>")
        		.css({overflow : "auto"})
        		.html(data)
        		.dialog({
        			autoOpen: true,
        			title: 'Erro ao carregar questão ' + id,
        			width: 800,
        			height: 450,
        			modal: true
        		});
        	});
        };
        
    }
]);
