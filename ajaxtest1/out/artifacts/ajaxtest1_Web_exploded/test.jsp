<%--
  Created by IntelliJ IDEA.
  User: 17609184675
  Date: 2019/6/20
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <div><h1>hello.div</h1></div>
    <%
        out.print("hello,out");
    %>
    <span>
        <%
            response.getWriter().write("hello,response");
        %>
    </span>
</div>
</body>
</html>
