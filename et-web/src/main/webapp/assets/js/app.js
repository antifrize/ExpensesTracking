/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module('app', [
    'ngRoute'
]).config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/list', {
                    templateUrl: 'assets/html/expenses-list.html',
                    controller: 'ExpensesListController'
                }).
                when('/auth', {
                    templateUrl: 'assets/html/auth-form.html',
                    controller: 'AuthorisationController'
                }).
                when('/reg', {
                    templateUrl: 'assets/html/reg-form.html',
                    controller: 'RegistrationController'
                }).
                when('/print/:dateFrom/:dateTo', {
                    templateUrl: 'assets/html/print-list.html',
                    controller: 'PrintController'
                }).
                otherwise({
                    redirectTo: '/list'
                });
        }]).factory('authFactory', ['$rootScope', '$http', function ($rootScope, $http) {

        var authFactory = {
            authData: undefined
        };

        authFactory.login = function (user) {
            return $http.post('http://localhost:8080/expenses/api/auth/', user);
        };

        return authFactory;
    }])
    .controller('LoginCtrl', ['$scope', 'authFactory', function LoginCtrl($scope, authFactory) {
        $scope.login = function (user) {
            authFactory.login(user).success(function (data) {
                authFactory.setAuthData(data);
                // Redirect etc.
            }).error(function () {
                    // Error handling
                });
        };
    }])


;