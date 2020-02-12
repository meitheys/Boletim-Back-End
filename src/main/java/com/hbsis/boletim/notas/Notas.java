package com.hbsis.boletim.notas;

import com.hbsis.boletim.aluno.Aluno;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nota")
    private double nota;
    @ManyToOne
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    @Column(name = "disciplina")
    private String disciplina;
    @Column(name = "trimestre")
    private String trimestre;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
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
        return "Notas{" +
                "id=" + id +
                ", nota=" + nota +
                ", aluno=" + aluno +
                ", disciplina='" + disciplina + '\'' +
                ", trimestre=" + trimestre +
                '}';
    }
}
