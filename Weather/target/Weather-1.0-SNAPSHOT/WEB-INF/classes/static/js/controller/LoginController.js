'use strict';

angular.module('WeatherApp')
    .controller('LoginController', function ($scope, $rootScope, $http, $routeParams, $location, NotificationService) {

        $scope.ok = function() {

            $http({
                method: 'POST',
                url: '/users/login',
                headers: {'Content-Type': 'application/json'},
                data: {
                    username: $scope.username,
                    password: $scope.password
                }

            }).then(function successCallback(response) {
                $rootScope.loggedUser = response.data;
                $location.path('/');
            });
        };

    });