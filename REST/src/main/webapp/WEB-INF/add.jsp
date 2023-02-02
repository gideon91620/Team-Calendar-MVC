<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="ISO-8859-1">
<title>Add Event Page</title>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script src="/static/js/app.module.js"></script>
<script src="/static/js/controller/event_controller.js"></script>
<script src="/static/js/service/event_service.js"></script>
</head>
<body ng-controller="EventController">
<header>
  <nav>
    <a href="/">Home</a>
    <a href="/add">Add</a>
    <a href="/login">Login</a>
    <a href="/signup">Sign Up</a>
  </nav>
  
  </header> 
  
<h1>Add Page</h1>

<form>
        <div>
            <label for="eventName">Event Name:</label>
            <input type="text" id="eventName" ng-model="event.name" value="event.name" required />
        </div>
        <div>
            <label for="eventType">Event Type:</label>
            <select id="eventType" ng-model="event.type" value="event.type" required>
                <option value="practice">Practice</option>
                <option value="game">Game</option>
                <option value="meeting">Meeting</option>
                <option value="other">Other</option>
            </select>
        </div>
        <div>
            <label for="eventLocation">Event Location:</label>
            <input type="text" id="eventLocation" ng-model="event.location" value="event.location" required />
        </div>
        <div>
            <label for="eventDate">Event Date:</label>
            <input type="text" id="eventDate" ng-model="event.date" value="event.date" required />
        </div>
        <div>
            <label for="eventTime">Event Time:</label>
            <input type="text" id="eventTime" ng-model="event.time" value="event.time" required />
        </div>
        <div>
            <label for="eventReason">Event Reason:</label>
            <input type="text" id="eventReason" ng-model="event.reason" value="event.reason" required />
        </div>
        <div>
            <button ng-click="event.id ? updateEvent(event) : addEvent()">{{event.id ? "Update" : "Add"}}</button>
        </div>
    </form>
    <hr />
    <div class="container">
       <form ng-submit="getEvent()">
         <input type="text" name="id" ng-model="event.id" required/>
         <input type="submit"/>
       </form>
    </div>
    <div class="container">
      <h2>Event</h2>
      <p>{{e.name}}</p>
    </div>
    <hr>
    <div ng-repeat="event in events | filter: {date:searchEvent}">
        <p>Name: {{event.name}}</p>
        <p>Type: {{event.type}}</p>
        <p>Location: {{event.location}}</p>
        <p>Date: {{event.date}}</p>
        <p>Time: {{event.time}}</p>
        <p>Reason: {{event.reason}}</p>
        <button ng-click="prepareForUpdate(event)">Edit</button>
        <button ng-click="deleteEvent(event.id)">Delete</button>
    </div>
    <div>
        <input type="text" ng-model="searchEvent" placeholder="Filter events by date">
    </div>
    
</body>
</html>