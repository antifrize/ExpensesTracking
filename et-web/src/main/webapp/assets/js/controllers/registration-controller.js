/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("RegistrationController", function($scope, $location, UserService){

        // init
        $scope.newUser = {};


        $scope.checkLogin = function () {
            UserService.checkLogin($scope.newUser.username).success(function (result) {
                $scope.loginError = result.ok ? undefined : result.msg;
            });
        };

        $scope.register = function () {
            UserService.createUser($scope.newUser).success(function (result){

            });
        }



    });