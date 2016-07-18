var ctrl = function($scope, $location, $interval) {
	
	var initializeControls = function() {
		console.log('Initializing controls...');
	};
	
	$scope.onLeftJoystickMove = function(e) {
		console.log('Left joystick moved.');
	};
	$scope.leftCoords = {x: 0, y: 0};

	$scope.onRightJoystickMove = function(e) {
		console.log('Right joystick moved.');
	};
	$scope.rightCoords = {x: 0, y: 0};
		
	var leftPreviousCoords = {x: 0, y: 0};
	var rightPreviousCoords = {x: 0, y: 0};
	
	var pollCoordinates = function(){
		if($scope.leftCoords.x !== leftPreviousCoords.x || $scope.leftCoords.y !== leftPreviousCoords.y) {
			console.log('Left coords changed from .' + JSON.stringify(leftPreviousCoords) + ' to ' + JSON.stringify($scope.leftCoords));
			leftPreviousCoords.x = $scope.leftCoords.x;
			leftPreviousCoords.y = $scope.leftCoords.y;
		}
		if($scope.rightCoords.x !== rightPreviousCoords.x || $scope.rightCoords.y !== rightPreviousCoords.y) {
			console.log('Right coords changed from .' + JSON.stringify(rightPreviousCoords) + ' to ' + JSON.stringify($scope.rightCoords));
			rightPreviousCoords.x = $scope.rightCoords.x;
			rightPreviousCoords.y = $scope.rightCoords.y;
		}
	};
	
	var timer = $interval(pollCoordinates, 10);
	
	var socketMessageReceived = function(e) {
		var message = JSON.parse(e.data);
		if(message.action === 'some-action'){
		}
		
		$scope.$apply();
	};
		
	//var socketUrl = networkService.getWebsocketUrl('/game-display');
	//var socket = new WebSocket(socketUrl);
	//socket.onmessage = socketMessageReceived;	
	
	initializeControls();
};

var app = angular.module('spa');
app.controller('ControlCtrl', ctrl);
