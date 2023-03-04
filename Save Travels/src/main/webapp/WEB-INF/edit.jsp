<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
<h1 class = "text-center">Edit Expense</h1>
<form:form action="/expenses/edit/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
    <p class="form-group">
        <form:label path="name">Name</form:label> 
        <form:input path="name" class="form-control"/>
        <form:errors path="name" class="text-danger"/>
    </p>
    <p class="form-group">
        <form:label path="vendor">Vendor</form:label>        
        <form:input path="vendor" class="form-control"/>
        <form:errors path="vendor" class="text-danger"/> 
    </p>
    <p class="form-group">
        <form:label path="amount">Amount</form:label>             
        <form:input type="number" path="amount" class="form-control"/>
        <form:errors path="amount" class="text-danger"/> 
    </p>    
     <p class="form-group">
        <form:label path="description">Description</form:label> 
        <form:textarea path="description" class="form-control"/>
        <form:errors path="description" class="text-danger"/>
    </p>  
    <input class="btn btn-success" type="submit" value="Edit"/>
    
</form:form> <br>
<a href="/">Go Back</a>
</body>
</html>
