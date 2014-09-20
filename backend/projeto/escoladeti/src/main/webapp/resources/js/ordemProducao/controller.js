angular.module('controllers')
    .controller('OrdemProducaoController',
    [
        '$routeParams',
        '$location',
        'OrdemProducaoFactory',
        'VolumeFactory',
        OrdemProducaoController
    ]);

function OrdemProducaoController($routeParams, $location, OrdemProducao, Volume) {
    this.OrdemProducao = OrdemProducao;
    this.routeParams = $routeParams;
    this.location = $location;
    this.Volume = Volume;
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
    },

    deletarVolume: function(item) {
        var self = this;

        BootstrapDialog.confirm('Deseja deletar o volume ?', function(result) {
            if (result) {
                self.Volume.delete(item, function () {
                    toastr.success('Volume deletado com sucesso');
                    self.item.volumes.splice(self.item.volumes.indexOf(item), 1);
                });
            }
        });
    }
};
