/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.servlet;

import com.senac.tadas.pi3.ctrl_tech.Jogo;
import com.senac.tadas.pi3.ctrl_tech.dao.JogoDAO;
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
@WebServlet(name = "buscarJogoServlet", urlPatterns = {"/buscarJogoServlet"})
public class buscarJogoServlet extends HttpServlet {

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

        JogoDAO dao = new JogoDAO();
        Jogo prod = new Jogo();

        request.getParameter("busca");

        String busca = request.getParameter("busca");

        prod = dao.buscarJogo(busca); 
        request.setAttribute("prod", prod);

        RequestDispatcher rd = request.getRequestDispatcher("/editarjogo.jsp");
        rd.forward(request, response);
    }

}