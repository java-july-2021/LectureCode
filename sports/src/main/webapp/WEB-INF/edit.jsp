<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Edit Team</h1>
<hr>
<form:form method="POST" action="/edit/${team.id}" modelAttribute="team">
<div class="form-group">
<form:label path="teamName">Team Name</form:label>
<form:errors path="teamName"/>
<form:input type="text" path="teamName"/>
</div>
<div class="form-group">
<form:label path="city">City</form:label>
<form:errors path="city"/>
<form:input type="text" path="city"/>
</div>
<div class="form-group">
<form:label path="sport">Sport</form:label>
<form:errors path="sport"/>
<form:input type="text" path="sport"/>
</div>
<div class="form-group">
<form:label path="budget">Budget</form:label>
<form:errors path="budget"/>
<form:input type="number" path="budget"/>
</div>
<div class="form-group">
<form:label path="isActive">Active?</form:label>
<form:errors path="teamName"/>
<form:select path="isActive">
<option value="true">Active</option>
<option value="false">Not Active</option>
</form:select>
</div>
<button>Edit Team</button>
</form:form>

</div>



</body>
</html>