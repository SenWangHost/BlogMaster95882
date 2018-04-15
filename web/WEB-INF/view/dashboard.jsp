<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/12/18
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../../static/css/dashboard.css" />
</head>
<body>
<div class="col-sm-2 sidebar">
    <div class="imagesec">
        <img src="../../static/images/accountimage.png" width="200vw" height="200vh" alt="accountimage" />
    </div>
    <div class="namesection">
        <p>${user.firstname} ${user.lastname}</p>
    </div>
    <div class="buttonsection">
        <a class="btn btn-outline-success btn-lg btn-block" href="homepage.do">Public Space</a>
    </div>
    <div class="buttonsection">
        <a class="btn btn-outline-success btn-lg btn-block" href="myblogs.do">My Blogs</a>
    </div>
    <div class="buttonsection">
        <a class="btn btn-outline-success btn-lg btn-block" href="myfavorites.do">My Favorites</a>
    </div>
    <div class="buttonsection">
        <a class="btn btn-outline-success btn-lg btn-block" href="search.do">Search Blogs</a>
    </div>
    <div class="buttonsection">
        <button type="button" class="btn btn-outline-success btn-lg btn-block">My Profile</button>
    </div>
    <div class="buttonsection">
        <a class="btn btn-outline-warning btn-lg btn-block" href="logout.do">Log Out</a>
    </div>
</div>
</body>
</html>
