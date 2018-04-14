<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/12/18
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Blog Master My Blogs</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="../../static/css/myblogs.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
</head>
<body>
    <%--This is the navbar section--%>
    <jsp:include page="navbar.jsp" />
    <%--This is the dashboard section--%>
    <jsp:include page="dashboard.jsp" />
    <%--This is the body section --%>
    <div class="col-sm-10">
        <%--This is the new blog section--%>
        <div class="newblogsection">
            <form action="createblog.do" method="post">
                <div>
                    <div class="form-group">
                        <label class="textareatitle" for="textarea">Say Something Today!!!</label>
                        <c:forEach var="error" items="${errors}">
                            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                                <strong>${error}</strong>
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </c:forEach>
                        <textarea class="form-control" id="textarea" name="content" rows="3"></textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success" name="button" value="post">Post</button>
                    </div>
                </div>
            </form>
        </div>
        <%--This is the blogs displays section--%>
        <div>
            <c:forEach var="blog" items="${blogs}" varStatus="loop">
                <div class="chatcontainer">
                    <label>${blog.author}</label>
                    <c:choose>
                        <c:when test="${fStatuses[loop.index]}">
                            <a href="favorite.do?blogid=${blog.id}"><i class="material-icons">favorite</i></a>
                        </c:when>
                        <c:otherwise>
                            <a href="favorite.do?blogid=${blog.id}"><i class="material-icons">favorite_border</i></a>
                        </c:otherwise>
                    </c:choose>
                    <span>${fNumbers[loop.index]}</span>
                    <p>${blog.content}</p>
                    <c:choose>
                        <c:when test="${empty ldlist[loop.index]}">
                            <div class="likedislike">
                                <a class="social-like" href="likedislike.do?blogid=${blog.id}&status=1">
                                    <span class="like"><i class="material-icons">thumb_up</i></span>
                                    <span class="count" >15</span>
                                </a>
                                &nbsp;
                                <a class="social-dislike" href="likedislike.do?blogid=${blog.id}&status=0">
                                    <span class="dislike" >10</span>
                                    <span class="like"><i class="material-icons">thumb_down</i></span>
                                </a>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="likedislike">
                                <c:choose>
                                    <c:when test="${ldlist[loop.index].status}">
                                        <a class="social-like-disable" href="likedislike.do?blogid=${blog.id}&status=1" onclick="return false;">
                                            <span class="like"><i class="material-icons">do_not_disturb</i></span>
                                            <span class="count" >15</span>
                                        </a>
                                        &nbsp;
                                        <a class="social-dislike" href="likedislike.do?blogid=${blog.id}&status=0">
                                            <span class="dislike" >10</span>
                                            <span class="like"><i class="material-icons">thumb_down</i></span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="social-like" href="likedislike.do?blogid=${blog.id}&status=1">
                                            <span class="like"><i class="material-icons">thumb_up</i></span>
                                            <span class="count" >15</span>
                                        </a>
                                        &nbsp;
                                        <a class="social-dislike-disable" href="likedislike.do?blogid=${blog.id}&status=0" onclick="return false;">
                                            <span class="dislike" >10</span>
                                            <span class="like"><i class="material-icons">do_not_disturb</i></span>
                                        </a>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </c:otherwise>
                    </c:choose>

                    <span>${blog.date}</span>
                </div>
            </c:forEach>

        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
