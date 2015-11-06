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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/EditarUsuarioServlet"})
public class EditarUsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Handles the HTTP <code>POST</code> method.
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
        String email1 = request.getParameter("email");
        String email2 = request.getParameter("em");        
        String senha = request.getParameter("senha");
        String filial = request.getParameter("filial");
        String cargo = request.getParameter("cargo");
        String tipoUsuario = request.getParameter("tipoUsuario");
        String status = request.getParameter("status"); 
        //Object ema = request.getAttribute("emailUsuario");
        int stat = Integer.parseInt(status);
        System.out.println(email1);
        Usuario user = new Usuario(email, senha, nomeCompleto, tipoUsuario, filial, cargo, RG, stat);

        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.alterar(user);
            System.out.println("Sucesso");
            
            response.sendRedirect("editarAtivarDesativarUsuario.jsp");
            
        } catch (Exception e) {
            response.sendRedirect("cadastrarUsuario");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
