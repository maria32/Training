'use strict';

angular.module('WeatherApp')
    .controller('RegisterController', function ($scope, $sessionStorage, $http, $routeParams, $location, NotificationService) {

        $scope.register = function() {

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

                console.log(response.data.authMessage);
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