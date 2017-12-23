<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Panel</title>
    <meta name="description" content="Quiz">
    <meta name="author" content="Quiz">
    <meta name="keywords" content="quiz">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

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
            <li class="active"><a href="/admin">Admin Dashboard</a></li>

            <li><a href="/user">Quiz Taker Dashboard</a></li>

        </ul>
    </div>
</nav>

<div class="container">
    <div class='header'>
        <div class='title'>ADMINISTRATOR DASHBOARD</div>
        <button type='button' id='logout' class='btn btn-info'onclick= 'window.location.href="<c:url value="/logout" />" ' style="float:right"> Logout </button>
    </div>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist" style="border-color: #2C3E50 ">
        <li role="presentation" class="active"><a href="#questionlibrary" aria-controls="questionlibrary" role="tab" data-toggle="tab" style="background-color:#2C3E50 ; color:white">Question Library</a></li>
        <li role="presentation"><a href="#testtype" aria-controls="testtype" role="tab" data-toggle="tab" style="background-color:#2C3E50 ; color:white">Quiz Type</a></li>

    </ul>
    <br>
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="questionlibrary">
            <div class="panel panel-info" >
                <div class="panel-heading" >
                    <div class="panel-title" style="color:white">Question Tool</div>
                </div>
                <div class="panel-body" >


            <c:url var="addAction" value="/question/add" ></c:url>

            <form:form action="${addAction}" commandName="question">
                    <div class="form-group" style="display:none">



                                <form:input path="id" readonly="true" size="8"   class="form-control" disabled="true" />

                    </div>
                        <div class="form-group">
                            <form:label path="prompt" class="control-label">
                                <spring:message text="Question Prompt"/>
                            </form:label>

                            <form:textarea path="prompt" class="form-control" rows="5"  required="required"/>
                        </div>
                    <div class="form-group">
                            <form:label path="answer1">
                                <spring:message text="A"/>
                            </form:label>

                            <form:input path="answer1"  class="form-control"  required="required"  />
                    </div>
                    <div class="form-group">
                            <form:label path="answer2">
                                <spring:message text="B"/>
                            </form:label>

                            <form:input path="answer2" class="form-control"  required="required" />
                    </div>
                    <div class="form-group">
                            <form:label path="answer3">
                                <spring:message text="C"/>
                            </form:label>

                            <form:input path="answer3" class="form-control"  required="required" />
                    </div>
                    <div class="form-group">
                            <form:label path="answer4">
                                <spring:message text="D"/>
                            </form:label>
                        <form:input path="answer4" class="form-control"  required="required"  />

                    </div>
                    <div class="form-group">

                       <h4><span class="label label-default" style="background-color:red"><b>Correct Answer: </b></span>  <form:select id = "correctanswer" name = "correctanswer" path="correctanswer" required="required">
                            <option value = "A">A</option>
                            <option value = "B">B</option>
                            <option value = "C">C</option>
                            <option value = "D">D</option>
                       </form:select></h4>

                    </div>
                    <div class="form-group">
                            <c:if test="${!empty question.prompt}">
                                <input type="submit"
                                       value="<spring:message text="Edit Question"/>" class="btn btn-primary"/>
                            </c:if>
                            <c:if test="${empty question.prompt}">
                                <input type="submit"
                                       value="<spring:message text="Add Question"/>"  class="btn btn-primary"/>
                            </c:if>
                    </div>

            </form:form>
                </div>
            </div>
            <br>
            <div class="panel panel-info" >
                <div class="panel-heading" >
                    <div class="panel-title" style="color:white">Question Library</div>
                </div>
                <div class="panel-body" >
                    <c:if test="${!empty listQuestions}">

                    <c:forEach items="${listQuestions}" var="question">

                        <div id="questiondiv" style="display:none">${question.id}</div>
                        <div id="questionprompt" style="font-weight:bold; color:#3498DB">  ${question.prompt} </div>
                        <div> <b>A. </b>${question.answer1} </div>
                        <div><b>B. </b>  ${question.answer2} </div>
                        <div><b>C. </b>  ${question.answer3} </div>
                        <div><b>D. </b> ${question.answer4} </div>
                        <div><b>Correct Answer: </b>  ${question.correctanswer} </div>


                <div> <a href="<c:url value='/edit/${question.id}' />" class="btn btn-success">Edit</a>
                    <a href="<c:url value='/remove/${question.id}' />" class="btn btn-danger">Delete</a> </div>
                <hr style="color:black">
                        </c:forEach>

                        </c:if>
                    </div>
                </div>



        </div>

        <div role="tabpanel" class="tab-pane" id="testtype">
            <div class="panel panel-info"  >
                <div class="panel-heading">
                    <div class="panel-title" style="color:white">Quiz Type Tool</div>
                </div>
                <div class="panel-body" >


                <c:url var="addAction" value="/quiz/add" ></c:url>

            <form:form action="${addAction}" commandName="quiztype">
                    <div class="form-group" style="display:none">
                            <form:label path="id"  class="control-label">
                                <spring:message text="ID"/>
                            </form:label>

                            <form:input path="id" readonly="true" size="8"  disabled="true" />

                    </div>

                    <div class="form-group">
                            <form:label path="type" class="control-label">
                                <spring:message text="Quiz Type"/>
                            </form:label>

                            <form:input path="type" required="required" class="form-control"/>
                    </div>
                    <div class="form-group">
                            <form:label path="numquestion"  class="control-label">
                                <spring:message text="No Questions"/>
                            </form:label>
                            <form:input path="numquestion"  required="required" class="form-control"/>
                    </div>
                    <div class="form-group">
                            <form:label path="time" class="control-label">
                                <spring:message text="Time"/>
                            </form:label>
                            <form:input path="time"  required="required" class="form-control"/>
                    </div>

                    <div class="form-group">

                            <c:if test="${!empty quiztype.type}">
                                <input type="submit"
                                       value="<spring:message text="Edit Quiz Type"/>" class="btn btn-primary" />
                            </c:if>
                            <c:if test="${empty quiztype.type}">
                                <input type="submit"
                                       value="<spring:message text="Add Quiz Type"/>" class="btn btn-primary" />
                            </c:if>
                    </div>

            </form:form>
                </div>
            </div>


            <br>
                <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title" style="color:white">Quiz Type List</div>
                    </div>
                    <div class="panel-body" >
            <c:if test="${!empty listQuizTypes}">


                    <c:forEach items="${listQuizTypes}" var="quiztype">

                        <div style="display:none">${quiztype.id}</div>
                        <div id="quiztype" style="font-weight:bold; color:#3498DB">Quiz Type: ${quiztype.type}</div>
                        <div><b>Number of Questions: </b>${quiztype.numquestion}</div>
                        <div><b>Time Limit: </b>${quiztype.time}</div>

                            <div><a href="<c:url value='/editquiz/${quiztype.id}' />" class="btn btn-success">Edit</a>
                           <a href="<c:url value='/removequiz/${quiztype.id}' />" class="btn btn-danger">Delete</a></div>
                    <hr>
                    </c:forEach>

            </c:if>
        </div>
            </div>
        </div>
    </div>
    </div>

</div>

</div>

</div>
</div>
</body>
</html>