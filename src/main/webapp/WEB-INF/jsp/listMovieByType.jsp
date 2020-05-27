<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/23
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>按类别显示电影</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
<c:forEach items="${MovieListByType}" var="a">
    <tr>
        <a href="/movie/Info/${a.mid}">${a.title}</a><br>
        <!--
        <td>${a.title }</td>
        <td>${a.type}</td>
        <td>${a.actor}</td>
        <td>${a.rating}</td>
        <td>${a.releasedate}</td>
        <td>${a.introduction }</td>
        -->
    </tr>
</c:forEach>
<a href="/movie/getMovieByType/${type}/${front_page}" >上一页</a><br>
<a href="/movie/getMovieByType/${type}/${next_page}">下一页</a><br>
</body>
</html>
