<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<header>
<nav>
    <a href="/">Home</a>
    <a href="/add">Add</a>
    <a href="/login">Login</a>
    <a href="/signup">Sign Up</a>
  </nav>
</header>
 <form action="login" method="post">
		<label for="username">Username: </label> 
		<input name="username" id="username" type="email" placeholder="email@example.com" /> 
		<label for="password">Password: </label> 
		<input name="password" id="password" type="password" placeholder="m@2#ac%" />
		<input type="submit" />
	</form>
</body>
</html>