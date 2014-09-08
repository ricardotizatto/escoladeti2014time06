var diretivas = angular.module('directives');

diretivas.directive('tsRequired', function () {
    return {

        link: function (scope, element, attrs) {
            console.log('diretiva', scope.solicitacaoForm);
            console.log('addclass', element.addClass);
        }
    }
});