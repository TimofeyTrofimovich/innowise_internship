<%--
  Created by IntelliJ IDEA.
  User: liker
  Date: 07.04.2024
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='../css/goods.css' %>
    </style>
</head>
<body>
<h1>Hello, ${sessionScope.name}!</h1>
<h4>Make your order</h4>
<form action="cheque" method="post">
    <div class="in_form">
        <select name="items" multiple="multiple">
            <option value="Book">Book (5.5 $)</option>
            <option value="Mobile phone">Mobile phone (150 $)</option>
            <option value="Laptop">Laptop (830 $)</option>
            <option value="Toy">Toy (0.34 $)</option>
            <option value="Computer mouse">Computer mouse (12.7 $)</option>
        </select>
        <br>
        <button type="submit">Submit</button>
    </div>
</form>
</body>
</html>
