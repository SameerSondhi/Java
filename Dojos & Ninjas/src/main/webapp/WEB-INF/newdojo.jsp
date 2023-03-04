<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>Add A Dojo</h1>
<form:form action="/" method="post" modelAttribute="dojo">
    <p class="form-group">
        <form:label path="name">Name</form:label> 
        <form:input path="name" class="form-control"/>
        <form:errors path="name" class="text-danger"/>
    </p>
     <input type="submit" value="Create" class="btn btn-success"/> 
     <a class="btn btn-success" href="/ninjas/new">Add Ninjas</a>
     <a href="/" class="btn btn-success">Go Back</a>
</form:form>  

</body>
</html>