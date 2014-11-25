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
        template : "<td>{{telefone.numero.substring(0,4) +'-'+ telefone.numero.substring(4,telefone.numero.length)}}</td>"
    };
});

diretivas.directive('mascararPessoacpfcnpj', function () {
    return {
        restrict: 'A',
        replace: true,
        template : "<td>{{ pessoa.tipo === 'F' ? \n\
            pessoa.cpfCnpj.substring(0,3) +'.'+ pessoa.cpfCnpj.substring(3,6) +'.'+ pessoa.cpfCnpj.substring(6,9) +'-'+ pessoa.cpfCnpj.substring(9,pessoa.cpfCnpj.length) : \n\
            pessoa.cpfCnpj.substring(0,2) +'.'+ pessoa.cpfCnpj.substring(2,5) +'.'+ pessoa.cpfCnpj.substring(5,8) +'/'+ pessoa.cpfCnpj.substring(8,12) +'-'+ pessoa.cpfCnpj.substring(12,pessoa.cpfCnpj.length) \n\
            }}</td>"
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

diretivas.directive('money', function () {
  'use strict';

  var NUMBER_REGEXP = /^\s*(\-|\+)?(\d+|(\d*(\.\d*)))\s*$/;

  function link(scope, el, attrs, ngModelCtrl) {
    var min = parseFloat(attrs.min || 0);
    var precision = parseFloat(attrs.precision || 2);
    var lastValidValue;

    function round(num) {
      var d = Math.pow(10, precision);
      return Math.round(num * d) / d;
    }

    function formatPrecision(value) {
      return parseFloat(value).toFixed(precision);
    }

    function formatViewValue(value) {
      return ngModelCtrl.$isEmpty(value) ? '' : '' + value;
    }


    ngModelCtrl.$parsers.push(function (value) {
      if (angular.isUndefined(value)) {
        value = '';
      }

      // Handle leading decimal point, like ".5"
      if (value.indexOf('.') === 0) {
        value = '0' + value;
      }

      // Allow "-" inputs only when min < 0
      if (value.indexOf('-') === 0) {
        if (min >= 0) {
          value = null;
          ngModelCtrl.$setViewValue('');
          ngModelCtrl.$render();
        } else if (value === '-') {
          value = '';
        }
      }

      var empty = ngModelCtrl.$isEmpty(value);
      if (empty || NUMBER_REGEXP.test(value)) {
        lastValidValue = (value === '')
          ? null
          : (empty ? value : parseFloat(value));
      } else {
        // Render the last valid input in the field
        ngModelCtrl.$setViewValue(formatViewValue(lastValidValue));
        ngModelCtrl.$render();
      }

      ngModelCtrl.$setValidity('number', true);
      return lastValidValue;
    });
    ngModelCtrl.$formatters.push(formatViewValue);

    var minValidator = function(value) {
      if (!ngModelCtrl.$isEmpty(value) && value < min) {
        ngModelCtrl.$setValidity('min', false);
        return undefined;
      } else {
        ngModelCtrl.$setValidity('min', true);
        return value;
      }
    };
    ngModelCtrl.$parsers.push(minValidator);
    ngModelCtrl.$formatters.push(minValidator);

    if (attrs.max) {
      var max = parseFloat(attrs.max);
      var maxValidator = function(value) {
        if (!ngModelCtrl.$isEmpty(value) && value > max) {
          ngModelCtrl.$setValidity('max', false);
          return undefined;
        } else {
          ngModelCtrl.$setValidity('max', true);
          return value;
        }
      };

      ngModelCtrl.$parsers.push(maxValidator);
      ngModelCtrl.$formatters.push(maxValidator);
    }

    // Round off
    if (precision > -1) {
      ngModelCtrl.$parsers.push(function (value) {
        return value ? round(value) : value;
      });
      ngModelCtrl.$formatters.push(function (value) {
        return value ? formatPrecision(value) : value;
      });
    }

    el.bind('blur', function () {
      var value = ngModelCtrl.$modelValue;
      if (value) {
        ngModelCtrl.$viewValue = formatPrecision(value);
        ngModelCtrl.$render();
      }
    });
  }

  return {
    restrict: 'A',
    require: 'ngModel',
    link: link
  };
});