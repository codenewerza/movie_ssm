<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/21
  Time: 9:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form name="f" action="/lg/login" method="post">
    <div id="us">
        <input id="username" name="username" type="text" class="text" placeholder="请输入用户名">
    </div>
    <div id="pd">
        <input id="password" name="password" type="password" class="text" placeholder="请输入密码" >
    </div>
    <div id="st">
        <input type="submit" class="button" value="登录" >
    </div>
    <div id="zc" >
        <a href="/lg/tz">注册</a>
    </div>
</form>
</body>
</html>