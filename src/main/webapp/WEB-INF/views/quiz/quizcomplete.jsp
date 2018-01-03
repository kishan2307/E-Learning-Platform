<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/18/2017
  Time: 12:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>You Complete A Quiz</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <!-- Add external style sheet to align elements  -->
    <link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>



</head>
<body>


<div class="container">
    <div class='header'>
    </div>
    <div class="body">
        <h3> HURRAY !! You just completed the quiz , please click the button below to go back and view your result in History section under Us</h3>
     <a href="/user">   <input
             class="btn btn-block btn-primary btn-default" value="Check Your Result"></a>
    </div>


</body>
</html>