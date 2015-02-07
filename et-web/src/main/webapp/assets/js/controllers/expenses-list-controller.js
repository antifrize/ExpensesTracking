/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ExpensesListController", function($scope, ExpensesService){

        // initialization
        $scope.filter = {};
        $scope.expenses = [];
        $scope.currentExpense = {};



        // functions
        $scope.addEditExpense = function(id){
            if(id === undefined){
                $scope.currentExpense = {}
            }else{

            }

            $("#edit-expense-modal").modal();
        };

        $scope.deleteExpense =function(){
            var i = 0;
            return i;
        };

        $scope.updateExpenses = function(){
            ExpensesService.getList($scope.filter).success(function(result){
               $scope.expenses = result;
            });
        };


        // refresh expenses for the 1st time
        $scope.updateExpenses();

    });