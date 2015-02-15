/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("AuthService", ['$http',
        function ExtInvestigationRequestsService($http) {
            var url = "api/auth";

            this.login = function (username, password) {
                return $http.post(url + "/login",{username: username, password : password});
            };


            this.logout = function () {
                return $http.post(url + "/logout");
            };


            this.getCurrentUser = function () {
                return $http.get(url + "/getCurrentUser");
            };

            this.isAuthenticated = function () {
                return $http.get(url + '/isAuthenticated');
            };

        }
    ]);

