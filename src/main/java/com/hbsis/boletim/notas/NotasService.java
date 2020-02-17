package com.hbsis.boletim.notas;

import com.hbsis.boletim.aluno.AlunoService;
import com.hbsis.boletim.disciplinas.DisciplinaService;
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
    private DisciplinaService disciplinaService;


    public NotasService(NotasRepository notasRepository, AlunoService alunoService, DisciplinaService disciplinaService) {
        this.notasRepository = notasRepository;
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
    }

    public NotasDTO save(NotasDTO notasDTO) throws IOException {
        this.validate(notasDTO);
        LOGGER.info("Salvando notas");
        LOGGER.debug("Nota {}", notasDTO);

        Notas notas = new Notas();
        notas.setAluno(alunoService.findByIdAluno(notasDTO.getAluno()));
        notas.setDisciplina(disciplinaService.findById(notasDTO.getDisciplina()));
        notas.setPrimeiraNota(notasDTO.getPrimeiraNota());
        notas.setSegundaNota(notasDTO.getSegundaNota());
        notas.setMedia(notasDTO.getPrimeiraNota() + notasDTO.getSegundaNota() / 2);
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
        if (StringUtils.isEmpty(notasDTO.getPrimeiraNota())) {
            throw new IllegalArgumentException("Nota 1 não deve ser nula");
        }
        if (StringUtils.isEmpty(notasDTO.getSegundaNota())) {
            throw new IllegalArgumentException("Nota 2 não deve ser nula");
        }
        if (notasDTO.getPrimeiraNota() > 10 || notasDTO.getPrimeiraNota() < 0){
            throw new IllegalArgumentException("Nota inválida");
        }
        if (notasDTO.getSegundaNota() > 10 || notasDTO.getSegundaNota() < 0){
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

            notasJaExiste.setAluno(alunoService.findByIdAluno(notasDTO.getAluno()));
            notasJaExiste.setDisciplina(disciplinaService.findById(notasDTO.getDisciplina()));
            notasJaExiste.setPrimeiraNota(notasDTO.getPrimeiraNota());
            notasJaExiste.setSegundaNota(notasDTO.getSegundaNota());
            notasJaExiste.setMedia(notasDTO.getPrimeiraNota() + notasDTO.getSegundaNota() / 2);
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