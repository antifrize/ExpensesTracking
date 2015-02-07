/**
 * Created by VMakarenko on 2/7/15.
 */
angular.module('app')
    .controller('ExpenseUnitController', ['$scope', function($scope) {
        $scope.deleteExpense = function(id){
            $scope.deleteExpense_({
                id:id
            });
        };

        $scope.editExpense = function(id){
            $scope.editExpense_({
                id:id
            });
        };
    }])
    .directive('expenseUnit', [function() {
        return {
            scope: {
                deleteExpense_:"&deleteLnr",
                editExpense_:"&editLnr",
                model:"=?expenseModel"
            },
            controller: 'ExpenseUnitController',
            templateUrl: 'assets/html/directives/expense-unit.html'
        };
    }]);