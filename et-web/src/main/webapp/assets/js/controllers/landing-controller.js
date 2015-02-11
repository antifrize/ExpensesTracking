/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("LandingController", function($scope, $location, AuthService){

        //init
        $scope.user = {};




        // open Modals
        $scope.openLoginModal = function(){
            $("#login-modal").modal();
        };
        $scope.openRegistrationModal = function(){
            $("#registration-modal").modal();

        };



        //service calls
        $scope.login = function(){
            AuthService.login($scope.login, $scope.password).success(function(){
                $location.path("expenses");
            });
        };



        $scope.register = function(){
            AuthService.register($scope.user).success(function(){
                $location.path("expenses");
            });
        };



    });