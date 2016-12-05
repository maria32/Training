'use strict';

angular.module('WeatherApp')
    .controller('ViewCitiesForUserController', function ($scope, $http, $uibModal, $sessionStorage, $routeParams, $location, NotificationService) {

        $scope.$storage = $sessionStorage;

        if($scope.$storage.id == undefined){
            $location.path("/login");
        }

        $scope.cities = [];
        $scope.citySee = undefined;

        $scope.logout = function() {
            $scope.$storage.id =  undefined;
            $scope.$storage.name =  undefined;
            $scope.$storage.username =  undefined;

            $location.path('/login');
        };

        $scope.goToMap = function() {
            $location.path('/map');
        };

        $scope.getWeather = function() {

            $http({
                method: 'POST',
                url: '/weather',
                headers: {'Content-Type': 'application/json'},
                data: $scope.cityName

            }).then(function successCallback(response) {
                $scope.citySee = response.data;
                console.log($scope.citySee);
                if($scope.citySee.id == undefined) {
                    NotificationService.error('City not found');
                }

            });
        };

        $scope.addCity = function() {
            console.log("/users/id/city/" + $scope.cityName);
            $http({
                method: 'POST',
                url: '/users/' + $scope.$storage.id + '/city/' + $scope.cityName,
                headers: {'Content-Type': 'application/json'}
            }).then(function successCallback(response) {
                if(response.data != "") {
                    $scope.cities.push(response.data);
                    NotificationService.success($scope.cityName.split("%20").join(" ") + ' added to Favorites');
                }else{
                    NotificationService.info($scope.cityName.split("%20").join(" ") + ' is already in Favorites or could not be added');
                }
            });
        };

        $scope.updateCity = function(cityName, index) {
            $http.get('/cities/' + cityName).then(function successCallback(response) {

                console.log("Am luat detaliile");
                console.log(response.data);
                $scope.cities.splice(index, 1 );
                $scope.cities.push(response.data);
            });

        };

        $scope.deleteCity = function(cityName, index) {
            $http.delete('/users/' + $scope.$storage.id + '/city/' + cityName);
            $scope.cities.splice(index, 1 );
        };



        $http({
            method: 'GET',
            url: 'users/' + $scope.$storage.id + '/cities'
        }).then(function successCallback(response) {
            $scope.cities = response.data;
        });

    });