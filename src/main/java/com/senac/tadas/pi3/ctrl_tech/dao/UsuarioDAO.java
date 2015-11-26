/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.dao;

import com.senac.tadas.pi3.ctrl_tech.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO extends CommonDAO {

    public boolean autenticar(String email, String senha) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select EMAIL,SENHA from USUARIO\n"
                + "WHERE UPPER(EMAIL) = UPPER('" + email
                + "') AND  SENHA = '" + senha + "' AND ATIVO = 1 ";

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
                + "WHERE UPPER(EMAIL) = UPPER('" + email
                + "') AND  SENHA = '" + senha + "' AND ATIVO = 1";

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
                    Usuario User = new Usuario(emailBanco, senhaBanco, nomeCompleto, tipoUsuarioBanco, filialBanco, cargoBanco, rgBanco);
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

    public Usuario buscarUsuario(String email) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from USUARIO\n"
                + "WHERE UPPER(EMAIL) = UPPER('" + email + "')";

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
                int ativo = resultados.getInt("Ativo");
                if (emailBanco!=null) {
                    Usuario User = new Usuario(emailBanco, senhaBanco, nomeCompleto, tipoUsuarioBanco, filialBanco, cargoBanco, rgBanco, ativo);
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

    public List<Usuario> buscarTodos() {
        // monta SQL 
        String sql = "SELECT * FROM USUARIO WHERE ATIVO=1";
        Connection conn = null;
        // cria lista
        List<Usuario> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            //constroi o PreparedStatement com o SQL
            PreparedStatement sqlcommandos = conn.prepareStatement(sql);

            ResultSet resultadoSelect = sqlcommandos.executeQuery();

            while (resultadoSelect.next()) {
                Usuario user = new Usuario();
                user.setEmail(resultadoSelect.getString("email"));
                user.setSenha(resultadoSelect.getString("senha"));
                user.setFilial(resultadoSelect.getString("filial"));
                user.setNomeCompleto(resultadoSelect.getString("nomeCompleto"));
                user.setRg(resultadoSelect.getString("rg"));
                user.setCargo(resultadoSelect.getString("cargo"));
                user.setTipoUsuario(resultadoSelect.getString("TipoUsuario"));;
                user.setAtivo(1);

                //adciona o objeto usuario que foi criado com os dados do banco pra vetor de obetos
                lista.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lista;

    }

    public void incluir(Usuario p) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO USUARIO (EMAIL, SENHA, " // ESPACO ANTES DO "
                + "NOMECOMPLETO, RG, FILIAL, CARGO, TIPOUSUARIO,ATIVO) VALUES (?, ?, ?, ?, ?, ?, ?,1)";
        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getEmail());
            stmt.setString(2, p.getSenha());
            stmt.setString(3, p.getNomeCompleto());
            stmt.setString(4, p.getRg());
            stmt.setString(5, p.getFilial());
            stmt.setString(6, p.getCargo());
            stmt.setString(7, p.getTipoUsuario());
            stmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void alterar(Usuario usuario) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE USUARIO SET SENHA=?,NomeCompleto=?,RG=?,FILIAL=?,CARGO=?,TIPOUSUARIO=?,ATIVO=? WHERE EMAIL = ? ";

        Connection con = obterConexao();

        try {
            //constroi o PreparedStatement com o SQL
            PreparedStatement sqlcommandos = con.prepareStatement(sql);
            sqlcommandos.setString(1, usuario.getSenha());
            sqlcommandos.setString(2, usuario.getNomeCompleto());
            sqlcommandos.setString(3, usuario.getRg());
            sqlcommandos.setString(4, usuario.getFilial());
            sqlcommandos.setString(5, usuario.getCargo());
            sqlcommandos.setString(6, usuario.getTipoUsuario());
            sqlcommandos.setInt(7, usuario.getAtivo());
            sqlcommandos.setString(8, usuario.getEmail());

            sqlcommandos.execute();
            sqlcommandos.close();

            System.out.println("usuario atualizado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
