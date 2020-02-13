package com.hbsis.boletim.boletim;

public class BoletimDTO {
    private long id;
    private long aluno;
    private long materia;
    private double media;

    public BoletimDTO() {
    }

    public static BoletimDTO of(Boletim boletim) {
        return new BoletimDTO(
                boletim.getId(),
                boletim.getAluno().getId(),
                boletim.getMateria().getId(),
                boletim.getMedia()
        );
    }

    public BoletimDTO(long id, long aluno, long materia, double media) {
        this.id = id;
        this.aluno = aluno;
        this.materia = materia;
        this.media = media;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAluno() {
        return aluno;
    }

    public void setAluno(long aluno) {
        this.aluno = aluno;
    }

    public long getMateria() {
        return materia;
    }

    public void setMateria(long materia) {
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
        return "BoletimDTO{" +
                "id=" + id +
                ", aluno=" + aluno +
                ", materia=" + materia +
                ", media=" + media +
                '}';
    }
}
