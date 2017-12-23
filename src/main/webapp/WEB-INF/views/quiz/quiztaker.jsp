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
    <title>User Panel</title>
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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header" >
            <a class="navbar-brand" href="#">SADI</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/admin">Admin Dashboard</a></li>

            <li class="active"><a href="/user">Quiz Taker Dashboard</a></li>

        </ul>
    </div>
</nav>
<div class="container">
    <div class='header'>
        <div class='title'>QUIZ TAKER DASHBOARD</div>
        <button type='button' id='logout' class='btn btn-info' onclick= 'window.location.href="<c:url value="/logout" />" ' style="float:right"> Logout </button>
    </div>
    <ul class="nav nav-tabs" role="tablist"  style="border-color: #2C3E50 ">
        <li role="presentation" class="active"><a href="#takequiz" aria-controls="takequiz" role="tab" data-toggle="tab" style="background-color:#2C3E50 ; color:white">Take Quiz</a></li>
        <li role="presentation"><a href="#history" aria-controls="history" role="tab" data-toggle="tab" style="background-color:#2C3E50 ; color:white">History</a></li>

    </ul>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="takequiz">
    <div id="quizbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
        <div class="panel panel-info" >
            <div class="panel-heading">
                <div class="panel-title" style="color:white"> Take Quiz</div>
            </div>

            <div style="padding-top:30px" class="panel-body" >

                <c:url var="addAction" value="/quizresult/add" ></c:url>

                <form:form action="${addAction}" commandName="quizresult">
                <div class="form-group" style="display:none">


                    <form:label path="id"  class="control-label" >
                        <spring:message text="ID"/>
                    </form:label>

                    <form:input path="id" readonly="true" size="8"   class="form-control" disabled="true" />
                </div>

                <c:forEach items="${listQuestions}" var="question">

                    <div id="questiondiv" style="display:none"><b>#${question.id} </b></div>
                <div id="questionprompt" style="font-weight:bold; color:#3498DB"> ${question.prompt} </div>
                    <div><b>A. </b>${question.answer1}</div>
                    <div><b>B. </b> ${question.answer2}</div>
                    <div> <b>C. </b>${question.answer3} </div>
                    <div><b>D. </b> ${question.answer4}</div>

                    <h4><span class="label label-default" style="background-color:red"><b>Correct Answer: </b></span>  <form:select id = "useranswer" name = "useranswer" path="useranswer" required="required">
                        <option value = "A">A</option>
                        <option value = "B">B</option>
                        <option value = "C">C</option>
                        <option value = "D">D</option>
                    </form:select></h4>

                    <hr style="color:black">
                </c:forEach>
                    <input type="submit"
                           value="Submit" class="btn btn-primary btn-block" />
                </form:form>

                    </div>








        </div>
    </div>

            </div>

        <div role="tabpanel" class="tab-pane" id="history">





        </div>
    </div>
</div>
</body>
</html>