<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${empty errors}">
        Brak błędów
    </c:if>

    <c:if test="${not empty errors}">
        <table border="1">
            <tr>
                <th>Path</th>
                <th>Message</th>
            </tr>
            <c:forEach items="${errors}" var="error">
                <tr>
                    <td>${error.path}</td>
                    <td>${error.message}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
