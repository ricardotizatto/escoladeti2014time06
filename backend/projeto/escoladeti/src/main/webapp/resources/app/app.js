var myApp = angular.module('escoladeti', ['ngRoute', 'escoladeti.disciplina', 'escoladeti.questaoObjetiva']);

myApp.config(['$routeProvider', '$locationProvider',
    function($routeProvider, $locationProvider) {
        $routeProvider.otherwise({redirectTo: '/'});
        $locationProvider.html5Mode(false);
    }
]);

myApp.controller('MainController', ['$scope', function($scope) {

        $scope.message = 'This is Add new order screen';

    }
]);
