package com.senac.tadas.pi3.ctrl_tech.servlet;


import com.senac.tadas.pi3.ctrl_tech.Produto;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import com.senac.tadas.pi3.ctrl_tech.dao.ProdutoDAO;
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
@WebServlet(name = "ListarProdutosServlet", urlPatterns = {"/ListarProdutosServlet"})
public class ListarProdutosServlet extends HttpServlet {

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

      ProdutoDAO dao = new ProdutoDAO();
    List<Produto> lista= dao.buscarTodos();

    request.setAttribute("lista", lista);
    RequestDispatcher rd = request.getRequestDispatcher("/listarproduto.jsp");
    rd.forward(request, response);
  }
}
