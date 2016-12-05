'use strict';

angular.module('WeatherApp')
    .controller('LoginController', function ($scope, $sessionStorage, $http, $routeParams, $location, NotificationService) {

        $scope.login = function() {

            $http({
                method: 'POST',
                url: '/users/login',
                headers: {'Content-Type': 'application/json'},
                data: {
                    username: $scope.username,
                    password: $scope.password
                }

            }).then(function successCallback(response) {

                if (response.data != "") {

                    $scope.$storage = $sessionStorage.$default({
                        id: response.data.id,
                        name: response.data.name,
                        username: response.data.username
                    });
                    $location.path('/')

                } else {
                    NotificationService.error("AUTHENTICATION ERROR!");
                }
            });
        };

    });