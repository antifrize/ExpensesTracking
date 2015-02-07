/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module('ExpensesTracking', [
    'ngRoute'
]).config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/list', {
                    templateUrl: '../html/expenses-list.html',
                    controller: 'ExpensesListController'
                }).
                when('/auth', {
                    templateUrl: '../html/auth-form.html',
                    controller: 'AuthorisationController'
                }).
                when('/reg', {
                    templateUrl: '../html/reg-form.html',
                    controller: 'RegistrationController'
                }).
                otherwise({
                    redirectTo: '/list'
                });
        }]);