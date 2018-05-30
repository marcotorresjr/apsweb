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
        
        <%
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
        %>
        
        <form action="salvar.do" method="get">
            Nome: <input type="text" name="nome" size="20" value="<%=nome%>"/>
            E-mail: <input type="text" name="email" size="20" value="<%=email%>"/>
            Telefone: <input type="text" name="telefone" value="<%=telefone%>" size="20"/>
            <input type="submit" value="Cadastrar"/>
        </form>
    </body>
</html>
