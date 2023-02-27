<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji Form</title>

<link rel="stylesheet" type="text/css" href="/css/style.css">

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
    <h3>Send An Omikuji!</h3>
    <form action='/omikuji/submit' method='POST'>
		<label>Pick a number between 5 and 25:</label> <br>
    	<input type="number" name='number'> <br>
    	
		<label>Enter the name of any city:</label> <br>
    	<input type='text' name='city'> <br>
    	
    	<label>Enter the name of any real person:</label> <br>
    	<input type='text' name='person'> <br>
    	
    	<label>Enter professional endeavor or hobbies:</label> <br>
    	<input type='text' name='hobby'> <br>
    	
    	<label>Enter any type of living thing:</label> <br>
    	<input type='text' name='thing'> <br>
    	
    	<label>Say something nice to someone:</label> <br>
    	<textarea rows="4" cols = "50" name='compliment'></textarea> <br>
    	
    	<input class="btn btn-success" type='submit' value='Send and Show a Friend'>
    </form>


</body>
</html>