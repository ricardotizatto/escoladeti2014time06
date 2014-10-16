angular.module('controllers')
    .controller('VolumeController',
    [
        '$routeParams',
        '$http',
        'VolumeFactory',
        'OrdemProducaoFactory',
        'fileUpload',
        VolumeController]);

function VolumeController($routeParams, $http, Volume, OrdemProducao, fileUpload) {
    this.routeParams = $routeParams;
    this.Volume = Volume;
    this.OrdemProducao = OrdemProducao;
    this.http = $http;
    this.fileUpload = fileUpload;
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
            this.volume.dataImpressao = moment(this.volume.dataImpressao).format('YYYY-MM-DD');
        }

        if (this.volume.dataRevisao) {
            this.volume.dataRevisao = moment(this.volume.dataRevisao).format('YYYY-MM-DD');
        }

        if (this.volume.dataEnviado) {
            this.volume.dataEnviado = moment(this.volume.dataEnviado).format('YYYY-MM-DD');
        }
    },

    novoVolume: function () {
        var self = this;

        var idSolicitacaoItem = this.routeParams.idOrdemProducao;

        this.volume = new this.Volume({
            status: "ANDAMENTO",
            idSolicitacaoItem: idSolicitacaoItem
        });

        this.OrdemProducao.sugerir({id : idSolicitacaoItem}, function (sugestao) {
            self.volume.paginaInicio = sugestao.pagina;
        });

        console.log(this.volume);
    },

    enviarArquivo: function () {

    },

    salvarVolume: function () {
        var self = this;

        var mensagemSucesso = function () {
            self.ajustarVolume();
            toastr.success('Volume salvo com sucesso');
            var promise = self.fileUpload.uploadFileToUrl(self.arquivo, './rest/upload/'+self.volume.id);

            promise && promise.success(function () {
                    delete self.arquivo;
                    self.buscarVolume(self.volume.id);
                });
        };

        this.volume.responsavel = + this.volume.responsavel;

        if (this.volume.id) {
            this.volume.$update(mensagemSucesso);
            return;
        }

        this.volume.$save(mensagemSucesso);
    },

    downloadArquivo: function () {
        var id = this.volume.id;

        if (!id) return;

        console.log(this.http);

        this.http({
            url: './rest/upload/'+id,
            method: 'GET'
        });
    },


    rejeitar: function () {
        var self = this;
        $('#modalImpressao').modal('show');

        this.aoAlterarStatus = function () {
            self.volume.$rejeitar(function () {
                self.ajustarVolume();
                $('#modalImpressao').modal('hide');
                toastr.success('Volume rejeitado');
            });

        };
    },

    marcarComoImpresso: function () {
        var self = this;
        $('#modalImpressao').modal('show');

        this.aoAlterarStatus = function () {
            self.volume.$marcarComoImpresso(function () {
                self.ajustarVolume();
                $('#modalImpressao').modal('hide');

                toastr.success('Volume marcado como impresso');
            });
        }

    },

    marcarComoRevisado: function () {
        var self = this;
        $('#modalImpressao').modal('show');

        this.aoAlterarStatus = function () {
            self.volume.$marcarComoRevisado(function () {
                self.ajustarVolume();
                $('#modalImpressao').modal('hide');

                toastr.success('Volume marcado como impresso');
            });
        }

    },

    marcarComoEnviado: function () {
        var self = this;
        $('#modalImpressao').modal('show');

        this.aoAlterarStatus = function () {

            self.volume.$marcarComoEnviado(function () {
                self.ajustarVolume();
                $('#modalImpressao').modal('hide');

                toastr.success('Volume marcado como enviado');
            });

        }

    },

    reativar: function () {
        var self = this;

        this.volume.$reativar(function () {
            self.ajustarVolume();
            $('#modalImpressao').modal('hide');

            toastr.success('Volume reativado');
        });
    },


    alterarStatus: function () {
        var self = this;
        this.aoAlterarStatus && this.aoAlterarStatus();
    }
}