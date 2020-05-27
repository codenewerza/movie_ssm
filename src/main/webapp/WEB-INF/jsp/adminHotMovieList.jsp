<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/25
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>热门电影管理</title>
</head>
<body>
<c:forEach items="${list}" var="a">
    <tr>
            ${a.title}
        <a href="/admin/showHotMovieInfo/${a.mid}">查看</a>
        <a href="/admin/dhm/${a.mid}">删除</a>
        <br>
    </tr>
</c:forEach>

</body>
</html>
