package com.senac.tadas.pi3.ctrl_tech;

//package com.senac.tadas.pi3.ctrl_tech.java;
//import com.senac.tadas.pi3.ctrl_tech.java.Produto;
public class Acessorio extends Produto {
    private String marca;
    private String plataforma;

    public Acessorio(String marca, String plataforma, String codigoBarra, String nome, String descricao, double valor, int qtdAtual, int qtdMinima, int qtdMaxima, String tipo, int status) {
        super(codigoBarra, nome, descricao, valor, qtdAtual, qtdMinima, qtdMaxima, tipo, status);
        this.marca = marca;
        this.plataforma = plataforma;
    }

    public Acessorio() {
    }

    public Acessorio(String marca, String plataforma) {
        this.marca = marca;
        this.plataforma = plataforma;
    }


    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
    
    
}
