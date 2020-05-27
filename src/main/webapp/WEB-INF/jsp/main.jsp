<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/20
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户界面</title>
</head>
<body>
    热门电影：<br>
    <c:forEach items="${hotMovieList}" var="a">
        <tr>
            <a href="/hotMovie/Info/${a.mid}">${a.title}</a><br>
        </tr>
    </c:forEach>
    <a href="/user/Info" >查看个人信息</a><br>
    <a href="/user/modifyUserInfo">修改个人信息</a><br>
    <a href="/user/myLike">我的收藏</a><br>
    <a href="/movie/getMovieByType/tvmovie/1">电视电影</a>
    <a href="/movie/getMovieByType/cartoon/1">动画</a>
    <a href="/movie/getMovieByType/western/1">西部</a><br>
    <form action="/user/search" method="post">
        <input id="x" name="x" class="text" placeholder="输入关键字"/>
        <input type="submit" class="button" value="搜索" />
    </form>
</body>
</html>
