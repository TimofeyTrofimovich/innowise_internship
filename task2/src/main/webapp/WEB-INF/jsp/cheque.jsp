<%--
  Created by IntelliJ IDEA.
  User: liker
  Date: 07.04.2024
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='../css/cheque.css' %>
    </style>
</head>
<body>
    <div class="wrapper">
        <h1>Dear, ${sessionScope.name}, your order: </h1>
        <table>
            <c:forEach var="item" items="${requestScope.items}" >
                <tr><td>${item.name}: ${item.price} $"</td></tr>
            </c:forEach>
        </table>
        <h4>Total: $ ${requestScope.sum} </h4>
    </div>

</body>
</html>
