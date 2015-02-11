/**
 * Created by VMakarenko on 2/7/15.
 */
angular.module('app')
    .controller('CustomDatepickerController', ['$scope', function($scope) {

    }])
    .directive('customDatepicker', [function() {
        return {
            scope: {
                model:"=?model"
            },
            controller: 'CustomDatepickerController',
            templateUrl: 'assets/html/directives/custom-datepicker.html'
        };
    }]);