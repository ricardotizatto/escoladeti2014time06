var diretivas = angular.module('directives');

diretivas.directive('tsRequired', function () {
    return {
        link: function (scope, element, attrs) {
            console.log('diretiva', scope.solicitacaoForm);
            console.log('addclass', element.addClass);
        }
    }
});

diretivas.directive('mascararTelefone', function () {
    return {
        restrict: 'A',
        replace: true,
        link : function(scope, element, attrs){
            var numero = scope.$eval(attrs.mascararTelefone);
            telefone = numero.substring(0,4) + '-'+ numero.substring(4,numero.length);
            console.log(telefone);
        },
        template : '<td>' + telefone + '</td>'
    };
});

diretivas.directive('myFocus', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            scope.$watch(attr.myFocus, function (n, o) {
                if (n !== 0 && n) {
                    element[0].focus();
                }
            });
        }
    };
});
app.directive('myBlur', function () {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            element.bind('blur', function () {
                scope.$apply(attr.myBlur);
                scope.$eval(attr.myFocus + '=false');
            });
        }
    };
});