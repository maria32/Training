'use strict';

angular
    .module('WeatherApp', [
        // 'WeatherTabs',

        //external dependencies
        'ngRoute',
        'ui.bootstrap',
        'ngStorage'
    ])

    .run(function ($rootScope, $location,$sessionStorage) {

        // $rootScope.logout = function () {
        //     $rootScope.loggedUser = undefined;
        //     $rootScope.isAdmin = false;
        //     $location.path("/login");
        // };

        var user = $sessionStorage;
        console.log(user);

        $sessionStorage.$default({
            id: undefined,
            name: undefined,
            username: undefined
        });


    })

    .config(function($routeProvider) {
        $routeProvider.
        when('/', {
            templateUrl: 'template/view_cities_for_user.html',
            controller: 'ViewCitiesForUserController'
        }).
        when('/login', {
            templateUrl: 'template/login.html',
            controller: 'LoginController'
        }).
        when('/register', {
            templateUrl: 'template/register.html',
            controller: 'RegisterController'
        }).
        when('/map', {
            templateUrl: 'template/romania-map.html',
            controller: 'RomaniaMapController'
        }).
        // when('/', {
        //     templateUrl: 'template/toolbar.html',
        //     controller: 'ToolbarController'
        // }).
        otherwise({
            redirectTo: '/'
        });
    });