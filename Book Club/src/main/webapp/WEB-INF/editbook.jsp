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

<!--  this.Book refers to the model attribute in the get request edit book method which can access a book by its id using bookService.findBook-->
<h1>Change A Book On Your Shelf!</h1>
		<div class="col">
			<h2>Update your book's information</h2>
			<form:form action="/books/edit/${book.id}" method="post" modelAttribute="book">
				<div class="form-group">
					<form:label path="title">Title</form:label>
					<form:input path="title" class="form-control" value="${thisBook.title }"/>
					<form:errors path="title" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="author">Author</form:label>
					<form:input path="author" class="form-control" value="${thisBook.author}"/>
					<form:errors path="author" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="description">Your thoughts</form:label>
					<form:input path="description" class="form-control" value="${thisBook.description }"/>
					<form:errors path="description" class="text-danger" />
				</div>
				<input type="submit" value="Edit Book" class="btn btn-success" />
				<input type="hidden" value="${thisBook.id }" name="book" />
			
				<a href="/books" class="btn btn-success">Back to the shelves</a>
				<form action="/books/delete/${book.id}" method="post">
								<input type="hidden" name="_method" value="delete"> 
								<input type="submit" value="Delete" class="btn btn-danger">
							</form>
			</form:form>
			
		</div>
</body>
</html>