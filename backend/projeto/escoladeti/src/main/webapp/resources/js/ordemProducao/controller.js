angular.module('controllers')
    .controller('OrdemProducaoController',
    [
        '$routeParams',
        '$location',
        '$http',
        'OrdemProducaoFactory',
        'VolumeFactory',
        'MaterialFactory',
        OrdemProducaoController
    ]);

function OrdemProducaoController($routeParams, $location, $http, OrdemProducao, Volume, Material) {
    this.OrdemProducao = OrdemProducao;
    this.routeParams = $routeParams;
    this.location = $location;
    this.Volume = Volume;
    this.Material = Material;
    this.http = $http;
    this.iniciar();
    this.buscarUsuarios();
}

OrdemProducaoController.prototype = {
    iniciar: function () {
        var self = this,
            param = {id: self.routeParams.id};


        this.OrdemProducao.get(param, function (item) {
            self.item = item;
            if (self.item.outro) {
                self.item.traducaoMaterial += ' - '+item.outro;
            }
        });

    },

    editarVolume: function (id) {
        var url = '/ordem-producao/' + this.item.id + '/producao-material/'+ id;
        this.location.path(url);
    },

    deletarVolume: function(item) {
        var self = this;

        BootstrapDialog.confirm('Deseja deletar a ordem ?', function(result) {
            if (result) {
                self.Material.delete({
                    id: item.id
                }, function () {
                    toastr.success('Ordem deletada com sucesso');
                    self.item.solicitacaoVolumes.splice(self.item.solicitacaoVolumes.indexOf(item), 1);
                });
            }
        });
    },

    apresentarModalEnvio: function (solicitacaoVolume) {
        var self = this;

        this.marcarComoEnviado = function () {
            var alterarData = {
                data: self.dataEnvio
            };

            self.OrdemProducao.enviarVolume({idVolume: solicitacaoVolume.id}, alterarData, function () {
                $('#modalEnvio').modal('hide');
                self.iniciar();
            });
        };
        $('#modalEnvio').modal('show');
    },
    
    marcarComoEnviado: function () {

    },

    acoesPossiveis: [
        'marcarImpresso',
        'marcarRejeitado',
        'marcarRevisado',
        'marcarEnviado',
        'reativar'
    ],

    itensSelecionados: function () {
        return this.item.solicitacaoVolumes
            .filter(function (solicitacaoVolume) {
                return !!solicitacaoVolume.selecionado;
            });
    },

    marcarImppresso: function () {
        var self = this;

        this.enviarMateriais(function (itens) {
            self.OrdemProducao.marcarImpresso(itens)
                .$promise
                .then(function () {
                    toastr.success('Itens marcados como impresso');
                    self.iniciar();
                    $('#modalAcao').modal('hide');
                });
        })
    },

    marcarRevisado: function () {
        var self = this;

        this.enviarMateriais(function (itens) {
            self.OrdemProducao.marcarRevisado(itens)
                .$promise
                .then(function () {
                    toastr.success('Itens marcados como revisado');
                    self.iniciar();
                    $('#modalAcao').modal('hide');
                });
        })
    },

    marcarRejeitado: function () {
        var self = this;

        this.enviarMateriais(function (itens) {
            self.OrdemProducao.marcarRejeitado(itens)
                .$promise
                .then(function () {
                    toastr.success('Itens marcados como rejeitado');
                    self.iniciar();
                    $('#modalAcao').modal('hide');
                });
        })
    },

    marcarEnviado: function () {
        var self = this;

        this.enviarMateriais(function (itens) {
            self.OrdemProducao.marcarEnviado(itens)
                .$promise
                .then(function () {
                    toastr.success('Itens marcados como enviado');
                    self.iniciar();
                    $('#modalAcao').modal('hide');
                });
        })
    },

    reativar: function () {
        var self = this;

        this.enviarMateriais(function (itens) {
            self.OrdemProducao.reativar(itens)
                .$promise
                .then(function () {
                    toastr.success('Itens reativados');
                    self.iniciar();
                    $('#modalAcao').modal('hide');
                });
        });
    },



    modalConfirmada: function () {

    },

    enviarMateriais: function (cb) {
        var dataAcao = this.dataAcao;
        var usuario = this.usuarioAcao;

        var itens = this.itensSelecionados()
            .map(function (item) {
                return {
                    id: item.id,
                    data: dataAcao,
                    usuario: usuario
                }
            });

        cb(itens);
    },

    buscarUsuarios: function () {
        var self = this;

        this.http({
            method: 'GET',
            url: './rest/usuarioSource/usuario'
        }).success(function (usuarios) {
            self.usuarios = usuarios;
        });
    },

    acionarImpressao: function () {
        $('#modalAcao').modal('show');
        this.modalConfirmada = this.marcarImppresso;
    },

    acionarReativacao: function () {
        var self = this;

        BootstrapDialog.confirm('Deseja reativar os itens ?', function(result) {
            if (result) {
                self.reativar();
            }
        });

    },

    acionarRevisao: function () {
        $('#modalAcao').modal('show');
        this.modalConfirmada = this.marcarRevisado;
    },

    acionarRejeicao: function () {
        $('#modalAcao').modal('show');
        this.modalConfirmada = this.marcarRejeitado;
    },

    acionarEnvio: function () {
        $('#modalAcao').modal('show');
        this.modalConfirmada = this.marcarEnviado;
    }

};
