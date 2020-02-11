package com.hbsis.boletim.turma;

import com.hbsis.boletim.escola.Escola;

import javax.persistence.*;

@Entity
@Table(name = "turmas")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "escola", referencedColumnName = "id")
    private Escola escola;
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

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", escola=" + escola +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                '}';
    }
}