package com.hbsis.boletim.aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {
    private long id;
    private String nomeAluno;
    private String responsavel;
    private String telefone;
    private String turma;

    public AlunoDTO(long id, String nomeAluno, String responsavel, String telefone, String turma) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.turma = turma;
    }

    public static AlunoDTO of(Aluno aluno) {
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNomeAluno(),
                aluno.getResponsavel(),
                aluno.getTelefone(),
                aluno.getTurma().getNumeroTurma()
        );
    }

    public AlunoDTO() {
    }

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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", turma='" + turma + '\'' +
                '}';
    }
}