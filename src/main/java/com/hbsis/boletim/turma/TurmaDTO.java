package com.hbsis.boletim.turma;

import com.hbsis.boletim.ligaçãoAlunoTurma.AlunoTurma;
import com.hbsis.boletim.ligaçãoAlunoTurma.AlunoTurmaDTO;

import java.util.ArrayList;
import java.util.List;

public class TurmaDTO {
    private long id;
    private long escola;
    private String numeroTurma;
    private String periodo;
    private List<AlunoTurmaDTO> alunoTurmaListB;

    public TurmaDTO(){}

    public TurmaDTO(long id, long escola, String numeroTurma, String periodo, List<AlunoTurmaDTO> alunoTurmaListB) {
        this.id = id;
        this.escola = escola;
        this.numeroTurma = numeroTurma;
        this.periodo = periodo;
        this.alunoTurmaListB = alunoTurmaListB;
    }

    public static TurmaDTO of(Turma turma) {
        List<AlunoTurmaDTO> alunoTurmaListB = new ArrayList<>();
        turma.getAlunoTurmaListB().forEach(alunoTurma -> alunoTurmaListB.add(AlunoTurmaDTO.of(alunoTurma)));
        return new TurmaDTO(
                turma.getId(),
                turma.getEscola().getId(),
                turma.getNumeroTurma(),
                turma.getPeriodo(),
                alunoTurmaListB
        );
    }

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

    public long getEscola() {
        return escola;
    }

    public void setEscola(long escola) {
        this.escola = escola;
    }

    public List<AlunoTurmaDTO> getAlunoTurmaListB() {
        return alunoTurmaListB;
    }

    public void setAlunoTurmaListB(List<AlunoTurmaDTO> alunoTurmaListB) {
        this.alunoTurmaListB = alunoTurmaListB;
    }

    @Override
    public String toString() {
        return "TurmaDTO{" +
                "id=" + id +
                ", escola=" + escola +
                ", numeroTurma='" + numeroTurma + '\'' +
                ", periodo='" + periodo + '\'' +
                ", alunoTurmaListB=" + alunoTurmaListB +
                '}';
    }
}