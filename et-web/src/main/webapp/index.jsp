<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>

    <link href="assets/css/lib/bootstrap/bootstrap.css" rel="stylesheet">
    <link href="assets/css/styles.css" rel="stylesheet">

    <script src="assets/js/lib/jquery/jquery-1.11.2.js"></script>
    <script src="assets/js/lib/jquery-ui/jquery-ui.js"></script>
    <script src="assets/js/lib/angular/angular.min.js"></script>
    <script src="assets/js/lib/angular/angular-route.min.js"></script>
    <script src="assets/js/lib/angular-ui/ui-bootstrap-tpls-0.12.0.js"></script>
    <script src="assets/js/lib/bootstrap/bootstrap.js"></script>
    <script src="assets/js/lib/underscore/underscore.js"></script>
    <script src="assets/js/lib/moment/moment.js"></script>

    <!-- angular user js -->
    <script src="assets/js/app.js"></script>

    <script src="assets/js/controllers/expenses-list-controller.js"></script>
    <script src="assets/js/controllers/reg-controller.js"></script>
    <script src="assets/js/controllers/auth-controller.js"></script>
    <script src="assets/js/controllers/print-controller.js"></script>
    <script src="assets/js/controllers/auth-test-controller.js"></script>
    <script src="assets/js/controllers/main-page-controller.js"></script>
    <script src="assets/js/controllers/login-controller.js"></script>
    <script src="assets/js/controllers/registration-controller.js"></script>

    <script src="assets/js/services/expenses-service.js"></script>
    <script src="assets/js/services/auth-service.js"></script>
    <script src="assets/js/services/user-service.js"></script>

    <script src="assets/js/directive/expense-unit.js"></script>

</head>
<body ng-app="app">
<div class="container-fluid">
<div ng-view>

</div>
</div>

</body>
</html>