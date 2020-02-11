package com.hbsis.boletim.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProfessorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorService.class);
    private ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public ProfessorDTO save(ProfessorDTO professorDTO) throws IOException {
        this.validate(professorDTO);
        LOGGER.info("Salvando professor");
        LOGGER.debug("Professor {}", professorDTO);

        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setCodigoProfessor(professorDTO.getCodigoProfessor());
        professor.setDisciplina(professorDTO.getDisciplina());
        professor.setTelefone(professorDTO.getTelefone());
        professor = this.professorRepository.save(professor);

        return professorDTO.of(professor);
    }

    public ProfessorDTO findById(Long id) {
        Optional<Professor> professorOptional = this.professorRepository.findById(id);

        if (professorOptional.isPresent()) {
            Professor professor = professorOptional.get();
            return ProfessorDTO.of(professor);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    private void validate(ProfessorDTO professorDTO) {
        LOGGER.info("Validando professor...");

        if (professorDTO == null) {
            throw new IllegalArgumentException("Professor não deve ser nula!");
        }
        if (StringUtils.isEmpty(professorDTO.getNome())){
            throw new IllegalArgumentException("Nome do professor não deve ser nulo");
        }
        if (StringUtils.isEmpty(professorDTO.getCodigoProfessor())){
            throw new IllegalArgumentException("Codigo do professor não deve ser nulo");
        }
        if (StringUtils.isEmpty(professorDTO.getDisciplina())){
            throw new IllegalArgumentException("Disciplina do professor não deve ser nulo");
        }
        if (StringUtils.isEmpty(professorDTO.getTelefone())){
            throw new IllegalArgumentException("Telefone do professor não deve ser nulo");
        }
    }

    public ProfessorDTO update(ProfessorDTO professorDTO, Long id) {
        this.validate(professorDTO);
        Optional<Professor> professorOptional = this.professorRepository.findById(id);

        if (professorOptional.isPresent()) {
            Professor professorJaExiste = professorOptional.get();

            LOGGER.info("Atualizando professor, id: [{}]", professorDTO.getId());

            professorJaExiste.setNome(professorDTO.getNome());
            professorJaExiste.setCodigoProfessor(professorDTO.getCodigoProfessor());;
            professorJaExiste.setDisciplina(professorDTO.getDisciplina());
            professorJaExiste.setTelefone(professorDTO.getTelefone());
            professorJaExiste = this.professorRepository.save(professorJaExiste);

            return professorDTO.of(professorJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em professor de id: ", id);
        this.professorRepository.deleteById(id);
    }
}
