package com.hbsis.boletim.turma;

import com.hbsis.boletim.aluno.Aluno;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "numero_turma")
    private String numeroTurma;
    @Column(name = "periodo")
    private String periodo;

    /*
    @ManyToMany(targetEntity = Aluno.class)
    @JoinTable(name = "aluno_turma", joinColumns = {
            @JoinColumn(name = "id_turma", referencedColumnName = "id")},
    inverseJoinColumns = {
            @JoinColumn(name = "id_aluno", referencedColumnName = "id")})
            @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Aluno> alunos;
    */

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
        return "Turma{" +
                "id=" + id +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}