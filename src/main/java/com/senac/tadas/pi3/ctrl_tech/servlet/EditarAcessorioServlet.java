/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Acessorio;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.AcessorioDAO;
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
@WebServlet(name = "EditarUsuarioServlet", urlPatterns = {"/EditarAcessorioServlet"})
public class EditarAcessorioServlet extends HttpServlet {

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

        String codBarra = request.getParameter("codigoBarra");
        //String dtNascimentoStr = request.getParameter("dtnascimento");
        String nome = request.getParameter("nome");
        String marca = request.getParameter("marca");
        String plataforma = request.getParameter("plataforma");
        String val = request.getParameter("valor");        
        String qtd = request.getParameter("qtdAtual");        
        String status = request.getParameter("status");
        String descricao = request.getParameter("descricao");
        
        //Object ema = request.getAttribute("emailUsuario");
        double valor = Double.parseDouble(val);
        int qtdAtual = Integer.parseInt(qtd);
        int stat = Integer.parseInt(status);        
        Acessorio access = new Acessorio(marca, plataforma, codBarra, nome, descricao, valor, qtdAtual, qtdAtual, qtdAtual, "ACESSORIO", stat);

        try {
            AcessorioDAO dao = new AcessorioDAO();
            dao.alterar(access);
            System.out.println("Sucesso");
            
            response.sendRedirect("editaracessorio.jsp");
            
        } catch (Exception e) {
            response.sendRedirect("editaracessorio.jsp");
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
