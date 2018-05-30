package br.edu.unicarioca.apsweb;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        //verifica se login ou senha foram preenchidos
        if ( (login.length()==0) || (senha.length()==0) ) {
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
            System.out.println("Usuário deslogado acessando a página de login.");
        } else {
            HttpSession sessao;
            sessao = request.getSession();
            
            // verifica se a sessao existe, se nao cria uma nova
            if ( sessao == null) {
                sessao = request.getSession(true);
            }
            
            sessao.setAttribute("login", login);
            sessao.setAttribute("tempo", sessao.getCreationTime() / 1000);
            RequestDispatcher rs = request.getRequestDispatcher("tabela.jsp");
            rs.forward(request, response);
        }
        System.out.println("Usuário " + login + "acessando a página.");
    }

}
