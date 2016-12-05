'use strict';

angular.module('WeatherApp')
    .controller('ToolbarController', function ($scope, $sessionStorage, $http, $routeParams, $location, NotificationService) {

        $scope.$storage = $sessionStorage;

        if($scope.$storage.id == undefined){
            $location.path("/login");
        }

    });