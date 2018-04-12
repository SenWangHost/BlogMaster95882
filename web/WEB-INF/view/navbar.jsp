<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/11/18
  Time: 9:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--this is the navbar section--%>
<div>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="homepage.do">
            <img src="../../static/images/blogmaster.png" width="60px" height="60px" alt="blogmaster">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="homepage.do">HomePage<span class="sr-only">(current)</span></a>
                </li>
                <c:choose>
                    <c:when test="${user == null}">
                        <li class="nav-item active">
                            <a class="nav-link" href="login.do">Login</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="register.do">Register</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item active">
                            Login as:<a class="nav-link" href="homepage.do"><strong>${user.firstname}${user.lastname}</strong></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="logout.do">Logout</a>
                        </li>
                    </c:otherwise>
                </c:choose>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
</div>
