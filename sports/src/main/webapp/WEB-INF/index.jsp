<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome To Sports Teams dot Com</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Sports dot Com</h1>
<p>Welcome ${user.firstName}</p>
<a href="/new">Add Team To Database</a> | <a href="/player/new">Add Player</a> | <a href="/logout">Logout</a>
<table class="table table-dark">
<thead>
<th>Action</th>
<th>Team Name</th>
<th>City</th>
<th>Sport</th>
<th>Budget</th>
<th>is Active?</th>
<th># of Likers</th>
</thead>
<tbody>

<c:forEach items="${allTeams}" var="team">
<tr>
<td>
<c:choose>
<c:when test="${team.likers.contains(user)}">
<a href="/unlike/${team.id}">unLike</a>
</c:when>
<c:otherwise>
<a href="/like/${team.id}">Like</a>
</c:otherwise>
</c:choose>
</td>



<td><a href="/${team.id}">${team.teamName}</a></td>
<td>${team.city}</td>
<td>${team.sport}</td>
<td><fmt:formatNumber type="number" value="${team.budget}" /></td>
<td>${team.isActive}</td>
<td><p>${team.likers.size()}</p></td>
</tr>
</c:forEach>

</tbody>
</table>


</div>
</body>
</html>