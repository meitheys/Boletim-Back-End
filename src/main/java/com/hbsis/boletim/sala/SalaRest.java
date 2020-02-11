package com.hbsis.boletim.sala;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/sala")
public class SalaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalaRest.class);
    private SalaService salaService;

    @Autowired
    public SalaRest(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public SalaDTO save(@RequestBody SalaDTO salaDTO) throws IOException {
        LOGGER.info("Salvando sala...");
        LOGGER.debug("Payload: {}", salaDTO);
        return this.salaService.save(salaDTO);
    }

    @GetMapping("/{id}")
    public SalaDTO findEscola(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.salaService.findById(id);
    }

    @PutMapping("/{id}")
    public SalaDTO udpate(@PathVariable("id") Long id, @RequestBody SalaDTO salaDTO) {
        LOGGER.info("Recebendo Update de sala, id: {}", id);
        LOGGER.debug("Payload: {}", salaDTO);
        return this.salaService.update(salaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando escola de ID: {}", id);
        this.salaService.delete(id);
    }
}
