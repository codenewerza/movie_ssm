<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 2020/5/27
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上架热门电影详情</title>
</head>
<body>
<form action="/addHotMovieInfo">
    电影名：<input id="title" name="title" type="text" class="text"><br>
    评分：<input id="rating" name="rating" type="text" class="text"><br>
    上映时间：<input id="releasedate" name="releasedate" type="text" class="text"><br>
    电影简介：<input id="introduction" name="introduction" type="text" class="text"><br>
    <input type="submit" class="button" value="提交" ><br>
</form>
</body>
</html>
