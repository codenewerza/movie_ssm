<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/24
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影管理</title>
</head>
<body>
<c:forEach items="${movie_list}" var="a">
    <tr>
        ${a.title}
        <a href="/admin/showMovieInfo/${a.mid}">查看</a>
        <a href="/admin/dm/${a.mid}">删除</a>
        <br>
    </tr>
</c:forEach>
<a href="/admin/mc/${front_page}" >上一页</a><br>
<a href="/admin/mc/${next_page}">下一页</a><br>
</body>
</html>