<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body class="container">

	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ page isErrorPage="true"%>
	<div class="row">
		<h1>The Book Broker</h1>
		<h5>Find your next book here!</h5>
		<div class="col">
			<h2>Register</h2>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group">
					<form:label path="name">Name</form:label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:input type="password" path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="confirm">Confirm Password</form:label>
					<form:input type="password" path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-success" />
			</form:form>
		</div>

		<div class="col">
			<h2>Login</h2>

			<form:form action="/login" method="post" modelAttribute="newLogin">
				<div class="form-group">
					<form:label path="email">Email</form:label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="password">Password</form:label>
					<form:input type="password" path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Log In" class="btn btn-success" />
			</form:form>

		</div>
	</div>

</body>
</html>