'use strict';

angular
    .module('WeatherTabs', [
        'ngRoute',
        'ui.bootstrap',
        'ngStorage'
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
        when('/hometab', {
            templateUrl: 'template/view_cities_for_user.html',
            controller: 'ViewCitiesForUserController'
        }).
        otherwise({
            redirectTo: '/'
        });
    });