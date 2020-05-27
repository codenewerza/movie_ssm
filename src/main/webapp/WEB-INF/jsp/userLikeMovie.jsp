<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/24
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>收藏列表</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
    收藏电影列表：<br>
    <c:forEach items="${likeList}" var="a">
        <tr>
            <a href="/user/myLikeMovieInfo/${a.mid}">${a.title}</a>
            <a href="/user/deleteMyLikeMovie/${a.mid}">取消收藏</a><br>
        </tr>
    </c:forEach>
</body>
</html>
