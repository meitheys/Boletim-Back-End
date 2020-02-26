package com.hbsis.boletim.turma;

import com.hbsis.boletim.aluno.Aluno;

import java.util.ArrayList;
import java.util.List;

public class TurmaDTO {
    private long id;
    private String numeroTurma;
    private String periodo;

    public TurmaDTO(){}

    public TurmaDTO(long id, String numeroTurma, String periodo) {
        this.id = id;
        this.numeroTurma = numeroTurma;
        this.periodo = periodo;
    }

    public static TurmaDTO of(Turma turma) {


       /* List<Aluno> aluno = new ArrayList<>();
        for(int i=0; i>turma.getAlunos().size(); i++){
            aluno.add(turma.getAlunos().get(i));
        }*/

        return new TurmaDTO(
                turma.getId(),
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

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}