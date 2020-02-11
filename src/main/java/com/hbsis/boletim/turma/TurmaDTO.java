package com.hbsis.boletim.turma;

public class TurmaDTO {
    private long id;
    private long escola;
    private String numeroTurma;
    private String periodo;

    public TurmaDTO(){}

    public TurmaDTO(long id, long escola, String numeroTurma, String periodo) {
        this.id = id;
        this.escola = escola;
        this.numeroTurma = numeroTurma;
        this.periodo = periodo;
    }

    public static TurmaDTO of(Turma turma) {
        return new TurmaDTO(
                turma.getId(),
                turma.getEscola().getId(),
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

    public long getEscola() {
        return escola;
    }

    public void setEscola(long escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", escola=" + escola +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}