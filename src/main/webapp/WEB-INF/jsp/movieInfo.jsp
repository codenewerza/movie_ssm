<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/27
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影详情</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
电影标题：${movieInfo.title}<br>
电影评分：${movieInfo.rating}<br>
上映日期：${movieInfo.releasedate}<br>
电影介绍：${movieInfo.introduction}<br>
<a href="/user/like/${movieInfo.mid}/${movieInfo.title}">收藏</a><br>
</body>
</html>
