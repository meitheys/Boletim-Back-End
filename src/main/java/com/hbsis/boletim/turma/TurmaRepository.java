package com.hbsis.boletim.turma;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findByNumeroTurma(String numeroTurma);
}