package com.hbsis.boletim.turma;

public class TurmaDTO {
    private long id;
    private String alunos;
    private String numeroTurma;
    private String periodo;

    public TurmaDTO(){}

    public TurmaDTO(long id, String alunos, String numeroTurma, String periodo) {
        this.id = id;
        this.alunos = alunos;
        this.numeroTurma = numeroTurma;
        this.periodo = periodo;
    }

    public static TurmaDTO of(Turma turma) {
        return new TurmaDTO(
                turma.getId(),
                turma.getAlunos(),
                turma.getNumeroTurma(),
                turma.getPeriodo()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlunos() {
        return alunos;
    }

    public void setAlunos(String alunos) {
        this.alunos = alunos;
    }

    public String getNumeroTurma() {
        return numeroTurma;
    }

    public void setNumeroTurma(String numeroTurma) {
        this.numeroTurma = numeroTurma;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", alunos='" + alunos + '\'' +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}