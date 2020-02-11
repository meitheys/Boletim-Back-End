package com.hbsis.boletim.ligaçãoAlunoTurma;

import com.hbsis.boletim.aluno.AlunoService;
import com.hbsis.boletim.turma.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class AlunoTurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoTurmaService.class);
    private AlunoTurmaRepository alunoTurmaRepository;
    private AlunoService alunoService;
    private TurmaService turmaService;

    @Autowired
    public AlunoTurmaService(AlunoTurmaRepository alunoTurmaRepository, AlunoService alunoService) {
        this.alunoTurmaRepository = alunoTurmaRepository;
        this.alunoService = alunoService;
    }

    public AlunoTurmaDTO save(AlunoTurmaDTO alunoTurmaDTO) throws IOException {
        this.validate(alunoTurmaDTO);
        LOGGER.info("Salvando relação aluno-turma");
        LOGGER.debug("Professor {}", alunoTurmaDTO);

        AlunoTurma alunoTurma = new AlunoTurma();
        alunoTurma.setIdAluno(alunoService.findByOptionalId(alunoTurmaDTO.getIdAluno()));
        alunoTurma.setIdTurma(turmaService.findByCodigoNumeroTurma(alunoTurmaDTO.getIdTurma()));
        alunoTurma = this.alunoTurmaRepository.save(alunoTurma);

        return alunoTurmaDTO.of(alunoTurma);
    }

    public AlunoTurmaDTO findById(Long id) {
        Optional<AlunoTurma> alunoTurmaOptional = this.alunoTurmaRepository.findById(id);

        if (alunoTurmaOptional.isPresent()) {
            AlunoTurma alunoTurma = alunoTurmaOptional.get();
            return AlunoTurmaDTO.of(alunoTurma);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    private void validate(AlunoTurmaDTO alunoTurmaDTO) {
        LOGGER.info("Validando relação aluno-turma...");

        if (alunoTurmaDTO == null) {
            throw new IllegalArgumentException("Professor não deve ser nula!");
        }
        if (StringUtils.isEmpty(alunoTurmaDTO.getIdAluno())){
            throw new IllegalArgumentException("Informe um aluno!");
        }
        if (StringUtils.isEmpty(alunoTurmaDTO.getIdTurma())){
            throw new IllegalArgumentException("Informe uma turma!");
        }
    }

    public AlunoTurmaDTO update(AlunoTurmaDTO alunoTurmaDTO, Long id) {
        this.validate(alunoTurmaDTO);
        Optional<AlunoTurma> professorOptional = this.alunoTurmaRepository.findById(id);

        if (professorOptional.isPresent()) {
            AlunoTurma alunoTurmaJaExiste = professorOptional.get();

            LOGGER.info("Atualizando relação aluno-turma, id: [{}]", alunoTurmaDTO.getId());

            alunoTurmaJaExiste.setIdAluno(alunoService.findByOptionalId(alunoTurmaDTO.getIdAluno()));
            alunoTurmaJaExiste.setIdTurma(turmaService.findByCodigoNumeroTurma(alunoTurmaDTO.getIdTurma()));
            alunoTurmaJaExiste = this.alunoTurmaRepository.save(alunoTurmaJaExiste);

            return alunoTurmaDTO.of(alunoTurmaJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em relação aluno-turma de id: ", id);
        this.alunoTurmaRepository.deleteById(id);
    }
}