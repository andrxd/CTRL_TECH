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
        <title>Painel de Controle Administrador</title>
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
            <br/>

            <form id="cadastroUsuario">
                <fieldset>
                    <div class="botoes">
                        <label><b>CADASTRAR / REPOR PRODUTO</b></label> 
                        <button class="botoespadrao" type="button">INSERIR</button>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="botoes">
                        <label><b>CONSULTAR ESTOQUE</b></label> 
                        <button class="botoespadrao" type="button">CONSULTAR</button>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="botoes">
                        <label><b>VENDER PRODUTO</b></label> 
                        <button class="botoespadrao" type="button">VENDER</button>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="botoes">
                        <label><b>EDITAR PRODUTO</b></label> 
                        <button class="botoespadrao" type="button">EDITAR</button>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="botoes">
                        <label><b>CONSULTAR RELATÃRIO</b></label> 
                        <button class="botoespadrao" type="button">CONSULTAR</button>
                    </div>
                </fieldset>

                <fieldset>
                    <div class="botoes">
                        <label><b>ATIVAR / DESATIVAR PRODUTO</b></label> 
                        <button class="botoespadrao" type="button">ATIVAR e DESATIVAR</button>
                    </div>
                </fieldset>



                <div class="botoes">
                    <button class="botoesazul" type="button">Salvar</button>
                    <button class="botoesvermelho" type="button">Limpar</button>
                    <button class="botoeslaranja" type="button">Voltar</button>
                </div>
            </form>

        </div>
    </body>
</html>
