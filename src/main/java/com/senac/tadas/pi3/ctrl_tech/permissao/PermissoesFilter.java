/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.permissao;

import com.senac.tadas.pi3.ctrl_tech.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andre
 */
@WebFilter(filterName = "PermissoesFilter", servletNames = {"cadastrarUsuario"}, urlPatterns = {"/cadastrarUsuario.jsp"})
public class PermissoesFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

    // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
        // A) CAST DOS PARÂMETROS RECEBIDOS
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // B) TENTA RECUPERAR A SESSÃO DO USUÁRIO
        HttpSession sessao = httpRequest.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");

        // 2) NA LÓGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUÁRIO SIGNIFICA
        //    QUE USUÁRIO ESTÁ LOGADO
        //    CASO CONTRÁRIO, REDIRECIONA PARA TELA DE LOGIN
        if (usuario == null) {
            httpResponse.sendRedirect("Login");
            return;
        }

        try {
            // 3) VERIFICAR SE USUARIO PODE ACESSAR PAGINA
            if (verificarAcesso(usuario, httpRequest, httpResponse)) {
                // CHAMADA QUE ENVIA A REQUISIÇÃO PARA O PRÓXIMO FILTRO OU SERVLET
                chain.doFilter(request, response);
            } else {
                // SE NAO PODER ACESSAR, APRESENTA ERRO
                httpResponse.sendRedirect("erroNaoAutorizado.jsp");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * Método que verifica se o usuário possui o(s) papel(is) necessário(s) para
     * acessar a funcionalidade
     *
     * @param usuario
     * @param req
     * @param resp
     * @return
     */
    private static boolean verificarAcesso(Usuario usuario, HttpServletRequest req, HttpServletResponse resp) {
        String pagina = req.getRequestURI();
        if (pagina.endsWith("/ADMIN/cadastrarUsuario.jsp") && usuario.autorizar("COMUM")) {
            return true;
        } else if (pagina.endsWith("cadastrarUsuario.jsp") && usuario.autorizar("ADMIN")) {
            return true;
        }
        return false;
    }

    /**
     * ROTINA PARA DESTRUIÇÃO DO FILTRO
     */
    @Override
    public void destroy() {
    }

    /**
     * ROTINA DE INICIALIZAÇÃO DO FILTRO
     */
    @Override
    public void init(FilterConfig filterConfig) {

    }
}
