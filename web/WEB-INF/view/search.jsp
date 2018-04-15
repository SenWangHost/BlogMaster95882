
<%--
  Created by IntelliJ IDEA.
  User: SenWang
  Date: 4/14/18
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Blog Master Search</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
          integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <link rel="stylesheet" href="../../static/css/myblogs.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
    <link rel="stylesheet" href="../../static/css/search.css" />
</head>
<body>
    <%--this is the navbar section--%>
    <jsp:include page="navbar.jsp" />
    <%--this is the dashboard section--%>
    <c:if test="${user != null}">
        <jsp:include page="dashboard.jsp" />
    </c:if>
    <%--This is the body section--%>
    <div>
        <div class="col-sm-8 searchsection">
            <form action="search.do" method="post">
                <div class="form-group">
                    <label for="InputQuery"><strong>Found The Blogs You Are Interested:</strong></label>
                    <input type="text" class="form-control" id="InputQuery" name="query" placeholder="Enter Search Query" />
                </div>
                <button type="submit" class="btn btn-outline-success" name="action" value="search">Search</button>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
</body>
</html>
