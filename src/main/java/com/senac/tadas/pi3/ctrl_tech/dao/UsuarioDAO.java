/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.dao;

import com.senac.tadas.pi3.ctrl_tech.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends CommonDAO {

    public boolean autenticar(String email, String senha) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select EMAIL,SENHA from USUARIO\n"
                + "WHERE EMAIL = '" + email
                + "' AND  SENHA = '" + senha + "' ";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);
               
            
            while (resultados.next()) {
                String emailBanco = resultados.getString("email");
                String senhaBanco = resultados.getString("senha");
                
                if (senhaBanco.equals(senha)) {
                    return true;
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }
    
    public Usuario buscarUsuario(String email, String senha) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from USUARIO\n"
                + "WHERE EMAIL = '" + email
                + "' AND  SENHA = '" + senha + "' ";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);
               
            
            while (resultados.next()) {
                String emailBanco = resultados.getString("email");
                String senhaBanco = resultados.getString("senha");
                String filialBanco = resultados.getString("filial");
                String nomeCompleto = resultados.getString("nomeCompleto");
                String rgBanco = resultados.getString("rg");
                String cargoBanco = resultados.getString("cargo");
                String tipoUsuarioBanco = resultados.getString("TipoUsuario");
                
                
                if (senhaBanco.equals(senha)) {
                    Usuario User = new Usuario(emailBanco, senhaBanco, nomeCompleto, tipoUsuarioBanco, filialBanco);
                    return User;
                }
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }
    
}
