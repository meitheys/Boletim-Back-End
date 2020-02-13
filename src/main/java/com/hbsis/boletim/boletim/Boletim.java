package com.hbsis.boletim.boletim;

import com.hbsis.boletim.aluno.Aluno;
import com.hbsis.boletim.turma.Turma;
import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;

@Entity
@Table(name = "boletim")
public class Boletim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @JoinColumn(name = "aluno")
    private Aluno aluno;
    @JoinColumn(name = "Matéria")
    private Turma materia;
    @Column(name = "media")
    private double media;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getMateria() {
        return materia;
    }

    public void setMateria(Turma materia) {
        this.materia = materia;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "Boletim{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", materia=" + materia +
                ", media=" + media +
                '}';
    }
}
