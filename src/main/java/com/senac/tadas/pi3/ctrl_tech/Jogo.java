package com.senac.tadas.pi3.ctrl_tech;

public class Jogo extends Produto {

    private String genero;

    private int faixaEtaria;

    public Jogo(String genero, int faixaEtaria, String codigoBarra, String nome, String descricao, float valor, String usuario, int qtdAtual, int qtdMinima, int qtdMaxima, String fabricante, String garantia) {
        super(codigoBarra, nome, descricao, valor, usuario, qtdAtual, qtdMinima, qtdMaxima, fabricante, garantia);
        this.genero = genero;
        this.faixaEtaria = faixaEtaria;
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

    
    
    
}
