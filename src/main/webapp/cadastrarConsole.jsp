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
        <title>Cadastro do Console</title>
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
            <!--  MENU -->
              <form id="telaAdministrador">
                <nav id="menu">
                    <ul>
                        <li><a href="cadastrarUsuario.jsp">CADASTRAR USUARIO</a></li>
                        <li><a href="editarAtivarDesativarUsuario.jsp">EDITAR / ATIVAR / DESATIVAR USUARIO</a></li>
                        <li><a href="listarproduto.jsp">LISTAR PRODUTOS</a></li>
                        <li><a href="venderReporProduto.jsp">VENDER / REPOR PRODUTO</a></li>
                        <li><a href="editarconsole.jsp">EDITAR / ATIVAR / DESATIVAR PRODUTO</a></li>
                        <li><a href="relatorioproduto.jsp">RELATÓRIO</a></li>
                    </ul>
                </nav>
            </form>
             <div id="navbar" name="navbar" >
                
                <div id="abas">
                    <ul>
                        <li><a href="#" id="onlink">Console</a></li>
                        <li><a href="cadastrarJogo.jsp" >Jogo</a></li>
                        <li><a href="cadastrarAcessorio.jsp" >Acessório</a></li>
                    </ul>
                </div>
            <form method="POST" action="cadastrarConsoleServlet" class="login">
                <div id="console">
                    <fieldset>
                        <legend><b>DADOS DO CONSOLE</b></legend>
                        <div>
                            <label >CÓD DE BARRA: </label>
                            <input type="text" class="console" id="codbarra" name="codbarra"/>
                        </div>
                        <div>
                            <label >NOME: </label>
                            <input type="text"  class="console" id="nome" name="nome"/> 
                        </div>
                        <div>
                            <label>VALOR: </label>
                            <input type="text" class="console" id="valor" name="valor"/>
                        </div>
                        <div>
                            <label>FABRICANTE: </label>
                            <input type="text" class="console" id="desenvolvedora" name="fabricante"/>
                        </div>
                        <div>
                            <label>GARANTIA: </label>
                            <input type="text" class="console" id="garantia" name="garantia"/>
                        </div>
                        <div>
                            <label>ARMAZENAMENTO: </label>
                            <input type="text" class="console" id="armazenamento" name="armazenamento"/>
                        </div>
                        <div>
                            <label>QUANTIDADE </label>
                            <input type="text" class="console" id="quantidade" name="quantidade"/>
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
                    <button class="botoesazul" type="submit">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                   <a href="javascript:window.history.go(-1)"><button class="botoeslaranja" type="button">Voltar</button></a>
                </div>
            </form>
        </div>

    </body>
</html>
