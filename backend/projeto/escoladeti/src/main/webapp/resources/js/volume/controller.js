angular.module('controllers')
    .controller('VolumeController',
    [
        '$routeParams',
        '$http',
        'VolumeFactory',
        VolumeController]);

function VolumeController($routeParams, $http, Volume) {
    this.routeParams = $routeParams;
    this.Volume = Volume;
    this.http = $http;
    this.iniciar();
}

VolumeController.prototype = {
    iniciar: function () {
        this.buscarUsuarios();

        if (this.routeParams.id) {
            this.buscarVolume(this.routeParams.id);
            return;
        }

        this.novoVolume();
    },

    buscarUsuarios: function () {
        var self = this;
        console.log('ususs');
        this.http({
            method: 'GET',
            url: './rest/usuarioSource/usuario'
        }).success(function (usuarios) {
            console.log('usus', usuarios);
            self.usuarios = usuarios;
        });
    },

    buscarVolume: function (id) {
        var params = {
            id: id
        },
            self = this;

        this.Volume.get(params, function (volume) {
            self.volume = volume;
            self.ajustarVolume();
        });
    },

    ajustarVolume: function () {

        if (this.volume.responsavel) {
            this.volume.responsavel = this.volume.responsavel.id;
        }

        if (this.volume.dataImpressao) {
            this.volume.dataImpressao = new Date(this.volume);
        }
    },

    novoVolume: function () {
        var self = this;

        this.volume = new this.Volume({
            status: "ANDAMENTO",
            idSolicitacaoItem: this.routeParams.idOrdemProducao
        });

        console.log(this.volume);
    },

    salvarVolume: function () {
        var self = this;

        var mensagemSucesso = function () {
            self.ajustarVolume();
            toastr.success('Volume salvo com sucesso');
        };

        this.volume.responsavel = + this.volume.responsavel;

        if (this.volume.id) {
            this.volume.$update(mensagemSucesso);
            return;
        }

        this.volume.$save(mensagemSucesso);
    },

    marcarComoImpresso: function () {
        var self = this;

        this.volume.$marcarComoImpresso(function () {
            self.ajustarVolume();
            toastr.success('Volume marcado como impresso');
        });
    }
}