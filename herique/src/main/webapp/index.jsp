<%-- 
    Document   : index
    Created on : 10/05/2016, 22:12:50
    Author     : hdias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="ang">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="resources/lib/bootstrap/dist/css/bootstrap.css" />

        <script src="resources/lib/jquery/dist/jquery.js" ></script>
        <script src="resources/lib/angular/angular.js" ></script>
        <script src="resources/lib/angular-ui-router/release/angular-ui-router.js" ></script>

        <script>
            var app = angular.module('ang', ['ui.router']);
            app.run(function ($rootScope) {
                $rootScope.abc = "ABC";
            });
            app.controller("loginCtrl", function ($scope, $http) {
                $scope.title = "loginCtrl";
                $scope.postLogin = function (cred) {
                    $http({
                        method: "POST",
                        url: "login",
                        data: $.param(cred),
                        headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
                    }).then(function (data) {
                        console.log(data);
                    }, function (data) {

                        console.log(data);
                    });
//data: $.param(user),
//                headers: { 'Content-Type': 'application/x-www-form-urlencoded' }

                };
            });
            app.config(function ($stateProvider, $urlRouterProvider) {
                $urlRouterProvider.otherwise("/");
                $stateProvider
                        .state('login', {
                            url: "/",
                            templateUrl: "views/" + "login" + ".html",
                            controller: 'loginCtrl'
                        });
            });

        </script>
    </head>
    <body>
        <div class="container">
            <div ui-view></div>
        </div>
    </body>
</html>
