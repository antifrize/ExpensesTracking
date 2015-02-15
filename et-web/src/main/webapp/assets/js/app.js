/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module('app', [
        'ngRoute'
    ]).config(['$routeProvider',
        function ($routeProvider) {
            $routeProvider.
                when('/list', {
                    templateUrl: 'assets/html/expenses-list.html',
                    controller: 'ExpensesListController',
                    requiresLogin: true
                }).
                when('/print/:dateFrom/:dateTo', {
                    templateUrl: 'assets/html/print-list.html',
                    controller: 'PrintController',
                    requiresLogin: true
                }).
                when('/main', {
                    templateUrl: 'assets/html/main-page.html',
                    controller: 'MainPageController'
                }).

                otherwise({
                    redirectTo: '/list'
                });
        }])
    .run(function ($rootScope, $location, AuthService) {
        AuthService.isAuthenticated().success(function (result) {

            $rootScope.authenticated = result.status == 'OK';

            var callback = function() {
                if ($location.url() != 'main' && !$rootScope.authenticated) {
                    $location.path('/main');
                }
            }

            $rootScope.$on('$routeChangeStart', function (event, next, current) {
                callback();
            });

            callback();

        });
    });

/*.factory('authFactory', ['$rootScope', '$http', function ($rootScope, $http) {

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
 });*/
//    };
//}])


//;