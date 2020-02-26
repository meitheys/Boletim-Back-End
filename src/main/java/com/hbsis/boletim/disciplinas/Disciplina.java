package com.hbsis.boletim.disciplinas;

import javax.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "disciplinas")
    private String disciplinas;

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
        return "Disciplina{" +
                "id=" + id +
                ", disciplinas='" + disciplinas + '\'' +
                '}';
    }
}