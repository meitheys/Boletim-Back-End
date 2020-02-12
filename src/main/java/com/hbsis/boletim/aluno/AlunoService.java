package com.hbsis.boletim.aluno;

import com.hbsis.boletim.turma.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);
    private AlunoRepository alunoRepository;
    private TurmaService turmaService;

    public AlunoService(AlunoRepository alunoRepository, TurmaService turmaService) {
        this.alunoRepository = alunoRepository;
        this.turmaService = turmaService;
    }

    public AlunoDTO save(AlunoDTO alunoDTO) throws IOException {
        this.validate(alunoDTO);
        LOGGER.info("Salvando aluno");
        LOGGER.debug("Aluno {}", alunoDTO);

        Aluno aluno = new Aluno();
        aluno.setNomeAluno(alunoDTO.getNomeAluno());
        aluno.setResponsavel(alunoDTO.getResponsavel());
        aluno.setTelefone(alunoDTO.getTelefone());
        aluno.setTurma(turmaService.findByCodigoNumeroTurma(alunoDTO.getTurma()));
        aluno = this.alunoRepository.save(aluno);

        return alunoDTO.of(aluno);
    }

    public AlunoDTO findById(Long id) {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            return AlunoDTO.of(aluno);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Aluno findByIdAluno(long id){
        Optional<Aluno> optional = this.alunoRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new IllegalArgumentException(String.format("Id: %s não existe", id));
    }

    private void validate(AlunoDTO alunoDTO) {
        LOGGER.info("Validando aluno...");

        if (alunoDTO == null) {
            throw new IllegalArgumentException("Aluno não deve ser nulo!");
        }
        if (StringUtils.isEmpty(alunoDTO.getNomeAluno())) {
            throw new IllegalArgumentException("Nome do aluno não deve ser nulo");
        }
        if (StringUtils.isEmpty(alunoDTO.getTelefone())) {
            throw new IllegalArgumentException("Telefone do aluno não deve ser nulo");
        }
    }

    public Aluno findByOptionalId(long id) {
        Optional<Aluno> optional = this.alunoRepository.findById(id);

        if (optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalArgumentException(String.format("Numero da turma: %s não existe", id));
    }

    public AlunoDTO update(AlunoDTO alunoDTO, Long id) {
        this.validate(alunoDTO);
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (alunoOptional.isPresent()) {
            Aluno alunoJaExiste = alunoOptional.get();

            LOGGER.info("Atualizando aluno, id: [{}]", alunoDTO.getId());

            alunoJaExiste.setNomeAluno(alunoDTO.getNomeAluno());
            alunoJaExiste.setResponsavel(alunoDTO.getResponsavel());
            ;
            alunoJaExiste.setTelefone(alunoDTO.getTelefone());
            alunoJaExiste = this.alunoRepository.save(alunoJaExiste);

            return alunoDTO.of(alunoJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em aluno de id: ", id);
        this.alunoRepository.deleteById(id);
    }
}
