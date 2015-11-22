/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Produto;
import com.senac.tadas.pi3.ctrl_tech.Acessorio;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.AcessorioDAO;
import com.senac.tadas.pi3.ctrl_tech.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "buscarUsuarioServlet", urlPatterns = {"/buscarUsuarioServlet"})
public class buscarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = new Usuario();
 
        Acessorio acess =  new Acessorio();
        
        request.getParameter("emailBusca");
        
        String emailUsuario = request.getParameter("emailBusca");
        
        
        user = dao.buscarUsuario(emailUsuario);
        
        String email = emailUsuario;
        
       
        
        AcessorioDAO das = new AcessorioDAO();
        
        acess = das.buscarAcessorio("1234");
        
        acess = new Acessorio("DSAD", "DASDAD", "DASDASDAS",  "DASDAS", email, 1.2, 1, 54, 200, "dasdas", 1);
        
        
        System.out.println("Teste");
        
        das.incluir(acess);
        request.setAttribute("user", user);
        request.setAttribute("emailUsuario", emailUsuario);
        //request.setAttribute("email", email);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/editarAtivarDesativarUsuario.jsp");
        rd.forward(request, response);
    }

}
