<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/21
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404界面</title>
</head>
<script>
    alert(${error_cause});
    location.href = "login.jsp";
</script>
<input type="hidden" id="error_cause" value='${error_cause}'>
出现异常：${error_cause}
<body>

</body>
</html>
