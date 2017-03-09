/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('app', []);
   
   app.controller('appCtrl', function($scope) {
       
      $scope.newUser = {};
      
      $scope.users = [];
      
      
      $scope.addNewUser = function(){
         $scope.users.push($scope.newUser);
      };
      
      $scope.allUsers = function(newUser){
        if(!(newUser === undefined || newUser === '')){
            $scope.users.call(newUser);
        }  else{
            $scope.NoItemError = 'Please enter a user';
        }
         //$scope.users.push($scope.User);
      };
      
});

