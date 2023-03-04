<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />

<!--  CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">

<!--  Bootstrap -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Fruit Store Page</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<table class="table">
		<tbody>
			<tr>
				<th>Name</th>
				<th>Price</th>

				<!-- Looping through arrayList and rendering one fruit name and price in each row -->
			</tr>
			<c:forEach var="fruits" items="${fruits}">
				<tr>
					<td><c:out value="${fruits.name}"></c:out></td>
					<td><c:out value="${fruits.price}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>

