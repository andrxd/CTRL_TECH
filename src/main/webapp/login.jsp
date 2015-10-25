<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Login</title>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
    </head>


    <body>

        <div id="banner" align="center" >
            <img src = "imagem/banner.png" width="800" height="200" >

        </div>

        <form method="post" action="Login" class="login">
            <p>
                <label for="login">Email:</label>
                <input type="text" name="login" id="login">
            </p>
            <p>
                <label for="senha">Senha:</label>
                <input type="password" name="senha" id="senha" >
            </p>
            <p class="login-submit">
                <button type="submit" class="login-button">Login</button>
            </p>
        </form>
    </body>
</html>

</html>
