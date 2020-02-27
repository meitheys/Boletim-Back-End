package com.hbsis.boletim.disciplinas;

import com.hbsis.boletim.notas.NotasDTO;
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
        disciplina.setDisciplinas(disciplinaDTO.getDisciplinas());
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

    public void validate(DisciplinaDTO disciplinaDTO) {
        LOGGER.info("Validando disciplina...");

        if (disciplinaDTO == null) {
            throw new IllegalArgumentException("Disciplina vazia!");
        }
        if (disciplinaDTO.getDisciplinas() == null) {
            throw new IllegalArgumentException("A disciplina não deve ser nula!");
        }
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
            disciplina.setDisciplinas(disciplinaDTO.getDisciplinas());

            disciplina = this.disciplinaRepository.save(disciplina);

            return DisciplinaDTO.of(disciplina);
        }

        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Executando delete para disciplina de ID: [{}]", id);
        this.disciplinaRepository.deleteById(id);
    }
}