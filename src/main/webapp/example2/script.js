/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var app = angular.module('User', [])
   app.controller('UserController', function($scope) {
       $scope.userName = "Moses";
       $scope.lastName = "Mathebula";
       $scope.password = "1234";
});