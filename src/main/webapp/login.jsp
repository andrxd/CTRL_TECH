<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Login</title>
    <meta charset="UTF-8">    
  </head>
  <body>
    <h1>Login</h1>
    <div>
      <form action="Login" method="post" accept-charset="UTF-8" enctype="application/x-www-form-urlencoded">
        <p><label>Nome de usuário:</label><input type="text" name="nome" /></p>
        <p><label>Senha:</label><input type="password" name="senha" /></p>
        <p><input type="submit" value="Entrar" /></p>
      </form>
    </div>
  </body>
</html>
