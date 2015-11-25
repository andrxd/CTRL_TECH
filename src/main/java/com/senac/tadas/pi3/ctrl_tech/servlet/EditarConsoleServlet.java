/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Console;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.ConsoleDAO;
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
@WebServlet(name = "EditarConsoleServlet", urlPatterns = {"/EditarConsoleServlet"})
public class EditarConsoleServlet extends HttpServlet {

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
        String val = request.getParameter("valor");  
        String fabricante = request.getParameter("fabricante");
        String garantia = request.getParameter("garantia");        
        String armazenamento = request.getParameter("armazenamento");    
        String qtd = request.getParameter("qtdAtual");        
        String status = request.getParameter("status");
        String descricao = request.getParameter("descricao");
        
        //Object ema = request.getAttribute("emailUsuario");
        double valor = Double.parseDouble(val);
        int qtdAtual = Integer.parseInt(qtd);
        int stat = Integer.parseInt(status);    
        
        Console console = new Console(fabricante, armazenamento, garantia, codBarra, nome, descricao, valor, qtdAtual, qtdAtual, qtdAtual, "CONSOLE", stat);

        try {
            ConsoleDAO dao = new ConsoleDAO();
            dao.alterar(console);
            System.out.println("Sucesso");
            
            response.sendRedirect("editarconsole.jsp");
            
        } catch (Exception e) {
            response.sendRedirect("editarconsole.jsp");
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
