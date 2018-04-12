<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/11/18
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>BlogMaster Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
    <%--this is the navbar section--%>
    <jsp:include page="navbar.jsp" />
    <%--this is the login card section--%>
    <div style="margin-top:10vh">
        <div class="card w-50 mx-auto">
            <div class="card-header">
                <h3 style="text-align: center">Welcome To Blog Master</h3>
            </div>
            <c:forEach var="error" items="${errors}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>${error}</strong>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:forEach>
            <div class="card-body">
                <p class="card-title">Please provide your email and password:</p>
                <form action="login.do" method="post">
                    <div class="form-group">
                        <label for="email"><strong>Email Address</strong></label>
                        <input type="email" class="form-control" name="email" id="email" value="${form.email}" placeholder="xyz@example.com" />
                    </div>
                    <div class="form-group">
                        <label for="password"><strong>Password</strong></label>
                        <input type="password" class="form-control" name="password" id="password" value="${form.password}"placeholder="your password" />
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="check" />
                        <label class="form-check-label" for="check">Remember Me</label>
                    </div>
                    <button type="submit" class="btn btn-primary" name="button" value="login">Login</button>
                    <a class="btn btn-primary" style="color:white" href="register.do">Register</a>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
