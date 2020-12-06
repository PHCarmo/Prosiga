package br.com.fatecmc.prossiga.model.domain;

public class Professor extends EntidadeDominio {
    private String nome;
    private String titulacao;
    private int id;
    
    public Professor() {
        super(0);
        this.nome = "";
        this.titulacao = "";
    }
    
    public Professor(String nome, String titulacao) {
        this.nome = nome;
        this.titulacao = titulacao;
    }
    
    public Professor(int id, String nome, String titulacao) {
    	this.id= id;
    	this.nome = nome;
        this.titulacao = titulacao;
    }

    public Professor(String nome, String titulacao, int id) {
        super(id);
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
