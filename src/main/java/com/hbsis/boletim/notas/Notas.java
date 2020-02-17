package com.hbsis.boletim.notas;

import com.hbsis.boletim.aluno.Aluno;
import com.hbsis.boletim.disciplinas.Disciplina;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "notas")
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nota_um")
    private Double primeiraNota;
    @Column(name = "nota_dois")
    private Double segundaNota;
    @Column(name = "media")
    private double media;
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name = "disciplina", referencedColumnName = "id")
    private Disciplina disciplina;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getPrimeiraNota() {
        return primeiraNota;
    }

    public void setPrimeiraNota(Double primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public Double getSegundaNota() {
        return segundaNota;
    }

    public void setSegundaNota(Double segundaNota) {
        this.segundaNota = segundaNota;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return "Notas{" +
                "id=" + id +
                ", primeiraNota=" + primeiraNota +
                ", segundaNota=" + segundaNota +
                ", media=" + media +
                ", aluno=" + aluno +
                ", disciplina=" + disciplina +
                '}';
    }
}
