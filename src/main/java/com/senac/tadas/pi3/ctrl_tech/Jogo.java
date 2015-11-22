package com.senac.tadas.pi3.ctrl_tech;

public class Jogo extends Produto {

    private String genero;

    private int faixaEtaria;

    private String plataforma;

    public Jogo() {
    }

    
    public Jogo(String genero, int faixaEtaria, String plataforma, String codigoBarra, String nome, String descricao, double valor, int qtdAtual, int qtdMinima, int qtdMaxima, String tipo, int status) {
        super(codigoBarra, nome, descricao, valor, qtdAtual, qtdMinima, qtdMaxima, tipo, status);
        this.genero = genero;
        this.faixaEtaria = faixaEtaria;
        this.plataforma = plataforma;
    }

    public Jogo(String genero, String faixaetaria, String plataforma, String codigoBarra, String nome, String descricao, double valor, int quantidadeAtual, int quantidadeMinima, int quantidadeMaxima, String tipo, int status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(int faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    
    
    
    
    
}
