package com.hbsis.boletim.ligaçãoAlunoTurma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/alunoTurma")
public class AlunoTurmaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoTurmaRest.class);
    private AlunoTurmaService alunoTurmaService;

    @Autowired
    public AlunoTurmaRest(AlunoTurmaService alunoTurmaService) {
        this.alunoTurmaService = alunoTurmaService;
    }

    @PostMapping
    public AlunoTurmaDTO save(@RequestBody AlunoTurmaDTO alunoTurmaDTO) throws IOException {
        LOGGER.info("Salvando relação entre aluno e turma...");
        LOGGER.debug("Payload: {}", alunoTurmaDTO);
        return this.alunoTurmaService.save(alunoTurmaDTO);
    }

    @GetMapping("/{id}")
    public AlunoTurmaDTO findAlunoTurma(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.alunoTurmaService.findById(id);
    }

    @PutMapping("/{id}")
    public AlunoTurmaDTO udpate(@PathVariable("id") Long id, @RequestBody AlunoTurmaDTO alunoTurmaDTO) {
        LOGGER.info("Recebendo Update da relação entre alunos e turmas, id da relação: {}", id);
        LOGGER.debug("Payload: {}", alunoTurmaDTO);
        return this.alunoTurmaService.update(alunoTurmaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando relação aluno-turma de ID: {}", id);
        this.alunoTurmaService.delete(id);
    }
}