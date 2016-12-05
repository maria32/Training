'use strict';

angular.module('WeatherApp')
    .controller('HomeController', function ($scope, $http, $routeParams, $location, NotificationService) {

        $scope.$storage = $sessionStorage;

        if($scope.$storage.id == undefined){
            $location.path("/login");
        }
    });