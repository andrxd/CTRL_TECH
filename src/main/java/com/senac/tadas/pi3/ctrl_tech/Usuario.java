package com.senac.tadas.pi3.ctrl_tech;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {

    private String email;

    private String senha;

    private String nomeCompleto;

    private String tipoUsuario;

    private String filial;

    private String cargo;

    private String rg;

  
    
    private int ativo;

    public Usuario(String email, String senha, String nomeCompleto, String tipoUsuario, String filial, String cargo, String rg) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.tipoUsuario = tipoUsuario;
        this.filial = filial;
        this.cargo = cargo;
        this.rg = rg;
    }
    public Usuario(String email, String senha, String nomeCompleto, String tipoUsuario, String filial, String cargo, String rg,int ativo) {
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.tipoUsuario = tipoUsuario;
        this.filial = filial;
        this.cargo = cargo;
        this.rg = rg;
        this.ativo = ativo;
    }
    
    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public boolean autenticar(String email, String senha) {
        if (this.email != null) {

        }
        return false;
    }

    public boolean autorizar(String permissaoNecessaria) {
        return this.tipoUsuario.equals(permissaoNecessaria);
    }

}
