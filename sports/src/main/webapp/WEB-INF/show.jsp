<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Go Team</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<div class="container">
<h1>Details For ${team.teamName}</h1>
<hr>
<p>Name: ${team.teamName}</p>
<p>City: ${team.city}</p>
<p>Sport: ${team.sport}</p>
<p>Budget: ${team.budget}</p>
<p>isActive?: ${team.isActive}</p>
<hr>
<h2>Players</h2>
<hr>
<ul>
<c:forEach items="${team.players}" var="player">
<p>First Name: ${player.firstName}</p>
<p>Last Name: ${player.lastName}</p>
<p>Salary: ${player.salary }</p>
</c:forEach>
</ul>
<a href="/edit/${team.id}" style="btn btn-primary">Edit Team</a>
<a href="/delete/${team.id}">Delete Team</a>
</div>
</body>
</html>