<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <link href="css/menu.css"  rel="stylesheet" type="text/css" />
        <script src="javascript/menu.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <div class="central">
            <!-- BANNER CENTRALIZADO -->
            <div id="banner">
                <img src = "imagem/max banner.jpg" >
            </div>
            <!--            MENU DO SUPORTE-->
            <br/>

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
                                <li><a href="editarAtivarDesativarUsuario.jsp">EDITAR / USUARIO</a></li>
                                <li><a href="ListarUsuariosServlet">LISTAR USUARIOS</a></li>
                                <li><a href="gerarRelatorioServlet">RELATÓRIO</a></li>
                                </c:when>  
                            </c:choose>
                        <li><a href="Logout">LOGOUT</a></li>
                    </ul>
                </nav>
            </form><center>
                <img src = "imagem/logo.png" width="450" >
            </center>
        </div>
    </body>
</html>
