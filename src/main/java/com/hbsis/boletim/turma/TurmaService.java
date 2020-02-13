package com.hbsis.boletim.turma;

import com.hbsis.boletim.aluno.AlunoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public TurmaDTO save(TurmaDTO turmaDTO) throws IOException {

        /*this.validate(turmaDTO);
        LOGGER.info("Salvando turma");
        LOGGER.debug("Turma {}", turmaDTO);
        List<AlunoTurma> alunoTurmaDTOList = new ArrayList<>();

        Turma turma = new Turma();
        turma.setEscola(escolaService.findByEscolaId(turmaDTO.getEscola()));
        turma.setNumeroTurma(turmaDTO.getNumeroTurma());
        turma.setPeriodo(turmaDTO.getPeriodo());

        turma = this.turmaRepository.save(turma);
        return turmaDTO.of(turma);*/

        return TurmaDTO.of(this.saveGenerico(turmaDTO));
    }

    private Turma saveGenerico(TurmaDTO turmaDTO) {
        Turma turma = this.fromDTO(turmaDTO, new Turma());
        turma = this.turmaRepository.save(turma);
        return turma;
    }

    private Turma fromDTO(TurmaDTO turmaDTO, Turma turma) {
        turma.setNumeroTurma(turmaDTO.getNumeroTurma());
        turma.setPeriodo(turmaDTO.getPeriodo());
        turma.setDisciplina(turmaDTO.getDisciplina());
        return turma;
    }

    public TurmaDTO findById(Long id) {
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
            return TurmaDTO.of(turma);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Turma findByIdEntity(Long id) {
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if (turmaOptional.isPresent()) {
            Turma turma = turmaOptional.get();
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Turma findByCodigoNumeroTurma(String numeroTurma){
        Optional<Turma> optional = this.turmaRepository.findByNumeroTurma(numeroTurma);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new IllegalArgumentException(String.format("Numero da turma: %s não existe", numeroTurma));
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
        if (StringUtils.isEmpty(turmaDTO.getNumeroTurma())){
            throw new IllegalArgumentException("Numero da turma não deve ser nulo");
        }
        if (StringUtils.isEmpty(turmaDTO.getPeriodo())){
            throw new IllegalArgumentException("Periodo da turma não deve ser nulo");
        }
    }

    public TurmaDTO update(TurmaDTO turmaDTO, Long id) {
        this.validate(turmaDTO);
        Optional<Turma> turmaExistente = this.turmaRepository.findById(id);

        if (turmaExistente.isPresent()) {
            Turma turmaJaExiste = turmaExistente.get();

            LOGGER.info("Atualizando turma, id: [{}]", turmaDTO.getId());

            turmaJaExiste.setNumeroTurma(turmaDTO.getNumeroTurma());
            turmaJaExiste.setPeriodo(turmaDTO.getPeriodo());
            turmaJaExiste.setDisciplina(turmaDTO.getDisciplina());
            turmaJaExiste = this.turmaRepository.save(turmaJaExiste);

            return turmaDTO.of(turmaJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em turma de id: ", id);
        this.turmaRepository.deleteById(id);
    }

    /*
    private List<AlunoTurma> parseList(List<AlunoTurmaDTO> alunoTurmaDTOS, Turma turma){
        List<AlunoTurma> alunoTurmas = new ArrayList<>();
        for (AlunoTurmaDTO alunoTurmaDTO : alunoTurmaDTOS){
            AlunoTurma alunoTurma = new AlunoTurma();
            alunoTurma.setIdAluno(alunoService.findByIdAluno(alunoTurmaDTO.getIdAluno()));
            alunoTurma.setIdTurma(turma);
            alunoTurmas.add(alunoTurma);
        }
        return alunoTurmas;
    }
    */

}