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
                user.setQtdAtual( resultadoSelect.getInt("QUANTIDADEAtual"));
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

    public ProdutoDAO() {
    }

 
}
