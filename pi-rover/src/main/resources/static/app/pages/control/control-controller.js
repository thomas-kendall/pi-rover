var ctrl = function($scope, $location, $timeout) {
	
	var nextLeftVector = null; 
	var nextRightVector = null; 
	
	$scope.onLeftJoystickMove = function(vector) {
		nextLeftVector = { 
			joystick: 'left', 
			angle: vector.angle, 
			magnitude: vector.magnitude 
		};
	};

	$scope.onRightJoystickMove = function(vector) {
		nextRightVector = { 
			joystick: 'right', 
			angle: vector.angle, 
			magnitude: vector.magnitude 
		};
	};
	
	var sendLoop = function() {
		if(nextLeftVector == null && nextRightVector == null) {
			// Try again in 10ms
			$timeout(sendLoop, 10);
		} else {
			// Send the data immediately
			var currentLeftVector = nextLeftVector;
			nextLeftVector = null;
			var currentRightVector = nextRightVector;
			nextRightVector = null;
			$timeout(sendData, 0, true, currentLeftVector, currentRightVector);
		}
	};
	
	var sendData = function(leftVector, rightVector) {
		if(leftVector != null){
			socket.send(JSON.stringify(leftVector));
		}
		if(rightVector != null){
			socket.send(JSON.stringify(rightVector));
		}
		
		// Once the data has been sent, go back to the loop
		$timeout(sendLoop, 0);
	};
			
	var socketMessageReceived = function(e) {
		var message = JSON.parse(e.data);
		if(message.action === 'some-action'){
		}
		
		$scope.$apply();
	};
	
	var getWebsocketUrl = function(path) {
		var loc = window.location;
		var serverHost = loc.host;
		var httpProtocol = loc.protocol;
		var wsProtocol = httpProtocol === 'https:' ? 'wss:' : 'ws:';
		var socketUrl = wsProtocol + '//' + serverHost + path;		
		return socketUrl;
	};
			
	var socket = new WebSocket(getWebsocketUrl('/control'));
	socket.onmessage = socketMessageReceived;
	
	// Start looping after a small delay
	$timeout(sendLoop, 10);
};

var app = angular.module('spa');
app.controller('ControlCtrl', ctrl);
