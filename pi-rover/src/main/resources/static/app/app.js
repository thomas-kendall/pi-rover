var app = angular.module('spa', ['ngRoute', 'joystick']);
app.config(function($routeProvider){
    $routeProvider
        .when('/control', {
            templateUrl: 'app/pages/control/control.html',
            controller: 'ControlCtrl'
        })
        .otherwise('/control');    
});