/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app").
    controller("ExpensesListController", function ($scope, $rootScope, $location, ExpensesService, AuthService) {

        // initialization
        $scope.filter = {};
        $scope.expenses = [];
        $scope.currentExpense = {};


        // expense CRUD
        $scope.addEditExpense = function (id) {
            if (id === undefined) {
                $scope.currentExpense = {};
            } else {
                $scope.currentExpense = _.find($scope.expenses, {id: id});
            }
            $("#edit-expense-modal").modal();
        };

        $scope.deleteExpense = function (id) {
            ExpensesService.deleteExpense(id).success(function () {
                $scope.updateExpenses();
            });
        };

        $scope.updateExpenses = function () {
            ExpensesService.getList($scope.filter).success(function (result) {
                $scope.expenses = result;
            });
        };

        $scope.saveExpense = function () {
            var service = $scope.currentExpense.id === undefined
                ? ExpensesService.createExpense : ExpensesService.updateExpense;
            service($scope.currentExpense).success(function () {
                $scope.updateExpenses();
                $scope.currentExpense = {};
                this.newExpenseForm.$setPristine();
            });
        };

        // filtering

        $scope.doFilter = function(){
            $scope.updateExpenses();
        };

        $scope.clearFilter = function(){
            $scope.filter={};
            $scope.filterForm.$setPristine();
            $scope.updateExpenses();
        };

        //printing

        $scope.openPrintDialog = function(){
            $scope.printParams = {};
            $("#print-expense-modal").modal();
        };

        $scope.openPageToPrint = function(){
            $location.path("print/"+ $scope.printParams.dateFrom + "/" + $scope.printParams.dateTo )
        };

        $scope.logout =function(){
            $rootScope.authentificated = false;
            AuthService.logout();
            $location.path("main");
        };

        // refresh expenses for the 1st time
        $scope.updateExpenses();
        // also, get usr
        AuthService.getCurrentUser().success(function(result){
            $scope.user = result;
        });


    });