package com.hbsis.boletim.notas;

import com.hbsis.boletim.aluno.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class NotasService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotasService.class);
    private NotasRepository notasRepository;
    private AlunoService alunoService;


    public NotasService(NotasRepository notasRepository, AlunoService aluno) {
        this.notasRepository = notasRepository;
        this.alunoService = alunoService;
    }

    public NotasDTO save(NotasDTO notasDTO) throws IOException {
        this.validate(notasDTO);
        LOGGER.info("Salvando notas");
        LOGGER.debug("Nota {}", notasDTO);

        Notas notas = new Notas();
        notas.setAluno(alunoService.findByIdAluno(notasDTO.getAluno()));
        notas.setDisciplina(notasDTO.getDisciplina());
        notas.setNota(notasDTO.getNota());
        notas.setTrimestre(notasDTO.getTrimestre());
        notas = this.notasRepository.save(notas);

        return notasDTO.of(notas);
    }

    public void validate(NotasDTO notasDTO){
        LOGGER.info("Validando notas...");

        if (notasDTO == null) {
            throw new IllegalArgumentException("Notas não deve ser nulo!");
        }
        if (StringUtils.isEmpty(notasDTO.getAluno())) {
            throw new IllegalArgumentException("Aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(notasDTO.getDisciplina())) {
            throw new IllegalArgumentException("Disciplina não deve ser nula");
        }
        if (StringUtils.isEmpty(notasDTO.getNota())) {
            throw new IllegalArgumentException("Nota não deve ser nula");
        }
        if (notasDTO.getNota() > 10 || notasDTO.getNota() < 0){
            throw new IllegalArgumentException("Nota inválida");
        }
    }

    public NotasDTO findById(Long id) {
        Optional<Notas> notasOptional = this.notasRepository.findById(id);

        if (notasOptional.isPresent()) {
            Notas notas = notasOptional.get();
            return NotasDTO.of(notas);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public NotasDTO update(NotasDTO notasDTO, Long id) {
        this.validate(notasDTO);
        Optional<Notas> notaOpcional = this.notasRepository.findById(id);

        if (notaOpcional.isPresent()) {
            Notas notasJaExiste = notaOpcional.get();

            LOGGER.info("Atualizando notas, id: [{}]", notasDTO.getId());

            notasJaExiste.setNota(notasDTO.getNota());
            notasJaExiste.setDisciplina(notasDTO.getDisciplina());
            notasJaExiste.setAluno(alunoService.findByIdAluno(notasDTO.getAluno()));
            notasJaExiste.setTrimestre(notasDTO.getTrimestre());
            notasJaExiste = this.notasRepository.save(notasJaExiste);

            return notasDTO.of(notasJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em nota de id: ", id);
        this.notasRepository.deleteById(id);
    }

}
