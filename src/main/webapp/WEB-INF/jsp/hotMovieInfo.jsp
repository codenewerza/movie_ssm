<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/23
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>热门电影详情</title>
</head>
<body>
<a href="/lg/main">主页</a><br>
电影标题：${movie.title}<br>
电影评分：${movie.rating}<br>
上映日期：${movie.releasedate}<br>
电影介绍：${movie.introduction}<br>
<a href="/user/like/${movie.mid}/${movie.title}">收藏</a><br>
</body>
</html>
