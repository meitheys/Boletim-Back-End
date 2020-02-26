package com.hbsis.boletim.notas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/notas")
public class NotasRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotasRest.class);
    private NotasService notasService;

    @Autowired
    public NotasRest(NotasService notasService) {
        this.notasService = notasService;
    }

    @PostMapping
    public NotasDTO save(@RequestBody NotasDTO notasDTO) throws IOException {
        LOGGER.info("Salvando notas...");
        LOGGER.debug("Payload: {}", notasDTO);
        return this.notasService.save(notasDTO);
    }

    @GetMapping("/{id}")
    public NotasDTO findNotas(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.notasService.findById(id);
    }

    @PutMapping("/{id}")
    public NotasDTO udpate(@PathVariable("id") Long id, @RequestBody NotasDTO notasDTO) {
        LOGGER.info("Recebendo Update de notas, id: {}", id);
        LOGGER.debug("Payload: {}", notasDTO);
        return this.notasService.update(notasDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando notas de ID: {}", id);
        this.notasService.delete(id);
    }
}