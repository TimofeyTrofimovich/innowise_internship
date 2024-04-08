<%--
  Created by IntelliJ IDEA.
  User: liker
  Date: 07.04.2024
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <style>
        <%@include file='../css/homepage.css' %>
    </style>
    <title>homepage</title>
</head>
<body>
    <h1 id="header">Welcome to Online Shop</h1>
    <form method="post" action="items">
        <input type="text" placeholder="Enter your name" name="name">
        <button type="submit">Enter</button>
    </form>
</body>
</html>
