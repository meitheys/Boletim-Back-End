package com.hbsis.boletim.disciplinas;

import javax.validation.constraints.NotNull;

public class DisciplinaDTO {

    private Long id;
    @NotNull(message = "Disciplina cannot be null!")
    private String disciplinas;
    @NotNull(message = "Not Nullable")

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

    public String getDisciplina() {
        return disciplinas;
    }

    public void setDisciplina(String disciplina) {
        this.disciplinas = disciplina;
    }

    @Override
    public String toString() {
        return "DisciplinaDTO{" +
                "id=" + id +
                ", disciplina='" + disciplinas + '\'' +
                '}';
    }
}