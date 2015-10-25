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
        <title>Cadastro do Usuário</title>
        <meta charset="UTF-8">
        <link href="/css/menu.css"  rel="stylesheet" type="text/css" />
        <script src="menu.js" type="text/javascript"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>

        <!-- BANNER CENTRALIZADO -->
        <div id="banner" align="center" >
            <img src = "imagem/banner.png" width="700" height="200" >

        </div>

        <div id="menu" >
            <br><br>
            <ul>
                <li><a href="">Cadastrar / Repor Produto</a></li>
                <li><a href="">Consultar</a></li>
                <li><a href="">Vender</a></li>

            </ul>
        </div>

        <br><br>
        <form action="cadastrarUsuario" method="post" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
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
                            <label>NASCIMENTO: </label>
                        </td>
                        <td align="left">
                            <input type="text" id ="dia" name="dia" size="2" maxlength="2" value="dd"/> 
                            <input type="text" id="mes" name="mes" size="2" maxlength="2" value="mm"/> 
                            <input type="text" id="ano" name="ano" size="4" maxlength="4" value="aaaa"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="rg">RG: </label>
                        </td>
                        <td align="left">
                            <input type="text" id="rg" name="rg" size="13" maxlength="13"/> 
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
                            <input type="password" id="senha" name="senha"/>
                        </td>
                    </tr>

                </table>
            </fieldset>
            <br>

            <input type="submit" value="Cadastrar"/>
            <input type="button" value="Limpar" onClick="limpar()"/>

        </form>
    </body>
</html>