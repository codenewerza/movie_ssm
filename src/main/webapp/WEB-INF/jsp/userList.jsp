<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/24
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<c:forEach items="${list}" var="a">
    <tr>
        ${a.username}
        <a href="/admin/du/${a.userid}">删除用户</a><br>
    </tr>
</c:forEach>
</body>
</html>
