package com.hbsis.boletim.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findById(String id);
}
