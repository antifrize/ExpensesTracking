/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("PrintController", function ($scope, $routeParams, ExpensesService) {

        // initialization
        $scope.dateFrom = $routeParams.dateFrom;
        $scope.dateTo = $routeParams.dateTo;
        $scope.filter = {
            dateFrom: $scope.dateFrom,
            dateTo: $scope.dateTo
        };

        ExpensesService.getList($scope.filter).success(function (result) {
            $scope.expenses = result;
            $scope.total = _.reduce(_.pluck(result, 'amount'), function(a,b){ return a+b;},0);
            $scope.days = moment($scope.dateTo).diff(moment($scope.dateFrom),'days');
            // TODO fix digits agter point
            $scope.average = $scope.total/ $scope.days;
        });



    });