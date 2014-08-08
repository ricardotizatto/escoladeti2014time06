function UsuarioController($scope, $http, $routeParams) {
    console.log('Usuario Controller');
    $scope.nome;
    $scope.login;
    $scope.senha;
    $scope.email;
    $scope.ativo;

    $scope.perfisDeAcesso = [
        {nome: "Gerente"},
        {nome: "Vendedor"},
        {nome: "Caixa"},
        {nome: "Estagiario"}
    ];


    $scope.novo = function() {
        $scope.evento = getNovoUsuario();
        window.location = '#/cadastrousuario';
    };

    $scope.editar = function(usuario) {
        console.log('Editar usuario');
        window.location = '#/cadastrousuario/' + usuario.id;
    };

    $scope.getTodos = function() {
        $http.get("./rest/usuarioSource/usuario")
                .success(function(usuarios, status) {
            $scope.usuarios = usuarios;
        })
                .error(function(data, status) {
            console.log('erro ao buscar usuarios');
        });
    };

    $scope.salvar = function() {
        console.log(angular.toJson($scope.usuario, true));
        $scope.usuario.ativo = true;
        $http.post("./rest/usuarioSource/usuario", $scope.usuario)
                .success(function(usuario, status) {
            toastr.success("Usuario cadastrado com sucesso!");
            setTimeout(function() {
                window.location = "#/listausuario";
            }, 5000);
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
        if ($routeParams.usuarioId) {
            $http.get('./rest/usuarioSource/usuario/' + $routeParams.usuarioId)
                    .success(function(usuario) {
                $scope.usuario = usuario;
            });
        }
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
