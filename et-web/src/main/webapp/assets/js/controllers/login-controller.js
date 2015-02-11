/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("LoginController", function ($scope, $location, AuthService) {

        //service calls
        $scope.login = function () {
            AuthService.login($scope.login, $scope.password).success(function () {
                $location.path("expenses");
            });
        };






    });