<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A New Player</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Add Player</h1>
<form:form method="POST" action="/newPlayer" modelAttribute="player">
<form:select path="team">
<c:forEach items="${allTeams}" var="team">
<option value="${team.id}">${team.teamName}</option>
</c:forEach>
</form:select>


<div class="form-group">
<form:label path="firstName">First Name:</form:label>
<form:errors path="firstName"/>
<form:input path="firstName"/>
</div>
<div class="form-group">
<form:label path="lastName">Last Name:</form:label>
<form:errors path="lastName"/>
<form:input path="lastName"/>
</div>
<div class="form-group">
<form:label path="salary">Salary:</form:label>
<form:errors path="salary"/>
<form:input path="salary"/>
</div>
<button>Add Player</button>
</form:form>

</div>
</body>
</html>