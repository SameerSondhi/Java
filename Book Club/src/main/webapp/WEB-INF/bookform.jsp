<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Add A Book To Your Shelf!</h1>
		<div class="col">
			<h2>Enter your book's information</h2>
			<form:form action="/books/new" method="post" modelAttribute="book">
				<div class="form-group">
					<form:label path="title">Title</form:label>
					<form:input path="title" class="form-control" />
					<form:errors path="title" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="author">Author</form:label>
					<form:input path="author" class="form-control" />
					<form:errors path="author" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="description">Your thoughts</form:label>
					<form:input path="description" class="form-control" />
					<form:errors path="description" class="text-danger" />
				</div>
				<input type="submit" value="Add Book" class="btn btn-success" />
				
				<!-- Hidden input to make sure that there is an association with the user that is adding the book -->
				<input type="hidden" value="${loggedUser}" name="user"/>
				
				<a href="/books" class="btn btn-success">Back to the shelves</a>
			</form:form>
		</div>
</body>
</html>