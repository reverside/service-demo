var app = angular.module('myApp', []);

app.controller('myCtrl', function($scope, $http) {
    
    $scope.firstName = "John";
    
    $scope.lastName = "Doe";
    
    $scope.products = [];
    
    $scope.findAllProducts = function(){
        $http.get("/api/products")
        .then(function(response) {
            console.log(response);
            $scope.products = response.data;
        });
    };
});