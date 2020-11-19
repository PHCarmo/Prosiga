package br.com.fatecmc.prosiga.model.domain;

public class Aluno extends EntidadeDominio {
    private String nome;
    private String ra;
    private Turma turma;

    public Aluno() {
        super(0);
        this.nome = "";
        this.ra = "";
        this.turma = new Turma();
    }
    
    public Aluno(String nome, String ra, Turma turma) {
        this.nome = nome;
        this.ra = ra;
        this.turma = turma;
    }

    public Aluno(String nome, String ra, Turma turma, int id) {
        super(id);
        this.nome = nome;
        this.ra = ra;
        this.turma = turma;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
    
}
