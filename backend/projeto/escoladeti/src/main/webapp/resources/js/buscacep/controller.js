var controllers = angular.module('controllers');

function BuscaCepController($scope, $log, BuscaCep) {
    

}

controllers.controller('BuscaCepController',
        [
            '$scope',
            '$location',
            '$log',
            '$routeParams',
            '$http',
            'BuscaCepFactory',
            BuscaCepController
        ]);