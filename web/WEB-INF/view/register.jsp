<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/11/18
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>BlogMaster Register</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
    <%--this is the navbar section--%>
    <jsp:include page="navbar.jsp" />
    <%--this is the register card section--%>
    <div style="margin-top:10vh">
        <div class="card w-50 mx-auto">
            <div class="card-header">
                <h3 style="text-align: center">Tell Us About Yourself</h3>
            </div>
            <div class="card-body">
                <p class="card-title">Please provide the following information:</p>
                <form>
                    <div class="form-group">
                        <label for="email"><strong>Email Address</strong></label>
                        <input type="email" class="form-control" id="email" placeholder="xyz@example.com">
                    </div>
                    <div class="form-group">
                        <label for="password1"><strong>Password</strong></label>
                        <input type="password" class="form-control" id="password1" placeholder="your password">
                    </div>
                    <div class="form-group">
                        <label for="password2"><strong>Repeat Password</strong></label>
                        <input type="password" class="form-control" id="password2" placeholder="repeat your password">
                    </div>
                    <div class="form-group">
                        <label for="firstname"><strong>First Name</strong></label>
                        <input type="text" class="form-control" id="firstname" placeholder="firstname">
                    </div>
                    <div class="form-group">
                        <label for="lastname"><strong>Last Name</strong></label>
                        <input type="text" class="form-control" id="lastname" placeholder="lastname">
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                    <a class="btn btn-primary" style="color:white" href="login.do">Already have account</a>
                </form>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
