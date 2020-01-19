<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/01/17
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/demo3" method="post">
    <input name = "username">
    <input type="submit" value="提交">
  </form>
  <a href="/servletDemo/RequestDemo2">我从哪里来</a><br>
  <a href="/servletDemo/responseDemo1">responseDemo1</a><br>
  <a href="/servletDemo/responseDemo4">输出字符流responseDemo4</a><br>
  <a href="/servletDemo/responseDemo5">输出字节流responseDemo5</a><br>
  <a href="/servletDemo/checkCodeServlet">验证码checkCodeServlet</a><br>
  <a href="regist.html">验证码页面</a><br>
  </body>
</html>
