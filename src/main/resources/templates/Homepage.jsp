<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-   8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<% List bugList = (List)session.getAttribute("bugList");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bugs</title>
</head>
<body>
<c:out value="Hello"></c:out>
<h3>Bugs</h3>
<hr size="4" color="gray"/>
<table>
<%=eList%>
    <c:forEach items="${bugList}" var="bug">
        <tr>
            <td>Title: <c:out value=“${bug.title}"/></td>
            <td>Descriptioon: <c:out value="${bug.description}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>