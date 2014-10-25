var controllers = angular.module('controllers');

function ChamadaController($scope, $routeParams, chamadaService) {
    console.log('carregando controller');

}

controllers.controller('ChamadaController', ['$scope', '$routeParams', 'chamadaService', ChamadaController ]);