<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Tabela</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>

        <script language="javascript">
            function confirmaRemover(nome) {
                if (confirm("Deseja remover o cliente " + nome + "?"))
                    location.href = "excluir.do?nome=" + nome;
            }

            function alterar(nome, email, telefone) {
                location.href = "alterar.jsp?nome=" + nome + "&email=" + email + "&telefone=" + telefone;
            }
        </script>


    </head>
    <body>


        <form action="cadastro.jsp" method="GET">
            <input type="submit" value="Cadastrar"/>
        </form>

        <c:if test="${listaPessoa != null}">
            <table class="table table-default">
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td>Email</td>
                        <td>Telefone</td>
                    </tr>
                </thead>
                <c:forEach items="${listaPessoa}" var="lista">
                    <tr>
                        <td><c:out value="${lista.nome}"></c:out></td>
                        <td><c:out value="${lista.email}"></c:out></td>
                        <td><c:out value="${lista.telefone}"></c:out></td>
                        <td><a href='javascript:alterar("${lista.nome}","${lista.email}","${lista.telefone}");'>Alterar</a></td>
                        <td><a href='javascript:confirmaRemover("${lista.nome}");'>Excluir</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
