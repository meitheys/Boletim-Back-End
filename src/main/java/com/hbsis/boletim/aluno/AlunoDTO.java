package com.hbsis.boletim.aluno;

import com.hbsis.boletim.ligaçãoAlunoTurma.AlunoTurmaDTO;

import java.util.ArrayList;
import java.util.List;

public class AlunoDTO {
    private long id;
    private String nomeAluno;
    private String responsavel;
    private String telefone;
    private List<AlunoTurmaDTO> alunoTurmaDTOList;

    public AlunoDTO(long id, String nomeAluno, String responsavel, String telefone, List<AlunoTurmaDTO> alunoTurmaDTOList) {
        this.id = id;
        this.nomeAluno = nomeAluno;
        this.responsavel = responsavel;
        this.telefone = telefone;
        this.alunoTurmaDTOList = alunoTurmaDTOList;
    }

    public static AlunoDTO of(Aluno aluno) {
        List<AlunoTurmaDTO> alunoTurmaDTOList = new ArrayList<>();
        aluno.getAlunoTurmaList().forEach(alunoTurma -> alunoTurmaDTOList.add(AlunoTurmaDTO.of(alunoTurma)));
        return new AlunoDTO(
                aluno.getId(),
                aluno.getNomeAluno(),
                aluno.getResponsavel(),
                aluno.getTelefone(),
                alunoTurmaDTOList
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

    public List<AlunoTurmaDTO> getAlunoTurmaDTOList() {
        return alunoTurmaDTOList;
    }

    public void setAlunoTurmaDTOList(List<AlunoTurmaDTO> alunoTurmaDTOList) {
        this.alunoTurmaDTOList = alunoTurmaDTOList;
    }

    @Override
    public String toString() {
        return "AlunoDTO{" +
                "id=" + id +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", responsavel='" + responsavel + '\'' +
                ", telefone='" + telefone + '\'' +
                ", alunoTurmaDTOList=" + alunoTurmaDTOList +
                '}';
    }
}
