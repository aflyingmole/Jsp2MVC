<%@ page import="java.util.ArrayList" %>
<%@ page import="test.DTO.Member" %><%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-16
  Time: 오후 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");

    %>
<table border="1">
    <tr>
        <th>id</th>
        <th>password</th>
        <th>email</th>
        <th>age</th>
        <th>date</th>
    </tr>
        <%
    for (Member member : list) {
        %>
    <tr>
        <td><%=member.getId()%></td>
        <td><%=member.getPwd()%></td>
        <td><%=member.getEmail()%></td>
        <td><%=member.getAge()%></td>
        <td><%=member.getRegDate()%></td>
        <td><a href="<%=request.getContextPath()%>/member/delete?id=<%=member.getId()%>">삭제</a></td>
        <td><a href="<%=request.getContextPath()%>/member/update?id=<%=member.getId()%>">수정</a></td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
