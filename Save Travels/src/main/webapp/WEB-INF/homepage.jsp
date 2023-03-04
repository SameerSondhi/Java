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
<body class="container">
<h1 class="text-center">Save Travels</h1>
<h3>All Expenses</h3>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Expense Name</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Actions</th>
            <th>More Actions</th>
        </tr>
    </thead>
    <tbody>
 			<c:forEach var="expense" items="${expenses}">
			<tr>
				<td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"/></a></td>
				<td><c:out value="${expense.vendor}"/></td>
				<td>$<c:out value="${expense.amount}"/></td>
				<td><a href="/expenses/edit/${expense.id }">Edit</a></td>
				<td><form action="/expenses/delete/${expense.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-danger btn-sm">
						</form></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
<h3>Add An Expense</h3>
<form:form action="/new" method="post" modelAttribute="expense">
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
    <input type="submit" value="Submit" class="btn btn-success"/>
</form:form>   
</body>
</html>