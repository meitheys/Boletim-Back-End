package com.hbsis.boletim.boletim;

import com.hbsis.boletim.aluno.AlunoService;
import com.hbsis.boletim.notas.NotasService;
import com.hbsis.boletim.turma.TurmaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class BoletimService {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoletimService.class);
    private BoletimRepository boletimRepository;
    private AlunoService alunoService;
    private TurmaService turmaService;
    private NotasService notasService;

    public BoletimService(BoletimRepository boletimRepository, AlunoService alunoService, NotasService notasService, TurmaService turmaService) {
        this.boletimRepository = boletimRepository;
        this.alunoService = alunoService;
        this.notasService = notasService;
        this.turmaService = turmaService;
    }

    public BoletimDTO save(BoletimDTO boletimDTO) throws IOException {
        LOGGER.info("Salvando boletim");
        LOGGER.debug("Boletim {}", boletimDTO);

        Boletim boletim = new Boletim();
        boletim.setAluno(alunoService.findByIdAluno(boletimDTO.getAluno()));
        boletim.setMateria(turmaService.findByIdEntity(boletimDTO.getMateria()));
        boletim.setMedia(boletimDTO.getMedia());

        return boletimDTO.of(boletim);
    }

    public BoletimDTO findById(Long id) {
        Optional<Boletim> boletimOptional = this.boletimRepository.findById(id);

        if (boletimOptional.isPresent()) {
            Boletim boletim = boletimOptional.get();
            return BoletimDTO.of(boletim);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }
}