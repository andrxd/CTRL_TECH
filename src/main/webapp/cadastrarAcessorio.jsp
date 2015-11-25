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
        <title>Cadastro do Acessorio</title>
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
            <!--            MENU DO COMUM-->
            <nav id="menu">
                <ul>
                    <li><a href="#">CADASTRAR PRODUTO</a></li>
                    <li><a href="#">CONSULTAR ESTOQUE</a></li>
                    <li><a href="#">VENDER / REPOR PRODUTO</a></li>
                    <li><a href="#">EDITAR / ATIVAR / DESATIVAR</a></li>
                </ul>
            </nav><br/>
            <!--<fieldset>
                <label for="nome">DIGITE O NOME OU COD. DE BARRA DO PRODUTO: </label>
                <input type="text" id="nome" name="busca"/>
                <img src = "imagem/lupa.png" width="25" height="23">
            </fieldset>-->
            <form method="POST" action="cadastrarAcessorioServlet" class="login">
                <div id="acessorio">
                    <fieldset>
                        <legend><b>DADOS DO ACESSORIO</b></legend>
                        <div>
                            <label >COD DE BARRA: </label>
                            <input type="text" class="acessorio" id="codbarra" name="codbarra"/>
                        </div>
                        <div>
                            <label >NOME: </label>
                            <input type="text"  class="acessorio" id="nome" name="nome" maxlength="25"/> 
                        </div>
                        <div>
                            <label >MARCA: </label>
                            <input type="text"  class="acessorio" id="nome" name="marca" maxlength="25"/> 
                        </div>
                       
                        <div>
                            <label>VALOR: </label>
                            <input type="text" class="acessorio" id="valor" name="valor"/>
                        </div>
                        <div>
                            <label>QUANTIDADE: </label>
                            <input type="text" class="acessorio" id="valor" name="quantidade"/>
                        </div> 
                        <div>
                            <label>PLATAFORMA: </label>

                            <select id="consolebox" name="plataforma" >
                                <option value="Playstation 3">Playstation 3</option>
                                <option value="Playstation 4">Playstation 4</option>
                                <option value="Xbox 360">Xbox 360</option>
                                <option value="Xbox One">Xbox One</option>
                                <option value="PC">PC</option>

                            </select> 
                        </div>

                        <!--  ATIVANDO OU DESATIVANDO PRODUTO-->

                        <div>
                            <label>STATUS DO PRODUTO: </label>
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

                        <div>
                            <label>DESCRIÃÃO: </label>
                        </div>
                        <div >
                            <textarea name="descricao"  class="acessorio" id="descricao" style="resize:none;" rows=10 cols="40"></textarea>
                        </div>

                    </fieldset>

                </div>

                <div class="botoes">
                    <button  class="botoesazul" type="submit">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <button class="botoeslaranja" type="button">Voltar</button>
                </div>
            </form>
        </div>
    </body>
</html>
