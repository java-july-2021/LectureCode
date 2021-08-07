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
<c:forEach items="${team.rating}" var="rating">
	<c:if test="${rating.user == user}">
		<p>You Rated: ${rating.rating}</p>
	</c:if>
</c:forEach>


<hr>
<h3>Rate HTML</h3>
<form method="POST" action="/rate/${team.id}">
<select name="rating">
<option value=1>1</option>
<option value=2>2</option>
<option value=3>3</option>
<option value=4>4</option>
<option value=5>5</option>
<option value=6>6</option>
<option value=7>7</option>
<option value=8>8</option>
<option value=9>9</option>
<option value=10>10</option>
</select>
<button>Rate!</button>
</form>

<h3>Rate Spring MVC</h3>
<form:form method="POST" action="/rate" modelAttribute="rate">
<div class="form-control">
<form:label path="rating">Rating</form:label>
<form:errors path="rating"/>
<form:select path="rating">
<option value=1>1</option>
<option value=2>2</option>
<option value=3>3</option>
<option value=4>4</option>
<option value=5>5</option>
<option value=6>6</option>
<option value=7>7</option>
<option value=8>8</option>
<option value=9>9</option>
<option value=10>10</option>
</form:select>
<form:input type="hidden" value="${team.id}" path="team"/>
<form:input type="hidden" value="${user.id}" path="user"/>
<button>Rate!</button>
</div>


</form:form>

<hr>
<h3>Liked By</h3>
<c:forEach items="${team.likers}" var="user">
<p>${user.firstName} ${user.lastName}</p>
</c:forEach>
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