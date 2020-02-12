package com.hbsis.boletim.notas;

import java.time.LocalDate;

public class NotasDTO {
    private long id;
    private long aluno;
    private double nota;
    private String disciplina;
    private String trimestre;

    public NotasDTO() {
    }

    public NotasDTO(long id, long aluno, double nota, String disciplina, String trimestre) {
        this.id = id;
        this.aluno = aluno;
        this.nota = nota;
        this.trimestre = trimestre;
    }

    public static NotasDTO of(Notas notas) {
        return new NotasDTO(
                notas.getId(),
                notas.getAluno().getId(),
                notas.getNota(),
                notas.getDisciplina(),
                notas.getTrimestre()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAluno() {
        return aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    @Override
    public String toString() {
        return "NotasDTO{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", nota=" + nota +
                ", disciplina='" + disciplina + '\'' +
                ", trimestre=" + trimestre +
                '}';
    }
}
