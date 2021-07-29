<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the best webpage ever!</title>
</head>
<body>
<h1>Cameron's Joke Site</h1>
<hr>


<form method="POST" action="/tellAJoke">
<p>
<label for="name">Name</label>
<input type="text" name="name">
</p>
<p>
<label for="joke">Joke</label>
<textarea name="joke" placeholder="tell us a funny joke"></textarea>
</p>
<button>Submit</button>
</form>
</body>
</html>