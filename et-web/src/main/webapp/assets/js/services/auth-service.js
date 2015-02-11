/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("AuthService", ['$http',
        function ExtInvestigationRequestsService($http) {
            var url = "api/auth";

            // TODO wtf here
            this.login = function (login, pass) {
                return $http.post(url + "/login", login + ":" + pass);
            };


            this.logout = function (login, pass) {
                return $http.post(url + "/logout");
            };


            this.getCurrentUser = function () {
                return $http.get(url + "/getCurrentUser");
            };

        }
    ]);

