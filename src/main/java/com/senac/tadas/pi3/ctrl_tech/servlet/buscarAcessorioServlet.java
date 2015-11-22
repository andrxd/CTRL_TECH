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
@WebServlet(name = "buscarAcessorioServlet", urlPatterns = {"/buscarAcessorioServlet"})
public class buscarAcessorioServlet extends HttpServlet {

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

        AcessorioDAO dao = new AcessorioDAO();
        Acessorio prod = new Acessorio();       
        
        request.getParameter("busca");
        
        String busca = request.getParameter("busca");
        
        
        prod = dao.buscarAcessorio(busca);
        
        String email = busca;             
        
        AcessorioDAO das = new AcessorioDAO();    
        //das.incluir(prod);
        request.setAttribute("prod", prod);       
        //request.setAttribute("email", email);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/editaracessorio.jsp");
        rd.forward(request, response);
    }
}
