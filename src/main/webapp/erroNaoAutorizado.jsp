<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Erro</title>
    <meta charset="UTF-8">
    <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
    <link href="${pathResources}/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>CTRL TECH</h1>
    <h2>Usuário não autorizado a acessar esta funcionalidade</h2>
    <a href="telaprincipal.jsp">Voltar</a>
  </body>
</html>