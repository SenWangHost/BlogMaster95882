<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/11/18
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlogMaster Homepage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="../../static/css/homepage.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
</head>
<body>
    <%--this is the navbar section--%>
    <jsp:include page="navbar.jsp" />
    <%--this is the dashboard section--%>
    <c:if test="${user != null}" >
        <jsp:include page="dashboard.jsp" />
    </c:if>
    <%--This is the body section--%>
    <div>
        <%--This is the blogs displays section--%>
        <div>
            <c:forEach var="blog" items="${blogs}" varStatus="loop">
                <div class="chatcontainer">
                    <label>${blog.author}</label>
                    <c:choose>
                        <c:when test="${fStatuses[loop.index]}">
                            <a href="favorite.do?blogid=${blog.id}&page=homepage"><i class="material-icons">favorite</i></a>
                        </c:when>
                        <c:otherwise>
                            <a href="favorite.do?blogid=${blog.id}&page=homepage"><i class="material-icons">favorite_border</i></a>
                        </c:otherwise>
                    </c:choose>
                    <span>${fNumbers[loop.index]}</span>
                    <p>${blog.content}</p>
                    <c:choose>
                        <c:when test="${empty ldlist[loop.index]}">
                            <div class="likedislike">
                                <a class="social-like" href="likedislike.do?blogid=${blog.id}&status=1">
                                    <span class="like"><i class="material-icons">thumb_up</i></span>
                                    <span class="count" >${likeNumbers[loop.index]}</span>
                                </a>
                                &nbsp;
                                <a class="social-dislike" href="likedislike.do?blogid=${blog.id}&status=0">
                                    <span class="dislike">${dislikeNumbers[loop.index]}</span>
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
                                            <span class="count" >${likeNumbers[loop.index]}</span>
                                        </a>
                                        &nbsp;
                                        <a class="social-dislike" href="likedislike.do?blogid=${blog.id}&status=0">
                                            <span class="dislike" >${dislikeNumbers[loop.index]}</span>
                                            <span class="like"><i class="material-icons">thumb_down</i></span>
                                        </a>
                                    </c:when>
                                    <c:otherwise>
                                        <a class="social-like" href="likedislike.do?blogid=${blog.id}&status=1">
                                            <span class="like"><i class="material-icons">thumb_up</i></span>
                                            <span class="count" >${likeNumbers[loop.index]}</span>
                                        </a>
                                        &nbsp;
                                        <a class="social-dislike-disable" href="likedislike.do?blogid=${blog.id}&status=0" onclick="return false;">
                                            <span class="dislike" >${dislikeNumbers[loop.index]}</span>
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
