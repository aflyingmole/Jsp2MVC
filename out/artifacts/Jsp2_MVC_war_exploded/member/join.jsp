<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-16
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>회원가입</h1>
<form method="post" action="<%=request.getContextPath()%>/member/join">
    회원아이디<br/>
    <input type="text" name="id"><br/>
    비밀번호<br/>
    <input type="text" name="pwd"><br/>
    이메일<br/>
    <input type="text" name="email"><br/>
    나이<br/>
    <input type="text" name="age"><br/>
    <input type="submit" value="등록">
</form>
</body>
</html>
