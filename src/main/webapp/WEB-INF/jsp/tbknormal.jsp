<%--
  Created by IntelliJ IDEA.
  User: josebovet
  Date: 11/21/16
  Time: 10:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Pago WebPaySOA</title>
</head>
<body>


<form:form action="${trxNormal.url}" method="post" commandName="trxNormal">
    <p>Monto<form:input path="monto" type="text" name="monto" value="${trxNormal.monto}"/></p>
    <p>Orden<form:input path="orden" type="text" name="orden" value="${trxNormal.orden}"/></p>
    <p>idSesion<form:input path="idSesion" type="text" name="idSesion" value="${trxNormal.idSesion}"/></p>
    <p>URL<form:input path="url" name="url" value="${trxNormal.url}" size="50"/></p>
    <p>Token<input name="token_ws" value="${trxNormal.token}" size="60"/></p>
    <br>
    <input type="submit" value="Ejecutar Pago con WebPay">
</form:form>
</body>
</html>
