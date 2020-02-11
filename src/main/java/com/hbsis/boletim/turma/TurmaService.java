package com.hbsis.boletim.turma;

import com.hbsis.boletim.escola.EscolaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class TurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EscolaService.class);
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }
    public TurmaDTO save(TurmaDTO turmaDTO) throws IOException {
        this.validate(turmaDTO);
        LOGGER.info("Salvando turma");
        LOGGER.debug("Turma {}", turmaDTO);

        Turma turma = new Turma();
        turma.setAlunos(turmaDTO.getAlunos());
        turma.setNumeroTurma(turmaDTO.getNumeroTurma());
        turma.setPeriodo(turmaDTO.getPeriodo());
        turma.setProfessor(turmaDTO.getProfessor());
        turma = this.turmaRepository.save(turma);

        return turmaDTO.of(turma);
    }

    public TurmaDTO findById(Long id) {
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            return TurmaDTO.of(turma);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Turma findByTurmaId(Long id){
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if(turmaOptional.isPresent()){
            return turmaOptional.get();
        }
        throw new IllegalArgumentException(String.format("Id %s não existe", id));
    }

    private void validate(TurmaDTO turmaDTO) {
        LOGGER.info("Validando turma...");

        if (turmaDTO == null) {
            throw new IllegalArgumentException("Turma não deve ser nula!");
        }

        if (StringUtils.isEmpty(turmaDTO.getAlunos())){
            throw new IllegalArgumentException("Alunos não devem ser nulos!");
        }
        if (StringUtils.isEmpty(turmaDTO.getNumeroTurma())){
            throw new IllegalArgumentException("Numero da turma não deve ser nulo");
        }
        if (StringUtils.isEmpty(turmaDTO.getPeriodo())){
            throw new IllegalArgumentException("Periodo da turma não deve ser nulo");
        }
        if (StringUtils.isEmpty(turmaDTO.getProfessor())){
            throw new IllegalArgumentException("Professores da turma não devem ser nulos");
        }
    }

    public TurmaDTO update(TurmaDTO turmaDTO, Long id) {
        this.validate(turmaDTO);
        Optional<Turma> turmaExistente = this.turmaRepository.findById(id);

        if (turmaExistente.isPresent()) {
            Turma turmaJaExiste = turmaExistente.get();

            LOGGER.info("Atualizando turma, id: [{}]", turmaDTO.getId());

            turmaJaExiste.setAlunos(turmaDTO.getAlunos());
            turmaJaExiste.setProfessor(turmaDTO.getProfessor());
            turmaJaExiste.setProfessor(turmaDTO.get());
            turmaJaExiste.setCodigoEscola(escolaDTO.getCodigoEscola());
            turmaJaExiste = this.escolaRepository.save(escolaJaExiste);

            return escolaDTO.of(escolaJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em escola de id: ", id);
        this.escolaRepository.deleteById(id);
    }

}
