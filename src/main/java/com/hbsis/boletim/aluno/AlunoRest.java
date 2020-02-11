package com.hbsis.boletim.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/alunos")
public class AlunoRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoRest.class);
    private AlunoService alunoService;

    @Autowired
    public AlunoRest(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public AlunoDTO save(@RequestBody AlunoDTO alunoDTO) throws IOException {
        LOGGER.info("Salvando aluno...");
        LOGGER.debug("Payload: {}", alunoDTO);
        return this.alunoService.save(alunoDTO);
    }

    @GetMapping("/{id}")
    public AlunoDTO findAlun(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.alunoService.findById(id);
    }

    @PutMapping("/{id}")
    public AlunoDTO udpate(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        LOGGER.info("Recebendo Update de aluno, id: {}", id);
        LOGGER.debug("Payload: {}", alunoDTO);
        return this.alunoService.update(alunoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando aluno de ID: {}", id);
        this.alunoService.delete(id);
    }

}
