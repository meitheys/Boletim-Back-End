package com.hbsis.boletim.ligaçãoAlunoTurma;

import com.hbsis.boletim.aluno.Aluno;
import com.hbsis.boletim.turma.Turma;

import javax.persistence.*;

@Entity
@Table(name = "aluno_turma")
public class AlunoTurma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno idAluno;
    @ManyToOne
    @JoinColumn(name = "id_turma", referencedColumnName = "numero_turma")
    private Turma idTurma;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Aluno getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Aluno idAluno) {
        this.idAluno = idAluno;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return "AlunoTurma{" +
                "id=" + id +
                ", idAluno=" + idAluno +
                ", idTurma=" + idTurma +
                '}';
    }
}