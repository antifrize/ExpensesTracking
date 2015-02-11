/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("AuthTestController", function ($scope, $location, AuthService) {
        $scope.cred = {};

        $scope.login =function(){
            AuthService.login($scope.cred.login, $scope.cred.pass);
        }

    });