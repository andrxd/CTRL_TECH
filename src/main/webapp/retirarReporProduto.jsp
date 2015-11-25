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
        <title>Editar Jogo</title>
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
                <form method="get" action="buscarProdutoServlet" >
                    <label for="nome">DIGITE O COD. DE BARRA DO PRODUTO: </label>
                    <input type="text" id="nome" name="busca"/>
                    <button type="submit" value=""><img id="lupa" src = "imagem/lupa.png" width="25" height="23"></button>	
                </form>
            </fieldset>

            <div id="jogo">
                <fieldset>
                    <legend><b>DADOS DO JOGO</b></legend>
                    <div>
                        <label >COD DE BARRA: ${prod.codigoBarra} </label>                           
                         
                    </div>
                    <div>
                        <label >NOME: ${prod.nome}</label>   
                    </div>
                    <div>
                        <label>QUANTIDADE ATUAL: ${prod.qtdAtual}</label>
                    </div> 
                </fieldset>
            </div>          
                    
            <form method="POST" action="RetirarProdutoServlet">
                <fieldset>
                    <legend>RETIRAR PRODUTO</legend>
                    <div>
                        <input type="hidden"  value="${prod.codigoBarra}" name="codigoBarra" maxlength="25"/> 
                        <input type="hidden" name="qtdAtual" value="${prod.qtdAtual}"/>
                        <input type="hidden" name="nome" value="${prod.nome}"/>
                        <label>QUANTIDADE A RETIRAR: </label>
                        <input type="text" name="qtdRetirar"/>
                    </div>
                    <div class="botoes">
                        <button class="botoesazul" type="Submit">Retirar</button>
                    </div>
                </fieldset>
            </form>

            <form method="POST" action="ReporProdutoServlet">
                <fieldset>
                    <legend>REPOR PRODUTO</legend>
                    <div>
                        <input type="hidden"  value="${prod.codigoBarra}" name="codigoBarra" maxlength="25"/> 
                        <input type="hidden" name="qtdAtual" value="${prod.qtdAtual}"/>
                        <input type="hidden" name="nome" value="${prod.nome}"/>
                        <label>QUANTIDADE A REPOR </label>
                        <input type="text" name="qtdRepor"/>
                    </div>
                    <div class="botoes">
                        <button class="botoesazul" type="Submit">Repor</button>
                    </div>
                </fieldset>
            </form>
        </div>

    </body>
</html>
