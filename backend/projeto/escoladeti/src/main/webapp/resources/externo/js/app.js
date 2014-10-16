angular.module('appExterno', [])
    .controller('AppCtrontroller', AppCtrontroller);


function AppCtrontroller($http) {
    this.http = $http;

    this.iniciar();
}

AppCtrontroller.prototype = {

    iniciar: function () {
        var self = this;

        this.http.get('./public/rest/eventos')
            .success(function (eventos) {
               self.eventos = eventos;
            });
    }
};

