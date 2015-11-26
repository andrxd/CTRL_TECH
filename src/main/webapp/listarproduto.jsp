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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body>
        <div class="central">
        <div id="banner">
                <img src = "imagem/max banner.jpg" >
            </div>
            <!--  MENU -->
            <form id="telaAdministrador">
                <nav id="menu">
                    <ul>
                        <li><a href="cadastrarConsole.jsp">CADASTRAR PRODUTO</a></li>
                        <li><a href="editarconsole.jsp">EDITAR PRODUTO</a></li>                                               
                        <li><a href="retirarReporProduto.jsp">RETIRAR / REPOR PRODUTO</a></li>
                        <li><a href="ListarProdutosServlet">LISTAR PRODUTOS</a></li>                        

                        <c:choose>
                            <c:when test="${sessionScope.usuario.tipoUsuario=='ADMIN'}">
                                <li><a href="cadastrarUsuario.jsp">CADASTRAR USUARIO</a></li>
                                <li><a href="editarAtivarDesativarUsuario.jsp">EDITAR USUARIO</a></li>
                                <li><a href="ListarUsuariosServlet">LISTAR USUARIOS</a></li>
                                <li><a href="gerarRelatorioServlet">RELATÓRIO</a></li>
                                </c:when>  
                            </c:choose>
                        <li><a href="Logout">LOGOUT</a></li>
                    </ul>
                </nav>
            </form>
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
        </div>
    </body>
</html>
