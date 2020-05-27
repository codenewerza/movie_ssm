<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/22
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户查看个人信息</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
    用户名：${user.username}<br>
    性别：${user.sex}<br>
    电话号码：${user.phone}<br>
    邮箱：${user.email}<br>
</body>
</html>
