var controllers = angular.module('controllers');

function PessoaController($scope, $location, $log, $routeParams, $http, $timeout, Pessoa, BuscaCep, PaisService, EstadoService, CidadeService, CaracteristicaService) {

  $scope.mask = '999.999.999-99';

  $scope.select2 = 'one';
  
  $scope.pageNumber = 1;
  

  $scope.init = function () {
    $scope.listarTodasPessoas(1);
    $scope.focusCpf = false;
    $scope.enderecoPrincipal = false;
    $scope.verificaCaracteristica('F');
  };

  function isEditing() {
    return angular.isDefined($scope.pessoa.id);
  }

  $scope.modificarPais = function (paisId) {
    if (!paisId || paisId === null)
      return;
    EstadoService.buscaEstadosPorPais(paisId)
            .success(function (data, status) {
              $scope.unidadesFederativas = data;
            });
  };

  $scope.validaCpf = function (cpf) {
    if (cpf) {
      $scope.focusCpf = !ValidarCPF(cpf);
      if ($scope.focusCpf && cpf) {
        toastr.warning("CPF inválido!");
        $scope.pessoa.cpf = undefined;
      } else {
        $scope.maskCpf = '999.999.999-99';
      }
    } else {
      $scope.maskCpf = undefined;
    }

  };
  
  $scope.verificaCaracteristica = function(tipo){
	  $scope.pessoaCaracteristica = {};
	  //$scope.caracteristicas = undefined;
    CaracteristicaService.query({tipo : tipo}
      ,function(data){
        $scope.caracteristicas = data;
      }
    );
  };
  
  function temAssociado(caracteristicas){
    if(caracteristicas){
      var associado;
      caracteristicas.forEach(function(item,index){
        if(item == 2)
          associado =  true;
      });
      return associado;
    }
    return false;
  }
  function temAluno(caracteristicas){
    if(caracteristicas){
      var aluno;
      caracteristicas.forEach(function(item,index){
        if(item == 1)
          aluno = true;
      });
      return aluno;
    }
    return false;
  }  

  $scope.validaCnpj = function (cnpj) {
    if (!cnpj)
      return;
    $scope.focusCnpj = !ValidarCNPJ(cnpj);
    if ($scope.focusCnpj) {
      toastr.warning("CNPJ inválido!");
      $scope.pessoa.cnpj = undefined;
    }
  };

  $scope.validaEmail = function () {
    if (ValidaEmail($scope.pessoa.email) === false)
      toastr.warning("E-mail inválido!");
  };


  $scope.novo = function () {
    window.location = '#/pessoa';
  };

  $scope.carregarPessoa = function () {
    $scope.aluno = false;

    $timeout(function () {

      if (!$routeParams.pessoaId) {
        $scope.novaPessoa("F");
        $scope.verificaCaracteristica('F');
        return;
      }

      Pessoa.get({id: $routeParams.pessoaId, tipo: $routeParams.pessoaTipo}, function (pessoa) {
        $scope.pessoa = pessoa;
        $scope.estaEditando = isEditing();
        $scope.maskCpf = '999.999.999-99';
        $scope.verificaCaracteristica(pessoa.tipo);
        //$scope.pessoaCaracteristica = {};
        $scope.pessoaCaracteristica.caracteristicas = [];
        $scope.pessoa.pessoaCaracteristica.forEach(function(item,index){
          $scope.pessoaCaracteristica.caracteristicas.push(item.caracteristica.id);
          if(item.caracteristica.id == 2)
            $scope.pessoa.vigenciaAssociado = item.vigenciaAssociado.vigencia;
        });
        $scope.validaCaracteristicas($scope.pessoaCaracteristica.caracteristicas);
      });
    }, 100);
  };
  
  $scope.validaCaracteristicas = function(caracteristicas){
    $scope.aluno = temAluno(caracteristicas);
    $scope.associado = temAssociado(caracteristicas);
  };

  $scope.editar = function (p) {
    window.location = '#/pessoa/' + p.id + '/' + p.tipo;
  };

  $scope.buscaPessoaContendoNome = function () {
    $scope.busca = $scope.busca.toUpperCase();
    $timeout(function () {
      Pessoa.buscarPessoa({pagina: 1, busca: $scope.busca}, function (pagina) {
        $scope.pagina = pagina;
      });
    }, 100);
  };

  $scope.getTodos = function (numeroPagina) {
    $scope.listarTodasPessoas(numeroPagina);
  };


  $scope.filtroPessoaJuridica = function (numeroPagina) {
    Pessoa.paginarJuridica({pagina: numeroPagina}, function (pagina) {
      $scope.pagina = pagina;
    });
  };

  $scope.listarTodasPessoas = function (numeroPagina) {
    Pessoa.get({pagina: numeroPagina}, {acao: 'listarTodas'},
    function (pagina) {
      $scope.pagina = pagina;
    },
            function (erro) {
              console.log(erro);
            });
  };

  $scope.filtroAluno = function (numeroPagina) {
    Pessoa.paginarAluno({pagina: numeroPagina}, function (pagina) {
      $scope.pagina = pagina;
    });
  };

  $scope.novaPessoa = function (tipo) {
    if ($scope.tipo === "J") {
      $scope.pessoa = new Pessoa({
        tipo: "J",
        email: "",
        telefones: [],
        enderecos: []
      });
    } else {
      $scope.pessoa = new Pessoa({
        tipo: "F",
        email: "",
        sexo: "MASCULINO",
        telefones: [],
        enderecos: []
      });
    }
  };

  $scope.salvar = function () {
    $scope.pessoa.caracteristicas = $scope.pessoaCaracteristica.caracteristicas;
    if ($scope.pessoa.id) {
        $scope.pessoa.$update(function () {
        toastr.success($scope.pessoa.nome + ' atualizado com sucesso');
        $scope.novaPessoa($scope.pessoa.tipo);
        window.location = '#/listapessoa';
      });
      return;
    }

    $scope.pessoa.$save(function () {
      toastr.success($scope.pessoa.nome + ' salvo com sucesso');
      // $scope.novaPessoa($scope.pessoa.tipo);
      window.location = '#/listapessoa';
    });

  };

  $scope.deletar = function (pessoa) {

    BootstrapDialog.confirm('Deseja realmente deletar a Pessoa: <b>' + pessoa.nome + '</b>?', function (result) {
      if (result) {
        Pessoa.delete({id: pessoa.id, tipo: pessoa.tipo}, function () {
          toastr.success(pessoa.nome + ' deletada com sucesso');
          $scope.listarTodasPessoas(1);
        });
      }
    });
  };

  $scope.select2Options = {
  };

  $scope.voltar = function () {
    window.location = '#/listapessoa';
  };

// Novo telefone

  $scope.novoTelefone = function () {
    $scope.telefone = getNovoTelefone();
  };

  $scope.salvarTelefone = function () {
    if ($scope.indiceTelefone >= 0) {
      $scope.pessoa.telefones.splice($scope.indiceTelefone, 1);
    }

    $scope.pessoa.telefones.push($scope.telefone);
    toastr.success("Telefone adicionado " + $scope.telefone.numero + " !");
    // $scope.telefone = getNovoTelefone();
    $scope.indiceTelefone = {};
  };

  $scope.editarTelefone = function (indice) {
    $scope.indiceTelefone = indice;
    $scope.telefone = angular.copy($scope.pessoa.telefones[indice]);
  };

  $scope.delTelefone = function (index) {
    toastr.warning("Telefone removido  " + $scope.pessoa.telefones[index].numero + "!");
    $scope.pessoa.telefones.splice(index, 1);
    if ($scope.pessoa.telefones.length === 0) {
      $scope.telefone = {};
    }
  };


// Endereco

  $scope.modificarCidade = function (cidadeId) {
    if (!cidadeId)
      return;
    CidadeService.buscar(cidadeId)
            .success(function (c, status) {
              $scope.endereco.cidade = c;
            });
  };

  $scope.salvarEndereco = function () {
    if (contemEnderecoPrincipal($scope.endereco.principal)) {
      toastr.warning('Endereço principal já informado!');
      return;
    }

    $scope.endereco.logradouro = angular.uppercase($scope.endereco.logradouro);
    $scope.endereco.bairro = angular.uppercase($scope.endereco.bairro);

    if ($scope.endereco.complemento)
      $scope.endereco.complemento = angular.uppercase($scope.endereco.complemento);

    if (angular.isUndefined($scope.indiceEndereco))
      $scope.pessoa.enderecos.push($scope.endereco);
    else
      $scope.pessoa.enderecos[$scope.indiceEndereco] = $scope.endereco;
    toastr.success('Endereço adicionado !');
    $scope.endereco = getNovoEndereco();
    $scope.indiceEndereco = undefined;

  };

  $scope.editarEndereco = function (indice) {

    $scope.indiceEndereco = indice;

    $scope.endereco = angular.copy($scope.pessoa.enderecos[indice]);

    $scope.modificarPais($scope.endereco.cidade.unidadeFederativa.pais.id);

    $scope.modificarEstado($scope.endereco.cidade.unidadeFederativa.id);

    $scope.modificarCidade($scope.endereco.cidade.id);


  };

  $scope.delEndereco = function (index) {
    toastr.warning('Endereço removido !');
    $scope.pessoa.enderecos.splice(index, 1);
  };

  $scope.novoEndereco = function () {
    $scope.endereco = getNovoEndereco();
    $scope.pais = {};
    $scope.unidadeFederativa = {};
    $scope.cidade = {};
    $scope.cidades = [];
    $scope.unidadesFederativas = [];
    $scope.pais = {};
  };

  $scope.modificarEstado = function (estadoId) {

    if (!estadoId || estadoId === null)
      return;
    CidadeService.buscaCidadesPorEstado(estadoId)
            .success(function (data, status) {
              $scope.cidades = data;
            });
  };

  function contemEnderecoPrincipal(principal) {
    var contem = false;
    if (angular.isUndefined($scope.pessoa.enderecos)) {
      return contem;
    }
    angular.forEach($scope.pessoa.enderecos, function (value, key) {
      if (value.principal === 'S' && value.principal === principal) {
        contem = true;
        return contem;
      }

    });
    return contem;
  }
  ;

  function getNovoEndereco() {
    return {
      tipo: 'RUA',
      principal: contemEnderecoPrincipal() ? 'N' : 'S'
    };
  }

  $scope.buscaCep = function (c) {
    if (c) {
      $timeout(function () {
        BuscaCep.get({cep: c},
        function (cep) {
          if (!cep.cidade) {
            return;
          }
          $scope.endereco = cep;
          $scope.modificarPais(cep.cidade.unidadeFederativa.pais.id);
          $scope.modificarEstado(cep.cidade.unidadeFederativa.id);
          $scope.endereco.id = null;
          $scope.endereco.principal = 'S';

        }, function (mesage) {
          console.log(mesage);
        });
      }, 100);
    }
  };

  function getNovoTelefone() {
    return {
      tipo: 'CELULAR'
    };
  }

  (function () {
    PaisService.buscarTodos()
            .success(function (paises) {
              $scope.paises = paises;
            });
  })();


  jQuery(function ($) {
    $.mask.definitions['~'] = '[+-]';
    // $("#numeroDdd").mask("99");
    $("#telefone").mask("9999-9999?9");
    $("#ramal").mask("9?");
    $("#cep").mask("99.999-999");
    $("#cpf").mask("999.999.999-99");
    // $("#rg").mask("9.999.999-*");
    // $("#cnpj").mask("99.999.999/9999-99");
  });

  $scope.mascaraTelefone = function (numero) {
    return numero.substring(0, 4) + '-' + numero.substring(4, numero.length);
  };
}

controllers.controller('PessoaController',
        [
          '$scope',
          '$location',
          '$log',
          '$routeParams',
          '$http',
          '$timeout',
          'PessoaFactory',
          'BuscaCepFactory',
          'paisService',
          'estadoService',
          'cidadeService',
          'CaracteristicaFactory',
          PessoaController
        ]);