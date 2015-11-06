<%-- 
    Document   : editarAtivarDesativarUsuario
    Created on : Nov 1, 2015, 10:31:51 PM
    Author     : Andre
--%>

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
        <script src="menu.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <!-- BANNER CENTRALIZADO -->
        <div id="banner" align="center" >
            <img src = "imagem/banner.png" width="800" height="200" >

        </div>

        <nav>
            <ul>
                <li><span class="CadastrarUsuarios"></span><a href="#">CADASTRAR USUARIO</a></li>
                <li><span class="EditarUsuarios"></span><a href="#">EDITAR / ATIVAR / DESATIVAR USUARIO</a></li>

            </ul>
        </nav>
        <!-- BARRA DE BUSCA DE PERFIS--> 
        <fieldset>
            <form method="get" action="buscarUsuarioServlet" class="login">
                <table cellspacing="10">
                    <tr>
                        <td>
                            <label for="nome">DIGITE O EMAIL  USUARIO: </label>

                        </td>
                        <td>
                            <input type="text" id="nome" name="emailBusca" value="${user.email}"/>
                        </td>
                        <td>
                            <img src = "imagem/lupa.png" width="25" height="25">
                            <input type="submit" value="Buscar"/>
                            <!--                        <input type="button" value="Listar Todos" onclick="" >-->
                        </td>
                </table>
            </form>

            <br><br>            
            <form method="POST" action="EditarUsuarioServlet" class="login">
                <fieldset>
                    <legend>DADOS CADASTRAIS</legend>
                    <table cellspacing="10">
                        <tr>
                            <td>
                                <label for="nome">NOME COMPLETO: </label>
                            </td>
                            <td align="left">
                                <input type="text" id="nome" name="nome" value="${user.nomeCompleto}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">RG: </label>
                            </td>
                            <td align="left">
                                <input type="text" id="rg" name="rg" maxlength="13" value="${user.rg}"/> 
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>FILIAL:</label>
                            </td>
                            <td align="left">
                                <input type="text" id="filial" name="filial" value="${user.filial}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="rg">CARGO: </label>
                            </td>
                            <td align="left">                                
                                <input type="text" id="cargo" name="cargo" value="${user.cargo}"/>
                            </td>
                        </tr>
                    </table>
                </fieldset>

                <br />
                <!-- ENDEREÇO -->
                <fieldset>
                    <legend>TIPO DE USUÁRIO:</legend>
                    <table cellspacing="10">                        
                        <c:choose>
                            <c:when test="${user.tipoUsuario=='COMUM'}">
                                <input type="radio" name="tipoUsuario" value="COMUM" CHECKED>Comum
                                <input  type="radio" name="tipoUsuario" value="ADMIN" >Administrador
                                <input type="radio" name="tipoUsuario" value="SUPORTE">Suporte
                            </c:when>
                            <c:when test="${user.tipoUsuario=='ADMIN'}">
                                <input type="radio" name="tipoUsuario" value="COMUM" >Comum
                                <input  type="radio" name="tipoUsuario" value="ADMIN" CHECKED>Administrador
                                <input type="radio" name="tipoUsuario" value="SUPORTE">Suporte
                            </c:when>
                            <c:when test="${user.tipoUsuario=='SUPORTE'}">
                                <input type="radio" name="tipoUsuario" value="COMUM" >Comum
                                <input  type="radio" name="tipoUsuario" value="ADMIN" >Administrador
                                <input type="radio" name="tipoUsuario" value="SUPORTE" CHECKED>Suporte
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="tipoUsuario" value="COMUM" CHECKED>Comum
                                <input  type="radio" name="tipoUsuario" value="ADMIN" >Administrador
                                <input type="radio" name="tipoUsuario" value="SUPORTE" >Suporte
                            </c:otherwise>
                        </c:choose>
                    </table>
                </fieldset>
                <br />

                <!-- DADOS DE LOGIN -->
                <fieldset>
                    <legend>DADOS DE ACESSO</legend>
                    <table cellspacing="10">
                        <tr>
                            <td>
                                <label for="emailUsuario" >E-mail: </label>
                            </td>
                            <td align="left">
                                 <input type="text" id="email" name="ema" value="${user.email}"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="pass">Senha: </label>
                            </td>
                            <td align="left">
                                <input type="password"  name="senha" value="${user.senha}" />
                            </td>
                        </tr>                  
                    </table>
                </fieldset>
                <br>
                <fieldset>
                    <legend>STATUS DA CONTA:</legend>
                    <table cellspacing="10">
                        <c:choose>
                            <c:when test="${user.ativo==1}">
                                <input type="radio" name="status" value="1" CHECKED>Ativo                        
                                <input  type="radio" name="status" value="0"  >Desativo
                            </c:when>
                            <c:when test="${user.ativo==0}">
                                <input type="radio" name="status" value="1" >Ativo                        
                                <input  type="radio" name="status" value="0"  CHECKED>Desativo
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="status" value="1" >Ativo                        
                                <input  type="radio" name="status" value="0" CHECKED>Desativo
                            </c:otherwise>
                        </c:choose>
                    </table>                
                </fieldset>
                <center>
                    <input type="Submit" value="Salvar" onClick="enviar()"/>
                    <input type="button" value="Limpar" onClick="limpar()"/>
                    <input type="button" value="Voltar" onClick=""/>
                </center> 
            </form>
    </body>
</html>
