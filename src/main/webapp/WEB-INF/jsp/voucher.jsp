<%--
  Created by IntelliJ IDEA.
  User: josebovet
  Date: 11/22/16
  Time: 12:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Voucher JSP</title>
</head>
<body>
<h1>Pago ACEPTADO por webpay (se deben guardar datos para mostrar voucher)</h1>
<ul>
    <li>codigo autorizacion: ${authorizationCode}</li>
    <li>Orden: ${buyOrder}</li>
    <li>token: ${token_ws}</li>
    <li>VCI: ${VCI}</li>
</ul>

<form action="${urlVoucer}" method="post">
    <input type="hidden" name="token_ws" value="${token_ws}">
    <input type="submit" value="Continuar &raquo;">
</form>
</body>
</html>
