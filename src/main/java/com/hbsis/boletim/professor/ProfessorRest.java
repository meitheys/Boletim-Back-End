package com.hbsis.boletim.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/professores")
public class ProfessorRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorRest.class);
    private ProfessorService professorService;

    @Autowired
    public ProfessorRest(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public ProfessorDTO save(@RequestBody ProfessorDTO professorDTO) throws IOException {
        LOGGER.info("Salvando professor...");
        LOGGER.debug("Payload: {}", professorDTO);
        return this.professorService.save(professorDTO);
    }

    @GetMapping("/{id}")
    public ProfessorDTO findProfessor(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.professorService.findById(id);
    }

    @PutMapping("/{id}")
    public ProfessorDTO udpate(@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        LOGGER.info("Recebendo Update de professor, id: {}", id);
        LOGGER.debug("Payload: {}", professorDTO);
        return this.professorService.update(professorDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando professor de ID: {}", id);
        this.professorService.delete(id);
    }
}