'use strict';

angular.module('WeatherApp')
    .controller('HomeController', function ($scope, $rootScope, $http, $routeParams, $location, NotificationService) {

        if ($rootScope.loggedUser === undefined) {
            $location.path("/login");
        }

    });