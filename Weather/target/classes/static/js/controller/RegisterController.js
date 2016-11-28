'use strict';

angular.module('WeatherApp')
    .controller('RegisterController', function ($scope, $rootScope, $http, $routeParams, $location, NotificationService) {

        $scope.ok = function() {

            $http({
                method: 'POST',
                url: '/users',
                headers: {'Content-Type': 'application/json'},
                data: {
                    name: $scope.name,
                    username: $scope.username,
                    password: $scope.password
                }
            }).then(function successCallback(response) {
                $rootScope.loggedUser = response.data;
                $location.path('/');
            });
        };

    });