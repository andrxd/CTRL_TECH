package com.senac.tadas.pi3.ctrl_tech.servlet;


import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author André
 */
@WebServlet(name = "ListarUsuariosServlet", urlPatterns = {"/ListarUsuariosServlet"})
public class ListarUsuariosServlet extends HttpServlet {

  /**
   * Busca e apresenta na tela os contatos cadastrados no sistema
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
    List<Usuario> listaUsuarios = dao.buscarTodos();

    request.setAttribute("usuarios", listaUsuarios);
    RequestDispatcher rd = request.getRequestDispatcher("/listaUsuarios.jsp");
    rd.forward(request, response);
  }
}
