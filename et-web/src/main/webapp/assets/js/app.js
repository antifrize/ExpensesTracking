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
                otherwise({
                    redirectTo: '/list'
                });
        }]);