<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<p>Your Gold: <c:out value="${totalGold}"/></p>
<div class="building">
<form method="POST" action="/getGold">
<input type="hidden" value="farm" name="building">
<h2>Farm</h2>
<p>Earns 10-20 Gold</p>
<button>Find Gold</button>
</form>
</div>
<div class="building">
<form method="POST" action="/getGold">
<input type="hidden" value="cave" name="building">
<h2>Cave</h2>
<p>Earns 5-10 Gold</p>
<button>Find Gold</button>
</form>
</div>
<div class="building">
<form method="POST" action="/getGold">
<input type="hidden" value="house" name="building">
<h2>House</h2>
<p>Earns 2-5 Gold</p>
<button>Find Gold</button>
</form>
</div>
<div class="building">
<form method="POST" action="/getGold">
<input type="hidden" value="casino" name="building">
<h2>Casino</h2>
<p>Earns / Takes 0-50 Gold</p>
<button>Find Gold</button>
</form>
</div>


<h2>Activities</h2>
<div class="activities">
<c:forEach items="${activities}" var="act">
<p class='${act.contains("Ouch!") ? "red" : "green"}'><c:out value="${act}"/></p>
</c:forEach>
</div>
</body>
</html>