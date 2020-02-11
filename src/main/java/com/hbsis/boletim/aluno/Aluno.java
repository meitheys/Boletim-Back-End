package com.hbsis.boletim.aluno;

import com.hbsis.boletim.ligaçãoAlunoTurma.AlunoTurma;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nome_aluno")
    private String nomeAluno;
    @Column(name = "responsavel")
    private String responsavel;
    @Column(name = "telefone")
    private String telefone;
    @OneToMany(mappedBy = "idAluno")
    private List<AlunoTurma> alunoTurmaList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<AlunoTurma> getAlunoTurmaList() {
        return alunoTurmaList;
    }

    public void setAlunoTurmaList(List<AlunoTurma> alunoTurmaList) {
        this.alunoTurmaList = alunoTurmaList;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", alunoTurmaList=" + alunoTurmaList +
                '}';
    }
}
