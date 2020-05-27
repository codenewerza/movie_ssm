<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/22
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户修改信息页面</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
<form action="/user/modifyInfo" method="post">
    密码：<input id="password" name="password" type="text" class="text"><br>
    手机号：<input id="phone" name="phone" type="text" class="text"><br>
    性别：<input id="sex" name="sex" type="text" class="text"><br>
    电子邮箱：<input id="email" name="email" type="text" class="text"><br>
    <input type="submit" class="button" value="提交" ><br>
</form>
</body>
</html>
