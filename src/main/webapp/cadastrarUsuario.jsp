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
        <title>Tela de Cadastro do Usuário</title>
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

            <nav id="menu">
                <ul>                    
                    <li><a href="cadastrarUsuario.jsp">CADASTRAR USUARIO</a></li>
                    <li><a href="editarAtivarDesativarUsuario.jsp">EDITAR / ATIVAR / DESATIVAR USUARIO</a></li>
                    <li><a href="cadastrarproduto.jsp">CADASTRAR PRODUTO</a></li>
                    <li><a href="listarprodutos.jsp">LISTAR PRODUTOS</a></li>
                    <li><a href="venderReporProduto.jsp">VENDER / REPOR PRODUTO</a></li>
                    <li><a href="editarProduto.jsp">EDITAR / ATIVAR / DESATIVAR PRODUTO</a></li>
                    <li><a href="relatorioproduto.jsp">RELATÓRIO</a></li>                
                </ul>
            </nav>
            <br/>
            <form action="cadastrarUsuarioServlet" method="post" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
                <fieldset>
                    <legend>DADOS CADASTRAIS</legend>
                    <div>
                        <label>NOME COMPLETO: </label>
                        <input type="text" class="cadastro" id="nome" name="nome"/>
                    </div>
                    <div>
                        <label>RG: </label>
                        <input type="text" class="cadastro" id="rg" name="rg" maxlength="13"/> 
                    </div>

                    <div>
                        <label>FILIAL:</label>
                        <input type="text" class="cadastro" id="filial" name="filial"/>
                    </div>
                    <div>
                        <label>CARGO: </label>
                        <input type="text" class="cadastro" id="cargo" name="cargo"/>
                    </div>
                </fieldset>

                <!-- PERFIL USUARIO -->
                <fieldset>
                    <legend>TIPO DE USUÁRIO</legend>
                    <label>PERFIL: </label>

                    <select id="perfil" name="usuario" >
                        <option value="COMUM">Comum</option>
                        <option value="ADMIN">Admin</option>
                        <option value="SUPORTE">Suporte</option>
                    </select> 
                </fieldset>

                <!-- DADOS DE LOGIN -->
                <fieldset>
                    <legend>DADOS DE ACESSO</legend>

                    <div>
                        <label>E-mail: </label>
                        <input type="text" class="cadastro" id="email" name="email"/>
                    </div>

                    <div>
                        <label>Senha: </label>
                        <input type="password" class="cadastro" id="pass" name="senha"/>
                    </div>

                </fieldset>

                <div class="botoes">
                    <input class="botoesazul" type="submit" value="Cadastrar"/>                    
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <button class="botoeslaranja" type="button">Voltar</button>
                </div>
            </form>

        </div>
    </body>
</html>