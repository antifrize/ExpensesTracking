/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("AuthorisationController", function($scope, $location, AuthService){
        $scope.submit = function(){
            AuthService.login($scope.login, $scope.password).success(function(){
                $location.path("expenses");
            });
        }


    });