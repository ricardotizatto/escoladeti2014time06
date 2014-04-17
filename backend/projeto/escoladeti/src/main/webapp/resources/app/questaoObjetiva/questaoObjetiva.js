var moduleQuestaoObjetiva = angular.module('escoladeti.questaoObjetiva', ['ngRoute']);

moduleQuestaoObjetiva.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.
	        when('/cadastros/questaoObjetiva/listar', {
	            templateUrl: './pages/questaoObjetiva/listarQuestaoObjetiva.html',
	            controller: 'QuestaoObjetivaController'
	        }).
	        when('/cadastros/questaoObjetiva/editar/:objeto', {
	            templateUrl: './pages/questaoObjetiva/editarQuestaoObjetiva.html',
	            controller: 'QuestaoObjetivaController'
	        });
        $locationProvider.html5Mode(false);
    }]);

moduleQuestaoObjetiva.controller('QuestaoObjetivaController', ['$scope', '$http', '$routeParams', '$location', function($scope, $http, $routeParams, $location) {

        $scope.page = {pageNumber : 1};
        $scope.questaoAtual = undefined;
        $scope.alternativaAtual = undefined;
        $scope.disciplinas = [];

        $scope.init = function() {
            $scope.loadQuestoes(1);
        };

        $scope.incluir = function() {
            window.location.href = "#cadastros/questaoObjetiva/editar/new";
        };

        $scope.initEditarQuestaoObjetiva = function() {
        	console.log($routeParams.objeto);
        	if ($routeParams.objeto === 'new') {
        		$scope.questaoAtual = {
            		id : "",
            		enunciado : "",
            		tipo : "OBJETIVA",
            		nivelDificuldade : 0,
            		disciplinas : [],
            		alternativas : []
                };
        	} else {
        		$scope.questaoDadoId($routeParams.objeto);
        	}
        	
        	$scope.novaAlternativa();
        	
        	console.log(JSON.stringify($scope.questaoAtual));
        	
            $scope.loadAllDisciplinas();
        };
        
        $scope.novaAlternativa = function() {
        	$scope.alternativaAtual = {
        		id : undefined,
            	texto : '',
            	correta : false,
            	ordem : -1
            };
        };
        
        $scope.loadAllDisciplinas = function() {
            $http({
                method: "GET",
                url: "./rest/disciplina/todas",
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.disciplinas = data;
            }).error(function(data, status) {
                alert("Erro ao buscar disciplinas!");
            });
        };
        
        $scope.remover = function(index) {
            var questaoObjetiva = $scope.page.list[index];
            if (confirm('Deseja excluir a questão ' + questaoObjetiva.enunciado + '?')) {
                $scope.removerServidor(questaoObjetiva);
            }
        };
        
        $scope.removerServidor = function(questaoObjetiva) {
            $http({
                method: "DELETE",
                url: "./rest/questaoObjetiva/remover",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: JSON.stringify(angular.copy(questaoObjetiva))
            }).success(function(data, status) {
                $scope.loadQuestoes($scope.page.pageNumber);
            }).error(function(data, status) {
                alert("Erro ao excluir questão!");
            });
        };

        $scope.loadQuestoes = function(numeroPagina) {        	
            $http({
                method: "GET",
                url: "./rest/questaoObjetiva/listar/pag/" + numeroPagina,
                headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
            }).success(function(data, status) {
                $scope.page = data;
            }).error(function(data, status) {
                $("<div></div>")
                	.css({overflow : "auto"})
                	.html(data)
                	.dialog({
	                    autoOpen: true,
	                    title: 'Erro ao carregar as questões',
	                    width: 800,
	                    height: 450,
	                    modal: true
                });
            });
        };

        $scope.questaoDadoId = function(id) {        	
        	$http({
        		method: "GET",
        		url: "./rest/questaoObjetiva/carregar/" + id,
        		headers: {'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'}
        	}).success(function(data, status) {
        		$scope.questaoAtual = data;
        		console.log(JSON.stringify(data));
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
        
        $scope.salvar = function() {
        	for (var i = 0; i < $scope.questaoAtual.alternativas.length; i++)
        		$scope.questaoAtual.alternativas[i].ordem = i + 1;
        	
        	var objetoAEnviar = JSON.stringify(angular.copy($scope.questaoAtual));
        	
        	console.log(objetoAEnviar);
        	
            $http({
                method: "POST",
                url: "./rest/questaoObjetiva/salvar",
                headers: {'Content-Type': 'application/json; charset=UTF-8'},
                data: objetoAEnviar
            }).success(function(data, status) {
                window.location.href = "#cadastros/questaoObjetiva/listar";
            }).error(function(data, status) {
                $("<div></div>")
                .css({overflow : "auto"})
                .html(data)
                .dialog({
                        autoOpen: true,
                        title: 'Erro ao salvar questão ',
                        width: 800,
                        height: 450,
                        modal: true
                });
//                alert("Erro ao salvar questão!");
            });
        };
        
        $scope.adicionarAlternativa = function() {
        	$scope.questaoAtual.alternativas.push($scope.alternativaAtual);
        	$scope.novaAlternativa();
        };
        
        $scope.removerAlternativa = function(index) {
        	$scope.questaoAtual.alternativas.splice(index, 1);
        };
    }
]);
