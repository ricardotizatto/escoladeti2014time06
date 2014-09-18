angular.module('controllers')
    .controller('OrdemProducaoController',
    [
        '$routeParams',
        '$location',
        'OrdemProducaoFactory',
        OrdemProducaoController
    ]);

function OrdemProducaoController($routeParams, $location, OrdemProducao) {
    this.OrdemProducao = OrdemProducao;
    this.routeParams = $routeParams;
    this.location = $location;
    this.iniciar();
}

OrdemProducaoController.prototype = {
    iniciar: function () {
        var self = this,
            param = {id: self.routeParams.id};


        this.OrdemProducao.get(param, function (item) {
            self.item = item;
        });

    },

    editarVolume: function (idVolume) {
        var url = '/ordem-producao/' + this.item.id + '/volume/'+ idVolume;
        this.location.path(url);
    }
};
