function cidadeController ($scope, $http, $routeParams){
    console.log('Carregando controller');
    
    $scope.editar = function(cidade){
        window.location = '#/cadastrocidade/' + cidade.id;
    };
    
    $scope.deletar = function(cidade){
        console.log('deletando cidade' +JSON.stringify(cidade));
        $http({
          method : 'DELETE',
          data : cidade,
          url : './rest/cidadeSource/cidade',
          headers : {'Content-Type': 'application/json; charset=UTF-8'}
        })
        .success(function(data, status){
            $scope.getTodos();
        	console.log("cidade deletado");
	}).error(function(data, status) {
		console.log("erro ao deletar cidade "+data);
        });
    };
    
    $scope.salvar = function(){
        console.log(angular.toJson($scope.cidade, true));
        $http.post("./rest/cidadeSource/cidade", $scope.cidade)
        .success(function(cidade, status){
            $scope.cidade = getNovaCidade();
            console.log("cidade salva = "+cidade);
        })
        .error(function(data, status){
            console.log("erro ao salvar cidade" +data);
        });
    };
    
    $scope.novo = function(){
        $scope.cidade = getNovaCidade();
        window.location = '#/cadastrocidade';
    };
    
    $scope.getTodos = function(){

       $http.get('./rest/cidadeSource/cidade')
        .success(function(cidades, status){
            $scope.cidades = cidades;       
        })
        .error(function(data, status){
            console.log('erro ao buscar cidades');
        });
    };
    
    $scope.carregarCidade = function() {
	  console.log("carregando cidade"); 	  		
	  if (!$routeParams.cidadeId) return;//se não tiver id não buscar
	  
	  $http.get('./rest/cidadeSource/cidade/'+$routeParams.paisId)
		 .success(function(cidade, status) {
			$scope.cidade = cidade;
		  console.log("carregando cidade"); 	
              });
    };
    
//    $scope.carregarEstado = function(){
//       console.log("carregando estado"); 	  		
//       $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
//               .success(function(estado, status){
////                   console.log(angular.toJson(estado, true));
//                    $scope.estados = estado;
//               })
//               .error(function(data, status){
//                   console.log('erro ao buscar estados')
//               });
//    };
    $scope.carregaEstados = function (){
        carregaEstados();
    };
 
    
    function carregaEstados(){
        $http.get('./rest/unidadeFederativaSource/unidadeFederativa')
                .success(function(unidadeFederativa){
                    console.log('Estados carregados');
                    $scope.unidadeFederativa = unidadeFederativa;
        })
                .error(function(data){
                    console.log('Nao foi possivel carregar os estados' + data);
        });
    };
//    
//     function carregaCidade (){
//        $http.get('./rest/cidadeSource/cidade')
//                .success(function(cidade){
//                    console.log('Cidade carregada');
//                    $scope.cidade = cidade;
//        })
//                .error(function(data){
//                    console.log('Nao foi possivel carregar a cidade' + data);
//        });
//    };
    
    function getNovaCidade() {
	  console.log('nova cidade');
	  return {};
    };
    
    
}