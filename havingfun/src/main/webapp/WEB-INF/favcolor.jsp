<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Favorite Color</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
Your favorite color is <c:out value="${color}"/>
</body>
<script src="/js/script.js"></script>
</html>