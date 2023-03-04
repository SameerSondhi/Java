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
<h1>Add A Ninja</h1>
<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
<p class="form-group">
        <form:label path="dojo">Dojo</form:label> 
       <form:select path="dojo" class = "form-control">
		<c:forEach items="${dojos}" var="dojo">
   			    			<form:option value="${dojo.id}"><c:out value="${dojo.name}"/></form:option>
		    			</c:forEach>
		
	</form:select>
        <form:errors path="dojo" class="text-danger"/>
    </p>
    <p class="form-group">
        <form:label path="firstName">First Name</form:label> 
        <form:input path="firstName" class="form-control"/>
        <form:errors path="firstName" class="text-danger"/>
    </p>
     <p class="form-group">
        <form:label path="lastName">Last Name</form:label>        
        <form:input path="lastName" class="form-control"/>
        <form:errors path="lastName" class="text-danger"/> 
    </p>
    <p class="form-group">
        <form:label path="age">Age</form:label>             
        <form:input type="number" path="age" class="form-control"/>
        <form:errors path="age" class="text-danger"/> 
    </p>    
     <input type="submit" value="Create" class="btn btn-success"/>
     <a href="/" class="btn btn-success">Go Back</a>
</form:form>  
 
</body>
</html>