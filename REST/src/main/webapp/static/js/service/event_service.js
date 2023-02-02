
angular.module("myApp").service("EventService", function($http, $q) {
	const url = "http://localhost:8080/events";
	var events = [];

	this.getAllEvents = function() {
		const defered = $q.defer();

		$http.get(url)
			.then((res) => defered.resolve(res.data))
			.catch((err) => console.log(err))
		return defered.promise;
	};

	this.addEvent = function(event) {
		const defered = $q.defer();

		$http.post(url, event)
			.then((res) => defered.resolve(res.data))
			.catch((err) => {
				console.log(err);
				defered.reject(err);
			})
		return defered.promise;
	};

	this.getEvent = function(id) {
		const defered = $q.defer();

		$http.get(url + "/" + id)
			.then((res) => defered.resolve(res.data))
			.catch((err) => console.log(err))
		return defered.promise;
	};
	this.updateEvent = function(event) {
		//        var currentEvent = this.getEvent(event.name);
		//        currentEvent.type = event.type;
		//        currentEvent.location = event.location;
		//        currentEvent.date = event.date;
		//        currentEvent.time = event.time;
		//        currentEvent.reason = event.reason;
		const defered = $q.defer();

		$http.put(url + "/" + event.id, event)
			.then((res) => defered.resolve(res.data))
			.catch((err) => console.log(err))
		return defered.promise;

	};

	this.deleteEvent = function(id) {
		const defered = $q.defer();

		$http.delete(url + "/" + id)
			.then((res) => defered.resolve(res.data))
			.catch((err) => console.log(err))
		return defered.promise;
	};
});
