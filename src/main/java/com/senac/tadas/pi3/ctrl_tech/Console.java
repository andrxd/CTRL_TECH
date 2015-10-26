package com.senac.tadas.pi3.ctrl_tech;

//package com.senac.tadas.pi3.ctrl_tech.java;


//import com.senac.tadas.pi3.ctrl_tech.java.Produto;

public class Console extends Produto{

    public float getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(float armazenamento) {
        this.armazenamento = armazenamento;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

	private float armazenamento;	

	private Jogo jogo;

    public Console(float armazenamento, Jogo jogo, String codigoBarra, String nome, String descricao, float valor, String usuario, int qtdAtual, int qtdMinima, int qtdMaxima, String fabricante, String garantia) {
        super(codigoBarra, nome, descricao, valor, usuario, qtdAtual, qtdMinima, qtdMaxima, fabricante, garantia);
        this.armazenamento = armazenamento;
        this.jogo = jogo;
    }
        
        
	

}
