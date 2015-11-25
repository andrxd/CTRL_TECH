<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Listar Produtos</title>
        <meta charset="UTF-8">
        <link href="css/menu.css"  rel="stylesheet" type="text/css" />
        <script src="menu.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        <table>
            <tr>
                <th>Codigo de Barras</th>
                <th>Nome</th>
                <th>Descricao</th>
                <th>Quantidade Atual</th>
                <th>Tipo</th>
                <th>Valor</th>
            </tr>
            <c:forEach items="${lista}" var="prod">
                <tr>
                    <td><c:out value="${prod.codigoBarra}" /></td>
                <td><c:out value="${prod.nome}" /></td>
                <td><c:out value="${prod.descricao}" /></td>
                <td><c:out value="${prod.qtdAtual}" /></td>
                <td><c:out value="${prod.tipo}" /></td>
                <td><c:out value="${prod.valor}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
