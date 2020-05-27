<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/27
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
<c:forEach items="${list}" var="a">
    <tr>
        <a href="/user/searchMovieInfo/${a.mid}">${a.title}</a><br>
    </tr>
</c:forEach>
</body>
</html>
