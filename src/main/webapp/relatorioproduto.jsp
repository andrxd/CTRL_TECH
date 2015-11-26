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
        <title>Relatorio</title>
        <meta charset="UTF-8">
        <link href="css/menu.css"  rel="stylesheet" type="text/css" />
        <script src="menu.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

    </head>

    <body>
           <div class="central">
            <!-- BANNER CENTRALIZADO -->
            <div id="banner">
                <img src = "imagem/max banner.jpg" >
            </div><nav id="menu">
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
            <br/>
        <h1>Relatorio</h1>
        <table>
            <tr>
                <th>Data</th>
                <th>Nome do Usuario</th>
                <th>Email do Usuario</th>
                <th>Filial</th>
                <th>Codigo de Barras</th>
                <th>Nome do Produto</th>
                <th>Quantidade</th>
                <th>Acao</th>
            </tr>
            <c:forEach items="${relatorio}" var="rel">
                <tr>
                    <td><c:out value="${rel.data}" /></td>
                    <td><c:out value="${rel.nomeUsuario}" /></td>
                    <td><c:out value="${rel.emailUsuario}" /></td>
                    <td><c:out value="${rel.filial}" /></td>
                    <td><c:out value="${rel.codigoProduto}" /></td>
                    <td><c:out value="${rel.nomeProduto}" /></td>
                    <td><c:out value="${rel.quantidade}" /></td>
                    <td><c:out value="${rel.acao}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
