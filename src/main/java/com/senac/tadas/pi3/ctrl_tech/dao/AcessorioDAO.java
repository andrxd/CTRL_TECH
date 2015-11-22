/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.dao;

import com.senac.tadas.pi3.ctrl_tech.Acessorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AcessorioDAO extends CommonDAO {

    public Acessorio buscarAcessorio(String codBarra) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from Produto\n"
                + "WHERE codBarra = '" + codBarra + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                String marca = resultados.getString("marca");
                String plataforma = resultados.getString("plataforma");
                String codigoBarra = resultados.getString("codBarra");
                String nome = resultados.getString("nome");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valor");
                int quantidadeAtual = resultados.getInt("quantidadeAtual");
                int quantidadeMinima = resultados.getInt("quantidadeMinima");
                int quantidadeMaxima = resultados.getInt("quantidadeMaxima");
                String tipo = resultados.getString("tipo");
                int status = resultados.getInt("status");

                Acessorio acessorio = new Acessorio(marca, plataforma, codigoBarra, nome, descricao, valor, quantidadeAtual, quantidadeMinima, quantidadeMaxima, tipo, status);
                return acessorio;

            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Acessorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Acessorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Acessorio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return null;
    }

    public void incluir(Acessorio p) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO PRODUTO ( marca, plataforma ,codBarra, nome, descricao, valor, QUANTIDADEAtual, QUANTIDADEMinima,QUANTIDADEMaxima,TIPO,STATUS \n"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getMarca());
            stmt.setString(2, p.getPlataforma());
            stmt.setString(3, p.getCodigoBarra());
            stmt.setString(4, p.getNome());
            stmt.setString(5, p.getDescricao());
            stmt.setDouble(6, p.getValor());
            stmt.setInt(7, p.getQtdAtual());
            stmt.setInt(8, p.getQtdMinima());
            stmt.setInt(9, p.getQtdMaxima());
            stmt.setString(10, p.getTipo());
            stmt.setInt(11, p.getStatus());
            stmt.executeUpdate();

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

    public void alterar(Acessorio acessorio) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE PRODUTO SET marca=?, plataforma=? , nome=?, descricao=?, valor=?, QUANTIDADEAtual=?, QUANTIDADEMinima=?,QUANTIDADEMaxima=?,STATUS=? WHERE CodBarra = ? ";

        Connection con = obterConexao();

        try {
            //constroi o PreparedStatement com o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, acessorio.getMarca());
            stmt.setString(2, acessorio.getPlataforma());            
            stmt.setString(3, acessorio.getNome());
            stmt.setString(4, acessorio.getDescricao());
            stmt.setDouble(5, acessorio.getValor());
            stmt.setInt(6, acessorio.getQtdAtual());
            stmt.setInt(7, acessorio.getQtdMinima());
            stmt.setInt(8, acessorio.getQtdMaxima());
            stmt.setInt(9, acessorio.getStatus());
            stmt.setString(10, acessorio.getCodigoBarra());

            stmt.execute();
            stmt.close();

            System.out.println("Produto Atualizado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
    }
}
