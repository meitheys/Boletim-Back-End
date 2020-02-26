package com.hbsis.boletim.disciplinas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaRest.class);
    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaRest(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public DisciplinaDTO save(@RequestBody DisciplinaDTO disciplinaDTO) {
        LOGGER.info("Recebendo solicitação das disciplinas...");
        LOGGER.debug("Payload: {}", disciplinaDTO);
        return this.disciplinaService.save(disciplinaDTO);
    }

    @GetMapping("/{id}")
    public Disciplina find(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo find by ID... id: [{}]", id);
        return this.disciplinaService.findById(id);
    }

    @GetMapping("/findDisciplinas")
    public List<Disciplina> findAll() {
        LOGGER.info("Listando Disciplinas");
        return this.disciplinaService.findAll();
    }

    @PutMapping("/{id}")
    public DisciplinaDTO udpate(@PathVariable("id") Long id, @RequestBody DisciplinaDTO disciplinaDTO) {
        LOGGER.info("Recebendo Update para disciplina de ID: {}", id);
        LOGGER.debug("Payload: {}", disciplinaDTO);
        return this.disciplinaService.update(disciplinaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Recebendo delete para a disciplina com id: {}", id);
        this.disciplinaService.delete(id);
    }
}
