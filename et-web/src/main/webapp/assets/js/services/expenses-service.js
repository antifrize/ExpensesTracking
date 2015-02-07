/**
 * Created by VMakarenko on 2/7/15.
 */

angular.module("app")
    .service("ExpensesService", ['$http',
function ExtInvestigationRequestsService($http ) {
    var url ="api/expenses";

    this.getList = function(filter){
        return $http.post(url + "/all", filter);
    };

    this.getById = function(id){
        return $http.get(url + "/" + id);
    };

    this.createExpense = function(expense){
        return $http.post(url, expense);
    };

    this.updateExpense = function(expense){
        return $http.put(url, expense);
    };

    this.deleteExpense = function(id){
        return $http.delete(url + "/" + id);
    };

    }
]);

