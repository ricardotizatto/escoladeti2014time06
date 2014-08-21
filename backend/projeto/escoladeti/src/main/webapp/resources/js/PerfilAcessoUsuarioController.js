function PerfilAcessoUsuarioController($scope, $http, $routeParams) {
    console.log('Perfil Acesso Usuario Controller');
    $scope.perfilAcesso;
    $scope.usuario;

    $scope.editar = function(usuario) {
        console.log('Editar perfil acesso usuario');
        window.location = '#/cadastroperfilacessousuario/' + usuario.id;
    };

    $scope.salvar = function() {
        $scope.perfilAcessoUsuario = [{
                inicioVigencia: $scope.inicioVigencia,
                fimVigencia: $scope.fimVigencia,
                perfilAcesso: $scope.perfilAcesso,
                usuario: $scope.usuario

            }];
        $http.post("./rest/perfilAcessoUsuarioSource/perfilAcessoUsuario", $scope.perfilAcessoUsuario)
                .success(function(perfilAcessoUsuario, status) {
            toastr.success("Usuario cadastrado com sucesso!");
            setTimeout(function() {
                window.location = "#/listausuario";
            }, 500);
            console.log("usuario salvo = " + usuario);
        })
                .error(function(data, status) {
            console.log("erro ao salvar usuario", data);
            toastr.warning("Erro ao salvar usuario!");
        });
    };
    $scope.deletar = function(usuario) {
        $http({
            method: 'DELETE',
            data: usuario,
            url: './rest/usuarioSource/usuario',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        })
                .success(function(data) {
            console.log("usuario deletado");
            toastr.success("Usuario apagado com sucesso!");
            $scope.getTodos();
        }).error(function(data) {
            console.log("erro ao deletar usuario ");
            toastr.warning("Erro ao apagar usuario!");
        });
    };

    $scope.carregarUsuario = function() {
        console.log('carregando usuario');
        if ($routeParams.usuarioId) {
            $http.get('./rest/usuarioSource/usuario/' + $routeParams.usuarioId)
                    .success(function(usuario) {
                $scope.usuario = usuario;
                $scope.getPerfisDeAcesso();
            });
        }
    };

    $scope.getPerfisDeAcesso = function() {
        $http.get("./rest/perfilAcessoSource/perfilAcesso")
                .success(function(perfils, status) {
            $scope.perfilAcesso = perfils;
            console.log(angular.toJson($scope.perfilAcesso, true));
        }).error(function(data, status) {
            console.log('Erro ao carregar perfils ! ' + data);
        });
    };

    function getNovoUsuario() {
        console.log('novo usuario');
        return {};
    }
    ;
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}
