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
        <title>Tela de Cadastro do UsuÃ¡rio</title>
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

            <fieldset>
                <form method="get" action="buscarConsoleServlet" >
                    <label for="nome">DIGITE O COD. DE BARRA DO PRODUTO: </label>
                    <input type="text" id="nome" name="busca"/>
                    <button type="submit" value=""><img id="lupa" src = "imagem/lupa.png" width="25" height="23"></button>	
                </form>
            </fieldset>
            <form method="post" action="EditarConsoleServlet" >
                <div id="console">
                    <fieldset>
                        <legend><b>DADOS DO CONSOLE</b></legend>
                       <div>
                            <label >COD DE BARRA:        <c:out value="${prod.codigoBarra}"/>. </label>                            
                            <input type="hidden"  value="${prod.codigoBarra}" name="codigoBarra" maxlength="25"/> 
                        </div>
                        <div>
                            <label >NOME: </label>
                            <input type="text"  class="console" value="${prod.nome}" id="nome" name="nome"/> 
                        </div>
                        <div>
                            <label>VALOR: </label>
                            <input type="text" class="console" value="${prod.valor}"  id="valor" name="valor"/>
                        </div>
                        <div>
                            <label>FABRICANTE: </label>
                            <input type="text" class="console" id="desenvolvedora" value="${prod.fabricanteString}" name="fabricante"/>
                        </div>
                        <div>
                            <label>GARANTIA: </label>
                            <input type="text" class="console" id="garantia" value="${prod.garantia}" name="garantia"/>
                        </div>
                        <div>
                            <label>ARMAZENAMENTO: </label>
                            <input type="text" class="console" id="armazenamento" value="${prod.armazenamento}" name="armazenamento"/>
                        </div>
                        <div>
                            <label>QUANTIDADE </label>
                            <input type="text" class="console" id="quantidade" name="qtdAtual" value="${prod.qtdAtual}"/>
                        </div>                    
                        <!--  ATIVANDO OU DESATIVANDO PRODUTO-->

                        <div>
                            <label>STATUS DO PRODUTO: </label>
                            <c:choose>
                                <c:when test="${prod.status=='1'}">
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
                            <label>DESCRIÇÃO: </label>
                        </div>
                        <div >
                            <textarea name="descricao"  value="${prod.descricao}" class="acessorio" id="descricao" style="resize:none;" rows=10 cols="40">${prod.descricao}</textarea>
                        </div>
                    </fieldset>
                </div>
                <div class="botoes">
                    <button class="botoesazul" type="submit">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <button class="botoeslaranja" type="button">Voltar</button>
                </div>
            </form>>
        </div>


    </body>
</html>
