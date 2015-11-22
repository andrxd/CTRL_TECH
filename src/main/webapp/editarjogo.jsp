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

            <div id="jogo">
                <fieldset>
                    <legend><b>DADOS DO JOGO</b></legend>
                    <div>
                        <label >CÃD DE BARRA: </label>
                        <input type="text" class="jogo" id="codbarra" name="codbarra"/>
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
                        <label>DESENVOLVEDORA: </label>
                        <input type="text" class="jogo" id="desenvolvedora" name="desenvolvedora"/>
                    </div>
                    <div>
                        <label>GARANTIA: </label>
                        <input type="text" class="jogo" id="garantia" name="garantia"/>
                    </div>
                    <div>
                        <label>ARMAZENAMENTO: </label>
                        <input type="text" class="jogo" id="armazenamento" name="armazenamento"/>

                    </div>
                    <div>
                        <label>GÃNERO: </label>
                        <input type="text" class="jogo" id="genero" name="genero"/>

                    </div>
                    <div>
                        <label>FAIXAETARIA: </label>
                        <input type="text" class="jogo" id="faixaetaria" name="faixaetaria"/>

                    </div>
                    <div>
                        <label>PLATAFORMA: </label>

                        <select id="consolebox" >
                            <option value="Playstation3">Playstation 3</option>
                            <option value="Playstation4">Playstation 4</option>
                            <option value="Xbox360">Xbox 360</option>
                            <option value="Xboxone">Xbox One</option>
                            <option value="PC">Computador</option>

                        </select> 
                    </div>
                    <!--  ATIVANDO OU DESATIVANDO PRODUTO-->

                    <div>
                        <label>STATUS DO PRODUTO: </label>

                        <select id="statusbox" >
                            <option value="Ativo">Ativo</option>
                            <option value="Desativo">Desativo</option>
                        </select> 
                    </div>

                    <div>
                        <label>DESCRIÃÃO: </label>
                    </div>
                    <div >
                        <textarea name="descricao"  class="acessorio" id="descricao" style="resize:none;" rows=10 cols="40"></textarea>
                    </div>
            </div>
            <div class="botoes">
                <button class="botoesazul" type="button">Salvar</button>
                <button class="botoesvermelho" type="button">Limpar</button>
                <button class="botoeslaranja" type="button">Voltar</button>
            </div>
        </div>

    </body>
</html>
