package com.hbsis.boletim.notas;

import org.springframework.beans.factory.annotation.Autowired;

public class NotasDTO {
    private long id;
    private double primeiraNota;
    private double segundaNota;
    private long aluno;
    private long disciplina;

    public NotasDTO() {
    }

    @Autowired
    public NotasDTO(long id, double primeiraNota, double segundaNota, long aluno, long disciplina) {
        this.id = id;
        this.aluno = aluno;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public static NotasDTO of(Notas notas) {
        return new NotasDTO(
                notas.getId(),
                notas.getPrimeiraNota(),
                notas.getSegundaNota(),
                notas.getAluno().getId(),
                notas.getDisciplina().getId()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(double primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(double segundaNota) {
        this.segundaNota = segundaNota;
    }

    public long getAluno() {
        return aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
    }

    public long getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(long disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "NotasDTO{" +
                "id=" + id +
                ", primeiraNota=" + primeiraNota +
                ", segundaNota=" + segundaNota +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                '}';
    }
}
