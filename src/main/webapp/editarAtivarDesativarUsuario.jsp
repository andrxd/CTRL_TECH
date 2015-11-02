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
            <table cellspacing="10">
                <tr>
                    <td>
                        <label for="nome">DIGITE O EMAIL  USUARIO: </label>

                    </td>
                    <td>
                        <input type="text" id="nome" name="busca"/>
                    </td>
                    <td>
                        <img src = "imagem/lupa.png" width="25" height="25">

                        <!--                        <input type="button" value="Listar Todos" onclick="" >-->
                    </td>
            </table>
            <br><br>
            <fieldset>
                <legend>DADOS CADASTRAIS</legend>
                <table cellspacing="10">
                    <tr>
                        <td>
                            <label for="nome">NOME COMPLETO: </label>
                        </td>
                        <td align="left">
                            <input type="text" id="nome" name="nome"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="rg">RG: </label>
                        </td>
                        <td align="left">
                            <input type="text" id="rg" name="rg" maxlength="13"/> 
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>FILIAL:</label>
                        </td>
                        <td align="left">
                            <input type="text" id="filial" name="filial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="rg">CARGO: </label>
                        </td>
                        <td align="left">
                            <input type="text" id="cargo" name="cargo"/>
                        </td>
                    </tr>
                </table>
            </fieldset>

            <br />
            <!-- ENDEREÇO -->
            <fieldset>
                <legend>TIPO DE USUÁRIO:</legend>
                <table cellspacing="10">

                    <input type="radio" name="usuario" value="comum" />Comum
                    <input  type="radio" name="usuario" value="administrador"/>Administrador
                    <input type="radio" name="usuario" value="suporte"/>Suporte

                </table>
            </fieldset>
            <br />

            <!-- DADOS DE LOGIN -->
            <fieldset>
                <legend>DADOS DE ACESSO</legend>
                <table cellspacing="10">
                    <tr>
                        <td>
                            <label for="email">E-mail: </label>
                        </td>
                        <td align="left">
                            <input type="text" id="email" name="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="pass">Senha: </label>
                        </td>
                        <td align="left">
                            <input type="password" id="pass" name="pass"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="passconfirm">Confirme a senha: </label>
                        </td>
                        <td align="left">
                            <input type="password" id="passconfirm" name="passconfirm"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br>
            <fieldset>
                <legend>STATUS DA CONTA:</legend>
                <table cellspacing="10">

                    <input type="radio" name="status" value="Ativo" />Ativo
                    <input  type="radio" name="status" value="Desativo"/>Desativo


                </table>
            </fieldset>
            <center>
                <input type="button" value="Salvar" onClick="enviar()"/>
                <input type="button" value="Limpar" onClick="limpar()"/>
                <input type="button" value="Voltar" onClick=""/>
            </center> 

    </body>
</html>
