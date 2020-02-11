package com.hbsis.boletim.turma;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/turma")
public class TurmaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaRest.class);
    private TurmaService turmaService;

    @Autowired
    public TurmaRest(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping
    public TurmaDTO save(@RequestBody TurmaDTO turmaDTO) throws IOException {
        LOGGER.info("Salvando turma...");
        LOGGER.debug("Payload: {}", turmaDTO);
        return this.turmaService.save(turmaDTO);
    }


    @GetMapping("/{id}")
    public TurmaDTO findEscola(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.turmaService.findById(id);
    }

    @PutMapping("/{id}")
    public TurmaDTO udpate(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) {
        LOGGER.info("Recebendo Update de turma, id: {}", id);
        LOGGER.debug("Payload: {}", turmaDTO);
        return this.turmaService.update(turmaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando turma de ID: {}", id);
        this.turmaService.delete(id);
    }
}
