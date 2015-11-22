/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.tadas.pi3.ctrl_tech.dao;

import com.senac.tadas.pi3.ctrl_tech.Acessorio;
import com.senac.tadas.pi3.ctrl_tech.Console;
import com.senac.tadas.pi3.ctrl_tech.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsoleDAO extends CommonDAO {

    public Console buscarConsole(String codBarra) {
        Statement stmt = null;
        Connection conn = null;

        String sql = "select * from Produto\n"
                + "WHERE codBarra = '" + codBarra + "'";

        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            while (resultados.next()) {
                String fabricante = resultados.getString("fabricante");
                String armazenamento = resultados.getString("armazenamento");
                String garantia = resultados.getString("garantia");
                String codigoBarra = resultados.getString("codBarra");
                String nome = resultados.getString("nome");
                String descricao = resultados.getString("descricao");
                double valor = resultados.getDouble("valor");
                int quantidadeAtual = resultados.getInt("quantidadeAtual");
                int quantidadeMinima = resultados.getInt("quantidadeMinima");
                int quantidadeMaxima = resultados.getInt("quantidadeMaxima");
                String tipo = resultados.getString("tipo");
                int status = resultados.getInt("status");

                Console console = new Console(fabricante, armazenamento, garantia, codigoBarra, nome, descricao, valor, quantidadeAtual, quantidadeMinima, quantidadeMaxima, tipo, status);
                return console;

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

    public void incluir(Console p) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO PRODUTO ( fabricante, armazenamento, garantia ,codBarra, nome, descricao, valor, QUANTIDADEAtual, QUANTIDADEMinima,QUANTIDADEMaxima,TIPO,STATUS"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = obterConexao();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getFabricanteString());
            stmt.setString(2, p.getArmazenamento());
            stmt.setString(3, p.getGarantia());
            stmt.setString(4, p.getCodigoBarra());
            stmt.setString(5, p.getNome());
            stmt.setString(6, p.getDescricao());
            stmt.setDouble(7, p.getValor());
            stmt.setInt(8, p.getQtdAtual());
            stmt.setInt(9, p.getQtdMinima());
            stmt.setInt(10, p.getQtdMaxima());
            stmt.setString(11, p.getTipo());
            stmt.setInt(12, p.getStatus());
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

    public void alterar(Console console) throws SQLException, ClassNotFoundException {

        String sql = "UPDATE PRODUTO SET fabricante=?, armazenamento=?, garantia=? , nome=?, descricao=?, valor=?, QUANTIDADEAtual=?, QUANTIDADEMinima=?,QUANTIDADEMaxima=?,STATUS=? WHERE CodBarra = ? ";

        Connection con = obterConexao();

        try {
            //constroi o PreparedStatement com o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, console.getFabricanteString());
            stmt.setString(2, console.getArmazenamento());
            stmt.setString(3, console.getGarantia());            
            stmt.setString(4, console.getNome());
            stmt.setString(5, console.getDescricao());
            stmt.setDouble(6, console.getValor());
            stmt.setInt(7, console.getQtdAtual());
            stmt.setInt(8, console.getQtdMinima());
            stmt.setInt(9, console.getQtdMaxima());            
            stmt.setInt(10, console.getStatus());
            stmt.setString(11, console.getCodigoBarra());

            stmt.execute();
            stmt.close();

            System.out.println("Produto Atualizado");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
