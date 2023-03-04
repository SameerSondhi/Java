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
<h1 class="text-center">Expense Details</h1>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Expense Name</th>
            <th>Vendor</th>
            <th>Amount</th>
            <th>Description</th>
            <th>Actions</th>
            
        </tr>
    </thead>
    <tbody>
			<tr>
				<td><c:out value="${expense.name}"/></td>
				<td><c:out value="${expense.vendor}"/></td>
				<td>$<c:out value="${expense.amount}"/></td>
				<td><c:out value="${expense.description}"/></td>
				<td><a href="/">Go Back</a></td>
			</tr>
    </tbody>
</table>

</body>
</html>