/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "cadastrarUsuarioServlet", urlPatterns = {"/cadastrarUsuario"})
public class cadastrarUsuarioServlet extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/cadatrarUsuario.jsp");
        rd.forward(request, response);

    }

    /**
     * Salva os dados digitados e faz redirect para a lista (POST-REDIRECT-GET)
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nomeCompleto = request.getParameter("nome");
        //String dtNascimentoStr = request.getParameter("dtnascimento");
        String RG = request.getParameter("rg");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String filial = request.getParameter("filial");
        String cargo = request.getParameter("cargo");
        String tipoUsuario = request.getParameter("usuario");
        
      

        Usuario user = new Usuario(email, senha, nomeCompleto, tipoUsuario, filial, cargo, RG);

        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.incluir(user);
            response.sendRedirect("cadastrarUsuario");
        } catch (Exception e) {
            response.sendRedirect("cadastrarUsuario");
        }
    }
}
