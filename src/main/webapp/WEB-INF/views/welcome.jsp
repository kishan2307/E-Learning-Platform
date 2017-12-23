<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome Back</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/main.css' />" rel="stylesheet"></link>
</head>
<body>
<div class="container" style="text-align:center">
	<div class='header'>
		<h2>Welcome Back</h2>
	</div>
	<div class="body">

		<button onclick='window.location.href="/admin" '
				class="btn btn-block btn-primary btn-default" >Go To Admin Dashboard</button>
		<button onclick='window.location.href="/user" '
				class="btn btn-block btn-primary btn-default" >Go To User Dashboard</button>
		<button onclick= 'window.location.href="<c:url value="/logout" />" '
				class="btn btn-block btn-primary btn-default" >Log Out</button>
	</div>

</div>
</body>
</html>