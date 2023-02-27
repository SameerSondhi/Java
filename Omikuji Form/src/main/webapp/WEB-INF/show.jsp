<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/show.css">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Here's Your Omikuji!</h1>
<div class = "message">
<span>In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/> with <c:out value="${person}"/> as your roommate, <c:out value= "${hobby}"/> for a living.</span> <br>
<span>The next time you see a <c:out value="${thing}"/>, you will have good luck. <c:out value="${compliment}"/></span><br>
</div>
<a href = "/omikuji/showform">Go Back</a>
</body>
</html>





