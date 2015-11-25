/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Produto;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.ProdutoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ReporProdutoServlet", urlPatterns = {"/ReporProdutoServlet"})
public class ReporProdutoServlet extends HttpServlet {

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

        ProdutoDAO dao = new ProdutoDAO();
        Produto prod = new Produto();

        String codBarra = request.getParameter("codigoBarra");
        int qtdAtual = Integer.parseInt(request.getParameter("qtdAtual"));
        int qtdRepor = Integer.parseInt(request.getParameter("qtdRepor"));
        String nome = request.getParameter("nome");

        prod.setNome(nome);
        prod.setQtdAtual(qtdAtual);
        prod.setCodigoBarra(codBarra);
        
        
         HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sessao = httpRequest.getSession();
        
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        
        qtdAtual += qtdRepor;
        try {
            dao.alterarQuantidade(qtdAtual, codBarra);
            dao.registrar(usuario, prod, qtdRepor, "REPOSICAO");
            request.setAttribute("prod", prod);           
            
        } catch (SQLException ex) {
            Logger.getLogger(ReporProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReporProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/retirarReporProduto.jsp");
        rd.forward(request, response);
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
