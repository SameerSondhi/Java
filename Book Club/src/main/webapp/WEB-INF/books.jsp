<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
	<h5>
		Hello, <c:out value="${loggedUser.name}" />. Welcome to...
	 </h5> 
	<h1>The Book Broker! </h1>
	
	<h3>Available books to borrow</h3>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Owner</th>
				<th>Actions</th>
				<th>More Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${allBooks}">
			<c:if test="${loggedUser.id!=book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.name}"/></td>
				
			<c:if test="${loggedUser==book.user}">
							<td><a class="btn btn-success" href="books/edit/${book.id}">Change</a></td>
							<td><form action="/books/delete/${book.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete" class="btn btn-danger">
							</form></td>
						</c:if>
						<c:if test="${loggedUser!=book.user}">
							<td><a class="btn btn-success" href="/books/borrow/${book.id}">Borrow</a></td>
							<td></td>
						</c:if>
					</tr>
				</c:if>
			
			</c:forEach>
		</tbody>
	</table>
	
	<a class="btn btn-success" href="/books/new">Add A Book</a> <a class="btn btn-danger" href="/logout">Log Out</a>
	
	<h3>Books I'm borrowing</h3>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author</th>
				<th>Owner</th>
				<th>Actions</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${allBooks }">
			<c:if test="${user_id == book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.name}"/></td>
						<c:if test="${loggedUser!=book.user}">
								<td><a class="btn btn-success" href="books/return/${book.id}">Return</a></td>
						<td></td>
						</c:if>
					</tr>
				 </c:if> 
			
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>


<%-- <c:if test="${loggedUser!=book.borrower.id}">
					<tr>
						<td><c:out value="${book.id}"/></td>
						<td><a href="books/${book.id}"><c:out value="${book.title}"/></a></td>
						<td><c:out value="${book.author}"/></td>
						<td><c:out value="${book.user.name}"/></td> --%>
				<%-- 		<c:if test="${user==book.user.id}">
							<td><a href="books/${book.id}/edit">edit</a> 
							<form action="/books/delete/${book.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete" class="btn btn-danger">
							</form>
							</td>
						</c:if>
						<c:if test="${user!=book.user.id}">
							<td><a href="books/borrow/${book.id}">Borrow</a></td>
						</c:if>
					</tr>
				</c:if>
 --%>




