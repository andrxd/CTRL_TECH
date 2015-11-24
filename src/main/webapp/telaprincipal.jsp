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
        <title>Painel de Controle Administrador</title>
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
                        <li><a href="cadastrarUsuario.jsp">CADASTRAR USUARIO</a></li>
                        <li><a href="editarAtivarDesativarusuario.jsp">EDITAR / ATIVAR / DESATIVAR USUARIO</a></li>
                        <li><a href="cadastrarproduto.jsp">CADASTRAR PRODUTO</a></li>
                        <li><a href="listarprodutos.jsp">LISTAR PRODUTOS</a></li>
                        <li><a href="venderReporProduto.jsp">VENDER / REPOR PRODUTO</a></li>
                        <li><a href="editarProduto.jsp">EDITAR / ATIVAR / DESATIVAR</a></li>
                        <li><a href="relatorioproduto.jsp">RELATÓRIO</a></li>
                    </ul>
                </nav>

            </form><center>
            <img src = "imagem/logo.png" width="450" >
            </center>
        </div>
    </body>
</html>
