/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("UserService", ['$http',
        function UserService($http) {
            var url = "api/user";

            this.checkLogin = function (login) {
                return $http.get(url + "/checkLogin?login="+ login );
            };

        }
    ]);

