
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>

<html>
<head>
<meta charset="UTF-8">
<title>Demo JSP</title>
<%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String date = sdf.format(new Date());
%>
</head>
<body>
	<h1>Hello World</h1>
	 <% for(int i = 0; i < 5; i++) { %>
        <h1><%= i %></h1>
    <% } %>
    <p>The time is: <%= new Date() %></p>
    
    <h1>Two plus two is: <h1>
<h2><c:out value="${2+2}"/></h2>
    
</body>
</html>