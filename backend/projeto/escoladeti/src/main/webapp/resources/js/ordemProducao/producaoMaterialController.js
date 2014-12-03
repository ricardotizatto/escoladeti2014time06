angular.module('controllers').controller('ProducaoMaterialController', [
    '$routeParams',
    '$http',
    'OrdemProducaoFactory',
    'VolumeFactory',
    'MaterialFactory',
   producaoMaterialController
]);

function producaoMaterialController($routeParams, $http, OrdemProducao, Volume, Material) {
    var vm = this;



    OrdemProducao.get({
        id: retornarIdSolicitacaoItem()
    }).$promise.then(
        function (solicitacaoItem) {
            if ($routeParams.id) {
                carregarItem($routeParams.id, solicitacaoItem);
            } else {
                novoItem(solicitacaoItem);
            }
        });

    function novoItem(solicitacaoItem) {
       vm.item = iniciarProducaoMaterial(solicitacaoItem);
    }

    buscarUsuarios();

    vm.salvar = function salvar() {
        ajustarItem(vm.item);

        var salvoComSucesso = function () {
            toastr.success('Material Produção salvo com sucesso')
        };

        if (vm.item.id) {
            Material.update(vm.item,salvoComSucesso );
        } else {
            Material.save(vm.item,salvoComSucesso );
        }

    };

    function carregarItem(id, solicitacaoItem) {

        Material.get({
            id: id
        }).$promise.then(
            function (item) {
                vm.item = item;
                item.transcricao = solicitacaoItem.traducaoMaterial;
                item.livro = solicitacaoItem.livro;
                item.volume = {
                    id: item.volume.id,
                    text: montarDescricaoVolume(item.volume)
                }
            });
    }

    function montarDescricaoVolume(volume) {
        return volume.id + ' - ' + volume.paginaInicio+'/'+ volume.paginaFim;
    }

    vm.select2Volume = {
        allowClear: true,
        placeholder: 'selecione o volume',

        ajax: {
            url: './rest/volumes',

            data: function (id) {
                var termoPesquisa;
                return {
                    id: id,
                    idLivro: vm.item.livro.id,
                    transcricao: vm.item.transcricao
                };

            },
            results: function (data) {

                var volumes = data.list.map(function (volume) {
                    return {
                        text: montarDescricaoVolume(volume),
                        id: volume.id
                    };
                });

                return {
                    results: volumes
                };
            }
        },

        initSelection: function(element, callback) {
            var valor = element.val();
            console.log('valor busca cidade',valor);
            Volume.get({
                id: valor
            }).success(function (volume) {

                callback({
                    text: montarDescricaoVolume(volume),
                    id: cidade.id
                });

            });
        }
    };

    function ajustarItem(item) {
        item.volume = item.volume.id;
        item.responsavel = item.idResponsavel;
    }


    function buscarUsuarios () {
        console.log('ususs');
        $http({
            method: 'GET',
            url: './rest/usuarioSource/usuario'
        }).success(function (usuarios) {
            vm.usuarios = usuarios;
        });
    }

    function iniciarProducaoMaterial(solicitacaoItem) {
        var item = {
            livro: solicitacaoItem.livro,
            transcricao: solicitacaoItem.traducaoMaterial,
            idSolicitacaoItem: solicitacaoItem.id,
            status: 'ANDAMENTO'
        };

        return item;
    }

    function retornarIdSolicitacaoItem() {
        console.log($routeParams.idOrdem);
        return $routeParams.idOrdem;
    }


}