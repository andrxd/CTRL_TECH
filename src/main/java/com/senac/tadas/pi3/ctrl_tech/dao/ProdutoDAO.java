/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.dao;

import com.senac.tadas.pi3.ctrl_tech.Produto;
import com.senac.tadas.pi3.ctrl_tech.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO extends CommonDAO {

    public List<Produto> buscarTodos() {
        // monta SQL 
        String sql = "SELECT * FROM PRODUTO WHERE STATUS=1";
        Connection conn = null;
        // cria lista
        List<Produto> lista = new ArrayList<>();
        try {
            conn = obterConexao();
            //constroi o PreparedStatement com o SQL
            PreparedStatement sqlcommandos = conn.prepareStatement(sql);

            ResultSet resultadoSelect = sqlcommandos.executeQuery();

            while (resultadoSelect.next()) {
                Produto user = new Produto();
                user.setCodigoBarra(resultadoSelect.getString("CodBarra"));
                user.setNome(resultadoSelect.getString("Nome"));
                user.setDescricao(resultadoSelect.getString("Descricao"));
                user.setQtdAtual(resultadoSelect.getInt("QUANTIDADEAtual"));
                user.setTipo(resultadoSelect.getString("Tipo"));
                user.setValor((float) (resultadoSelect.getDouble("VALOR")));

                //adciona o objeto usuario que foi criado com os dados do banco pra vetor de obetos
                lista.add(user);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

    public Produto buscarProduto(String codBarra) {
        Produto prod = new Produto();

        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from Produto\n"
                + "WHERE STATUS = 1 AND codBarra = '" + codBarra + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                codBarra = resultados.getString("codBarra");
                String nome = resultados.getString("nome");
                int quantidadeAtual = resultados.getInt("quantidadeAtual");

                prod.setCodigoBarra(codBarra);
                prod.setNome(nome);
                prod.setQtdAtual(quantidadeAtual);

                return prod;

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public void alterarQuantidade(int quantidade, String codBarra) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE PRODUTO SET QUANTIDADEAtual=? WHERE CodBarra = ? ";

        Connection con = obterConexao();

        try {
            //constroi o PreparedStatement com o SQL
            PreparedStatement stmt = con.prepareStatement(sql);          
           
            stmt.setInt(1, quantidade);          
            stmt.setString(2, codBarra);
            
            
            stmt.execute();
            stmt.close();

            System.out.println("Produto Atualizado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void registrar(Usuario u, Produto p,int quantidade, String acao) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO RELATORIO (DATA,NOMEDOUSUARIO,EMAILDOUSUARIO,FILIAL,CODIGOPRODUTO,NOMEDOPRODUTO,QUANTIDADE,ACAO) VALUES (CURRENT_TIMESTAMP,?,?,?,?,?,?,?)\n";


        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, u.getNomeCompleto());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getFilial());
            stmt.setString(4, p.getCodigoBarra());
            stmt.setString(5, p.getNome());
            stmt.setInt(6, quantidade);
            stmt.setString(7, acao);
            stmt.execute();
           

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public ProdutoDAO() {
    }

}
