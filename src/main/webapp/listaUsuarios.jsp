<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Usuarios</title>
        <meta charset="UTF-8">
        <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
        <link href="${pathResources}/css/reset.css" rel="stylesheet" type="text/css" />
        <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <h1>Lista de Usuarios</h1>
        <table>
            <tr>
                <th>Email</th>
                <th>Nome</th>
                <th>RG</th>
                <th>Filial</th>
                <th>Cargo</th>
                <th>Tipo Usuario</th>
            </tr>
            <c:forEach items="${usuarios}" var="user">
                <tr>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.nomeCompleto}" /></td>
                    <td><c:out value="${user.rg}" /></td>
                    <td><c:out value="${user.filial}" /></td>
                    <td><c:out value="${user.cargo}" /></td>
                    <td><c:out value="${user.tipoUsuario}" /></td>
                </tr>
            </c:forEach>
        </table>
        <hr/>
        <%-- VERIFICA SE USUÁRIO TEM O PAPEL DE ADMIN --%>
      
        <p><a href="Logout">Sair</a> (Logado como ${sessionScope.usuario.nomeCompleto})</p>
    </body>

</html>
