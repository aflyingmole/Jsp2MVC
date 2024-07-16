<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-16
  Time: 오전 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>member/result.jsp</title>
</head>
<body>
<h1>요청하신 작업이 처리되었습니다;;;</h1>
<p>${msg}</p>
<a href="<%=request.getContextPath()%>/home.jsp">home.jsp</a>
</body>
</html>
