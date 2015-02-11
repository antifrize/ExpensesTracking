/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("LoginController", function ($scope, $rootScope, $location, AuthService) {

        //service calls
        $scope.login = function () {
            AuthService.login($scope.username, $scope.password).success(function () {
                $rootScope.authentificated = true;
                $location.path("expenses");
            });
        };






    });