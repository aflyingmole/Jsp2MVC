<%--
  Created by IntelliJ IDEA.
  User: jhta
  Date: 2024-07-16
  Time: 오전 10:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<ul>
    <%
        if (session.getAttribute("id") == null) {
    %>
    <li><a href="${pageContext.request.contextPath}/member/join">가입</a></li>
    <li><a href="${pageContext.request.contextPath}/member/login">회원로그인</a></li>
    <%
    } else {
    %>
    <li><a href="${pageContext.request.contextPath}/member/logout">회원로그아웃</a></li>

    <%
        }
    %>
    <li><a href="${pageContext.request.contextPath}/member/list">회원목록</a></li>

</ul>
</body>
</html>
<%--    <c:choose>--%>
<%--        <c:when test="${empty id}">--%>
<%--        </c:when>--%>
<%--        <c:otherwise>--%>
<%--        </c:otherwise>--%>
<%--    </c:choose>--%>