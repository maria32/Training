'use strict';

angular
    .module('WeatherApp', [
        'ngRoute',
        'ui.bootstrap'
    ])

    .run(function ($rootScope, $location) {

        $rootScope.logout = function () {
            $rootScope.loggedUser = undefined;
            $rootScope.isAdmin = false;
            $location.path("/login");
        };
    })

    .config(function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'template/home.html',
            controller: 'HomeController'
        }).
        when('/login', {
            templateUrl: 'template/login.html',
            controller: 'LoginController'
        }).
        when('/register', {
            templateUrl: 'template/register.html',
            controller: 'RegisterController'
        }).
        otherwise({
            redirectTo: '/'
        });
    });