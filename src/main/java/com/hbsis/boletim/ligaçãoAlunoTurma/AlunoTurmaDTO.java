package com.hbsis.boletim.ligaçãoAlunoTurma;

public class AlunoTurmaDTO {
    private long id;
    private long idAluno;
    private String idTurma;

    public AlunoTurmaDTO(long id, long idAluno, String idTurma) {
        this.id = id;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
    }

    public static AlunoTurmaDTO of(AlunoTurma alunoTurma) {
        return new AlunoTurmaDTO(
                alunoTurma.getId(),
                alunoTurma.getIdAluno().getId(),
                alunoTurma.getIdTurma().getNumeroTurma()
        );
    }

    public AlunoTurmaDTO() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(long idAluno) {
        this.idAluno = idAluno;
    }

    public String getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(String idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public String toString() {
        return "AlunoTurmaDTO{" +
                "id=" + id +
                ", idAluno=" + idAluno +
                ", idTurma='" + idTurma + '\'' +
                '}';
    }
}
