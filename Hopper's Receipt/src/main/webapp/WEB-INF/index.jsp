<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Hopper's Receipt</title>
</head>
<body>
    <h1><c:out value="${name}"/></h1>
        <h2><c:out value="${itemName}"/></h2>
       <p>
        <c:out value="${price}"/>
        <c:out value="${description}"/>
        <c:out value="${vendor}"/>
    </p>
</body>
</html>
