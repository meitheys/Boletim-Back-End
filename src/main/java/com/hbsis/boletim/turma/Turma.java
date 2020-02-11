package com.hbsis.boletim.turma;

import com.hbsis.boletim.professor.Professor;

import javax.persistence.*;

@Entity
@Table(name = "escolas")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "alunos")
    private String alunos;
    @Column(name = "numero_turma")
    private String numeroTurma;
    @Column(name = "periodo")
    private String periodo;

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
        return "Turma{" +
                "id=" + id +
                ", alunos='" + alunos + '\'' +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}
