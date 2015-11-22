package com.senac.tadas.pi3.ctrl_tech;

public class Console extends Produto {

    private String fabricante;
    private String armazenamento;
    private String garantia;

    public Console() {
    }

    public Console(String fabricante, String armazenamento, String garantia, String codigoBarra, String nome, String descricao, double valor, int qtdAtual, int qtdMinima, int qtdMaxima, String tipo, int status) {
        super(codigoBarra, nome, descricao, valor, qtdAtual, qtdMinima, qtdMaxima, tipo, status);
        this.fabricante = fabricante;
        this.armazenamento = armazenamento;
        this.garantia = garantia;
    }
    
    public String getFabricanteString() {
        return fabricante;
    }

    public void setFabricanteString(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(String armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    
}
