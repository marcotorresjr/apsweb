<%-- 
    Document   : cadastro
    Created on : 19/05/2018, 19:36:28
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <form action="salvar.do" method="post">
            Nome: <input type="text" name="nome" size="20"/>
            E-mail: <input type="text" name="email" size="20"/>
            Telefone: <input type="text" name="telefone" size="20"/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>
