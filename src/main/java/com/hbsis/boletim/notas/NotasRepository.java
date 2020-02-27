package com.hbsis.boletim.notas;

import com.hbsis.boletim.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotasRepository extends JpaRepository<Notas, Long> {
    List<Notas> findByAlunoAndSemestre (Aluno aluno, String semestre);
}
