'use strict';
angular.module("myApp").controller("EventController", ["$scope", "EventService", function($scope, EventService) {
    $scope.events = [];
    $scope.event = {id: null, name: "", type: "", date: "", time: "", location: "", reason: ""};
    
    getAllEvents();
    
    function getAllEvents() {
		EventService.getAllEvents()
		  .then((data) => $scope.events = data)
		  .catch((err) => console.log(err));
	}

    $scope.addEvent = function() {
        EventService.addEvent($scope.event)
        .then(getAllEvents)
        .catch((err) => console.log(err));
        $scope.event = {};
        
    };

    $scope.getEvent = function() {
        EventService.getEvent($scope.event.id);
  
    };
    
    $scope.prepareForUpdate = function(event) {
		$scope.event = event;		
	}

    $scope.updateEvent = function() {
        EventService.updateEvent($scope.event)
        .then(getAllEvents)
        .catch((err) => console.log(err));
        $scope.event = {};
    };

    $scope.deleteEvent = function(id) {
        EventService.deleteEvent(id)
        .then(getAllEvents)
        .catch((err) => console.log(err));
    };
}]);