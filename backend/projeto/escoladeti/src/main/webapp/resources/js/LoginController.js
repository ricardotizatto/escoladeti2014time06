function LoginController($scope) {
  $scope.usuario = {};

  $scope.logar = function(){
  
    //validação somente para teste
    if ($scope.usuario.login === "login" && $scope.usuario.senha === "senha") {
      window.location = "index.html"; 
    }else{
    	alert("Usuario Invalido!!");
    }

    $scope.usuario = {};
  };
}