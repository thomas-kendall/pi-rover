var app = angular.module('spa', ['ngRoute', 'angularjs-html5-joystick']);
app.config(function($routeProvider){
    $routeProvider
        .when('/control', {
            templateUrl: 'app/pages/control/control.html',
            controller: 'ControlCtrl'
        })
        .otherwise('/control');    
});