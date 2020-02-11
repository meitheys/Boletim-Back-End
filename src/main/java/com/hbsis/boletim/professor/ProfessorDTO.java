package com.hbsis.boletim.professor;

public class ProfessorDTO {
    private long id;
    private String nome;
    private String codigoProfessor;
    private String disciplina;
    private String telefone;

    public ProfessorDTO(long id, String nome, String codigoProfessor, String disciplina, String telefone) {
        this.id = id;
        this.nome = nome;
        this.codigoProfessor = codigoProfessor;
        this.disciplina = disciplina;
        this.telefone = telefone;
    }

    public ProfessorDTO() { }

    public static ProfessorDTO of(Professor professor) {
        return new ProfessorDTO(
                professor.getId(),
                professor.getNome(),
                professor.getCodigoProfessor(),
                professor.getDisciplina(),
                professor.getTelefone()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(String codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "ProfessorDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", codigoProfessor='" + codigoProfessor + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
