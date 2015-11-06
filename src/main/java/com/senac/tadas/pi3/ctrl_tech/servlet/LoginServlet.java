/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andre
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

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
        HttpSession sessao = request.getSession(false);
        if (sessao == null || sessao.getAttribute("usuario") == null) {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
            return;
        }
        response.sendRedirect("/");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailString = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        UsuarioDAO userDao = new UsuarioDAO();
        
        Usuario usuario = validar(emailString, senha);
        if (usuario != null) {
            HttpSession sessao = request.getSession(false);
            if (sessao != null) {
                // Força invalidação da sessão anterior.
                sessao.invalidate();
            }
            sessao = request.getSession(true);
            sessao.setAttribute("usuario", usuario);
            response.sendRedirect("telaPrincipal.html");
            return;
            // FIM CASO SUCESSO
        }
        response.sendRedirect("erroLogin.jsp");

    }

    private Usuario validar(String emailString, String senha) {
        
        UsuarioDAO userDao = new UsuarioDAO();
        
        Usuario usuario = userDao.buscarUsuario(emailString, senha);
        
        if (usuario != null && userDao.autenticar(emailString, senha)) {
            return usuario;
        }
        return null;
    }
}
