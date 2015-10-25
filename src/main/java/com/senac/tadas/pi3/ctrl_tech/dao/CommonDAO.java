package com.senac.tadas.pi3.ctrl_tech.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CommonDAO {

        protected Connection obterConexao() throws SQLException, ClassNotFoundException {
            Connection conn = null;
            
            Class.forName("org.apache.derby.jdbc.ClientDataSource");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/app;SecurityMechanism=3",
                    "app", 
                    "app");
            return conn;
        }
    }