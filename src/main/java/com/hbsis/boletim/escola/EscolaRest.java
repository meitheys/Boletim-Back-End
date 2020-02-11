package com.hbsis.boletim.escola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/escola")
public class EscolaRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EscolaRest.class);
    private EscolaService escolaService;

    @Autowired
    public EscolaRest(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @PostMapping
    public EscolaDTO save(@RequestBody EscolaDTO escolaDTO) throws IOException {
        LOGGER.info("Salvando escola...");
        LOGGER.debug("Payload: {}", escolaDTO);
        return this.escolaService.save(escolaDTO);
    }

    @GetMapping("/{id}")
    public EscolaDTO findEscola(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.escolaService.findById(id);
    }

    @PutMapping("/{id}")
    public EscolaDTO udpate(@PathVariable("id") Long id, @RequestBody EscolaDTO escolaDTO) {
        LOGGER.info("Recebendo Update de escola, id: {}", id);
        LOGGER.debug("Payload: {}", escolaDTO);
        return this.escolaService.update(escolaDTO, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        LOGGER.info("Deletando escola de ID: {}", id);
        this.escolaService.delete(id);
    }

}
