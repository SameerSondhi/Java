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
<h1>Dojos and Ninjas Dashboard</h1>
<table class="table table-dark">
    <thead>
        <tr>
            <th>Dojo Location</th>
            <th>Actions</th>   
        </tr>
    </thead>
   <tbody>
 			<c:forEach var="dojo" items="${dojos}">
			<tr>
				<td><c:out value="${dojo.name}"/></td>
				<td><a href="/dojos/${dojo.id }">See Students</a></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
<a href="/dojos/new" class="btn btn-success">Add a Dojo</a>
<a href="/ninjas/new" class="btn btn-success">Add a Ninja</a>
</body>
</html>