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
        <title>Cadastro de Jogo</title>
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
            <!--   MENU  -->
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
            </form>
             <div id="navbar" name="navbar" >
                
                <div id="abas">
                    <ul>
                        <li><a href="cadastrarConsole.jsp">Console</a></li>
                        <li><a href="#"  id="onlink" >Jogo</a></li>
                        <li><a href="cadastrarAcessorio.jsp" >Acessório</a></li>
                    </ul>
                </div>
            <form method="POST" action="cadastrarJogoServlet" >
                <div id="jogo">
                    <fieldset>
                        <legend><b>DADOS DO JOGO</b></legend>
                       <div>
                                <label >CÓD DE BARRA: </label>
                                <input type="text"   class="jogo" id="codbarra" name="codbarra"/>
                            </div>
                            <div>
                                <label >NOME: </label>
                                <input type="text"  class="jogo" id="nome" name="nome"/> 
                            </div>
                            <div>
                                <label>VALOR: </label>
                                <input type="text" class="jogo" id="valor" name="valor"/>
                            </div>                                          
                            
                            <div>
                                <label>QUANTIDADE: </label>
                                <input type="text" pattern="[0-9]{1,3}" class="jogo" id="armazenamento" name="quantidade"/>

                            </div>
                            <div>
                                <label>GÊNERO: </label>
                                <input type="text" pattern="[a-zA-Z, ,]{1,30}"class="jogo" id="genero" name="genero"/>

                            </div>
                            <div>
                                <label>FAIXA ETARIA: </label>
                                <input type="text" pattern="[a-zA-Z,0-9,' ',]{1,6}" class="jogo" id="faixaetaria" name="faixaetaria"/>

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
                            <select id="perfil"  name="status">
                                <option value="1" selected="selected">Ativo</option>
                                <option value="0" >Inativo</option>
                            </select>
                        </div>

                        <div>
                            <label>DESCRIÇÃO: </label>
                        </div>
                        <div >
                            <textarea name="descricao"  class="acessorio" id="descricao" style="resize:none;" rows=10 cols="40"></textarea>
                        </div>
                    </fieldset>
                </div>

                <div class="botoes">
                    <button class="botoesazul" type="Submit">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <a href="javascript:window.history.go(-1)"><button class="botoeslaranja" type="button">Voltar</button></a>
                </div>
            </form>
        </div>
    </body>
</html>
