package com.senac.tadas.pi3.ctrl_tech;

//package com.senac.tadas.pi3.ctrl_tech;
public class Produto {

    public Produto(String codigoBarra, String nome, String descricao, float valor, String usuario, int qtdAtual, int qtdMinima, int qtdMaxima, String fabricante, String garantia) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.usuario = usuario;
        this.qtdAtual = qtdAtual;
        this.qtdMinima = qtdMinima;
        this.qtdMaxima = qtdMaxima;
        this.fabricante = fabricante;
        this.garantia = garantia;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getQtdAtual() {
        return qtdAtual;
    }

    public void setQtdAtual(int qtdAtual) {
        this.qtdAtual = qtdAtual;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    private String codigoBarra;

    private String nome;

    private String descricao;

    private float valor;

    private String usuario;

    private int qtdAtual;

    private int qtdMinima;

    private int qtdMaxima;

    private String fabricante;

    private String garantia;

}
