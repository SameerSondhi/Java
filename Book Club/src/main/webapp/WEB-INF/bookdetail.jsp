<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
<h1 class="text-center">Book Details</h1>
<div class="card text-center text-white bg-dark">
<div class="card-header">

<!--  c:tag to conditionally render identity of user that posted vs the user that is viewing-->
<c:choose>
<c:when test="${loggedUser  == book.user.id}" >
				<h3 class="card-title">You've read ${book.title } by ${book.author }</h3>
				<h4 class="card-text">Here are your thoughts:</h4>
			</c:when>
			
			<c:otherwise>
				<h3 class="card-title">${book.user.name  } read ${book.title } by ${book.author }</h3>
				<h4 class="card-text">Here are <span>${book.user.name}'s</span> thoughts:</h4>
  			</c:otherwise> 
		</c:choose> 
		
		<p class="card-text">${book.description }</p>
		<div class="btn-group">
		
		<!-- This should conditionally render the edit and delete buttons to make the app more secure -->
		 <c:choose>
			<c:when test="${loggedUser  == book.user.id}" >
				<a href="/books/edit/${ book.id}" class="btn btn-success">Edit book</a>
				<form action="/books/delete/${book.id}" method="post">
							<input type="hidden" name="_method" value="delete"> 
							<input type="submit" value="Delete" class="btn btn-danger">
						</form>
			</c:when>
		</c:choose>
		
		<!-- Back to the shelves link -->
		<a href="/books" class="btn btn-success">Go Back</a>
		</div>
		</div>
		</div>
		</div>
		


</body>
</html>


			