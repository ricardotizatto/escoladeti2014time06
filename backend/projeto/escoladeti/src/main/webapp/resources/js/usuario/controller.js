function UsuarioController($scope, $http, $routeParams) {
    console.log('Usuario Controller');

    var tamanho = 0;
    var temMaiuscula = 0;
    var temMinuscula = 0;
    var temNumero = 0;
    var temSimbolo = 0;
    var resultado = 0;

    $scope.novo = function() {
        $scope.getPerfisDeAcesso();
        if ($routeParams.usuarioId) {
            $scope.carregarUsuario();
        } else {
            $scope.usuario = getNovoUsuario();
           // console.log(angular.toJson($scope.usuario, true));
            window.location = '#/cadastrousuario';
        }
    };
    $scope.editar = function(usuario) {
        console.log('Editar usuario');
        window.location = '#/cadastrousuario/' + usuario.id;
    };
    $scope.voltar = function () {
        window.location = '#/listausuario';
    };
    
    $scope.getTodos = function(numeroPagina) {
        console.log(numeroPagina);
        $http.get('./rest/usuarioSource/listar/pag/' + numeroPagina)
            .success(function(usuarios) {
                $scope.pagina = usuarios;
                console.log('usuarios ' + usuarios);
            }).error(function(data) {
                console.log('erro ao buscar usuarios ' + data);
            });
    };
    
    $scope.buscaUsuariosContendoNome = function() {
        console.log($scope.busca);
        if(!$scope.busca.empty){
        $http.get('./rest/usuarioSource/usuarios?q=' + $scope.busca.toUpperCase())
            .then(function(usuarios) {
                console.log(usuarios.data.list);
                $scope.pagina = usuarios.data;
            });
        }else{
            $scope.getTodos($scope.pageNumber);
        }    
    };
    
    $scope.salvar = function() {
        console.log(angular.toJson($scope.usuario, true));
        if ($scope.usuario.nome === undefined)
            return toastr.warning('Preencha o campo nome');
        if ($scope.usuario.login === undefined)
            return toastr.warning('Preencha o campo login');
        if ($scope.usuario.senha === undefined)
            return toastr.warning('Preencha o campo senha');
        if ($scope.usuario.email === undefined) 
            return toastr.warning('Preencha o campo email');
        if ($scope.usuario.inicioVigencia === undefined) 
            return toastr.warning('Preencha o campo data inicio Vigencia');
        if ($scope.usuario.fimVigencia === undefined) 
            return toastr.warning('Preencha o campo data fim da Vigencia');
        if($scope.usuario.inicioVigencia > $scope.usuario.fimVigencia)
            return toastr.warning('Data fim da Vigencia deve ser menor que a de inicio!');

        if (!($scope.usuario.senha === $scope.confirmaSenha)) {
            toastr.warning('As senhas devem ser iguais!');
        } else {
            console.log("Salvar usuario perfilDeAcessoUsuarioId: " + $scope.usuario.perfilDeAcessoUsuarioId);
            $http.post("./rest/usuarioSource/usuario", $scope.usuario)
                .success(function(usuario) {
                console.log("usuario salvo = " + usuario);
                toastr.success("Usuário "+ $scope.usuario.nome +" cadastrado com sucesso!"); 
                window.location = "#/listausuario";
            }).error(function(data) {
                console.log("erro ao salvar usuario", data);
                toastr.warning("Erro ao salvar usuário!");
            });
        }
    };

    $scope.deletar = function(usuario) {
        $http({
            method: 'DELETE',
            data: usuario,
            url: './rest/usuarioSource/usuario',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        }).success(function(data) {
            console.log("usuario deletado" + data);
            toastr.success("Usuario "+ usuario.nome +" deletado com sucesso!");
            $scope.getTodos(1);
        }).error(function(data) {
            console.log("erro ao deletar usuario " + data);
            toastr.warning("Erro ao deletar usuário!");
        });
    };
    $scope.carregarUsuario = function() {
        if ($routeParams.usuarioId) {
            $http.get('./rest/usuarioSource/usuario/' + $routeParams.usuarioId)
                .success(function(usuario) {
                $scope.usuario = usuario;
                $scope.usuario.ativo = String(usuario.ativo);
            });
        }
    };

    $scope.getPerfisDeAcesso = function() {
        $http.get("./rest/perfilAcessoSource/perfilAcesso")
            .success(function(perfils, status) {
            $scope.perfisAcesso = perfils;
            //console.log(angular.toJson($scope.perfisAcesso, true));
        }).error(function(data, status) {
            console.log('Erro ao carregar perfis de acesso! ' + data);
        });
    };

    $scope.pontuarSenha = function() {
        var senha = $scope.usuario.senha;
        if (senha.length > 0) {
            if (senha.length >= 8 && senha.length <= 10) {
                tamanho = 6 * senha.length;
            } else {
                if (senha.length > 10) {
                    tamanho = 6 * 10;
                } else {
                    tamanho = 0;
                }
            }

            if (senha.charCodeAt(senha.length - 1) > 64 && senha.charCodeAt(senha.length - 1) < 91) {
                temMaiuscula = 20;
            }

            if (senha.charCodeAt(senha.length - 1) > 96 && senha.charCodeAt(senha.length - 1) < 123) {
                temMinuscula = 10;
            }

            if (senha.charCodeAt(senha.length - 1) > 47 && senha.charCodeAt(senha.length - 1) < 58) {
                temNumero = 15;
            }

            if (senha.charCodeAt(senha.length - 1) > 31 && senha.charCodeAt(senha.length - 1) < 48) {
                temSimbolo = 30;
            }

            if (senha.charCodeAt(senha.length - 1) > 57 && senha.charCodeAt(senha.length - 1) < 65) {
                temSimbolo = 30;
            }

            if ((senha.charCodeAt(senha.length - 1) > 91 && senha.charCodeAt(senha.length - 1) < 97) || senha.charCodeAt(senha.length - 1) > 122) {
                temSimbolo = 30;
            }

            resultado = tamanho + temMaiuscula + temMinuscula + temNumero + temSimbolo;
        } else {
            resultado = 0;
        }

        if (resultado < 40) {
            $scope.myStyle = {'background-color': '#ff0000', 'color': '#fff'};
            $scope.statusSenha = 'Senha Fraca';
        } else {
            if (resultado >= 40 && resultado < 80) {
                $scope.myStyle = {'background-color': '#ffff00', 'color': '#000'};
                $scope.statusSenha = 'Senha Média';
            } else {
                if (resultado >= 80) {
                    $scope.myStyle = {'background-color': '#66ff00', 'color': '#000'};
                    $scope.statusSenha = 'Senha Forte';
                }
            }
        }
    };
    function getNovoUsuario() {
        console.log('novo usuario');
        return {ativo: 'true'};
    }
    ;
}

function Ctrl($scope) {
    $scope.value = new Date(2010, 11, 28, 14, 57);
}
