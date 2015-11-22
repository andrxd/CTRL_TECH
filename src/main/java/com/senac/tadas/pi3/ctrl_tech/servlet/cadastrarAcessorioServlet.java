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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andre
 */
@WebServlet(name = "cadastrarAcessorioServlet", urlPatterns = {"/cadastrarAcessorioServlet"})
public class cadastrarAcessorioServlet extends HttpServlet {

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
        //RequestDispatcher rd = request.getRequestDispatcher("/cadatrarUsuario.jsp");
        //rd.forward(request, response);

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

        String marca = request.getParameter("marca");
        String plataforma = request.getParameter("plataforma");
        String codbarra = request.getParameter("codbarra");        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        String valor = request.getParameter("valor");
        String quantidade = request.getParameter("quantidade");
        String status = request.getParameter("status");

        Acessorio acessorio = new Acessorio(marca, plataforma, codbarra, nome, descricao, Double.parseDouble(valor), Integer.parseInt(quantidade), Integer.parseInt(quantidade), Integer.parseInt(quantidade), "Acessorio", Integer.parseInt(status));
        try {
            AcessorioDAO dao = new AcessorioDAO();
            dao.incluir(acessorio);
            response.sendRedirect("cadastrarAcessorio.jsp");
        } catch (Exception e) {
            response.sendRedirect("cadastrarAcessorio.jsp");
        }
    }
}
