package com.hbsis.boletim.disciplinas;

import javax.validation.constraints.NotNull;

public class DisciplinaDTO {

    private Long id;
    private String disciplinas;

    public DisciplinaDTO() { }

    public DisciplinaDTO(Long id, String disciplinas) {
        this.id = id;
        this.disciplinas = disciplinas;
    }

    public static DisciplinaDTO of(Disciplina disciplina) {
        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getDisciplinas()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "DisciplinaDTO{" +
                "id=" + id +
                ", disciplinas='" + disciplinas + '\'' +
                '}';
    }
}