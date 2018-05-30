/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unicarioca.apsweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Marco
 */
@WebServlet(name = "salvar", urlPatterns = {"/salvar.do"})
public class salvar extends HttpServlet {

    static List<Pessoa> lista = new ArrayList<Pessoa>();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //lê os dados
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        
        for (Pessoa p : salvar.lista){
            if(p.getNome().equals(nome)){
                p.setNome(nome);
                p.setEmail(email);
                p.setTelefone(telefone);
            }
        }
        
        //insere a lista na session
        request.getSession().setAttribute("listaPessoa", lista);
        System.out.println("add: " + nome);
        
        //redireciona para a pag
        RequestDispatcher rs = request.getRequestDispatcher("tabela.jsp");
        rs.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //lê os dados
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String telefone = request.getParameter("telefone");
        
        //instancia o objeto
        Pessoa pessoa = new Pessoa(nome, email, telefone);
        
        //add o objeto na lista
        lista.add(pessoa);
        
        //insere a lista na session
        request.getSession().setAttribute("listaPessoa", lista);
        System.out.println("add: " + nome);
        
        //redireciona para a pag
        RequestDispatcher rs = request.getRequestDispatcher("tabela.jsp");
        rs.forward(request, response);
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
