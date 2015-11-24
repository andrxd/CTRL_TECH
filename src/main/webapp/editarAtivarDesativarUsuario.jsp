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
        <title>Tela de Controle de Usuário</title>
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
                    <li><a href="editarAtivarDesativarusuario.jsp">EDITAR / ATIVAR / DESATIVAR USUARIO</a></li>
                    <li><a href="cadastrarproduto.jsp">CADASTRAR PRODUTO</a></li>
                    <li><a href="listarprodutos.jsp">LISTAR PRODUTOS</a></li>
                    <li><a href="venderReporProduto.jsp">VENDER / REPOR PRODUTO</a></li>
                    <li><a href="editarProduto.jsp">EDITAR / ATIVAR / DESATIVAR PRODUTO</a></li>
                    <li><a href="relatorioproduto.jsp">RELATÓRIO</a></li>
                </ul>
            </nav>
            <br/>
            <form method="get" action="buscarUsuarioServlet" class="login">
                <fieldset>
                    <label>DIGITE O EMAIL DO USUARIO: </label>
                    <input type="text" id="busca" name="emailBusca"/>
                    <button type="submit" value=""><img id="lupa" src = "imagem/lupa.png" width="25" height="23"></button>				
                </fieldset>
            </form>
            <form method="POST" action="EditarUsuarioServlet" class="login">
                <fieldset>
                    <legend>DADOS CADASTRAIS</legend>
                    <div>
                        <label>NOME COMPLETO: </label>
                        <input type="text" class="cadastro" id="nome" name="nome" value="${user.nomeCompleto}"/>
                    </div>
                    <div>
                        <label>RG: </label>
                        <input type="text" class="cadastro" id="rg" name="rg" value="${user.rg}" maxlength="13"/> 
                    </div>

                    <div>
                        <label>FILIAL:</label>
                        <input type="text" class="cadastro" id="filial" name="filial" value="${user.filial}"/>
                    </div>
                    <div>
                        <label>CARGO: </label>
                        <input type="text" class="cadastro" id="cargo" name="cargo" value="${user.cargo}" />
                    </div>

                    <div>

                        <label>PERFIL: </label>
                        <c:choose>
                            <c:when test="${user.ativo=='1'}">
                                <select id="perfil"  name="status">
                                    <option value="1" selected="selected">Ativo</option>
                                    <option value="0" >Inativo</option>
                                </select>
                            </c:when>                     
                            <c:otherwise>
                                <select id="perfil" name="status" >
                                    <option value="1" >Ativo</option>
                                    <option value="0" selected="selected">Inativo</option>
                                </select>
                            </c:otherwise>
                        </c:choose>

                    </div>
                </fieldset>

                <!-- PERFIL USUARIO -->
                <fieldset>
                    <legend>TIPO DE USUÁRIO</legend>
                    <label>PERFIL: </label>
                    <c:choose>
                        <c:when test="${user.tipoUsuario=='COMUM'}">
                            <select id="perfil" name="tipoUsuario">
                                <option value="COMUM" selected="selected">Comum</option>
                                <option value="ADMIN">Admin</option>
                                <option value="SUPORTE">Suporte</option>
                            </select> 
                        </c:when>
                        <c:when test="${user.tipoUsuario=='ADMIN'}">
                            <select id="perfil" name="tipoUsuario">
                                <option value="COMUM" >Comum</option>
                                <option value="ADMIN" selected="selected">Admin</option>
                                <option value="SUPORTE">Suporte</option>
                            </select> 
                        </c:when>
                        <c:when test="${user.tipoUsuario=='SUPORTE'}">
                            <select id="perfil" name="tipoUsuario">
                                <option value="COMUM" >Comum</option>
                                <option value="ADMIN">Admin</option>
                                <option value="SUPORTE" selected="selected">Suporte</option>
                            </select> 
                        </c:when>
                        <c:otherwise>
                            <select id="perfil" name="tipoUsuario">
                                <option value="COMUM" CHECKED>Comum</option>
                                <option value="ADMIN">Admin</option>
                                <option value="SUPORTE" >Suporte</option>
                            </select> 
                        </c:otherwise>
                    </c:choose>
                </fieldset>
                <!-- DADOS DE LOGIN -->
                <fieldset>
                    <legend>DADOS DE ACESSO</legend>

                    <div>
                        <label>E-mail: </label>
                        <input type="text" class="cadastro" id="email" name="email" value="${user.email}"/>
                    </div>

                    <div>
                        <label>Senha: </label>
                        <input type="password" class="cadastro" id="pass" name="senha" value="${user.senha}"/>
                    </div>

                </fieldset>
                <div class="botoes">
                    <button class="botoesazul"  type="Submit">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <button class="botoeslaranja" type="button">Voltar</button>
                </div>
            </form>
        </div>
    </body>
</html>
