package com.hbsis.boletim.disciplinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaService.class);
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaDTO save(DisciplinaDTO disciplinaDTO) {
        LOGGER.info("Salvando disciplina...");
        LOGGER.debug("Disciplina: {}", disciplinaDTO);

        Disciplina disciplina = new Disciplina();
        disciplina.setId(disciplinaDTO.getId());
        disciplina.setDisciplinas(disciplinaDTO.getDisciplina());
        disciplina = this.disciplinaRepository.save(disciplina);

        return DisciplinaDTO.of(disciplina);
    }

    public Disciplina findById(Long id) {
        Optional<Disciplina> disciplinaOptional = this.disciplinaRepository.findById(id);

        if (disciplinaOptional.isPresent()) {
            return disciplinaOptional.get();
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public List<Disciplina> findAll(){
        List<Disciplina> disciplinaList = new ArrayList<>();
        try{
            disciplinaList = this.disciplinaRepository.findAll();
        }catch (Exception e){ }
        return disciplinaList;
    }

    public DisciplinaDTO update(DisciplinaDTO disciplinaDTO, Long id) {
        Optional<Disciplina> disciplinaOptional = this.disciplinaRepository.findById(id);

        if (disciplinaOptional.isPresent()) {
            Disciplina disciplina = disciplinaOptional.get();

            LOGGER.info("Atualizando disciplina... id: [{}]", disciplina.getId());
            LOGGER.debug("Payload: {}", disciplinaDTO);

            disciplina.setId(disciplinaDTO.getId());
            disciplina.setDisciplinas(disciplinaDTO.getDisciplina());

            disciplina = this.disciplinaRepository.save(disciplina);

            return DisciplinaDTO.of(disciplina);
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para usuário de ID: [{}]", id);
        this.disciplinaRepository.deleteById(id);
    }
}