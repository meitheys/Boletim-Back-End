package com.hbsis.boletim.boletim;

import com.hbsis.boletim.notas.NotasRest;
import com.hbsis.boletim.notas.NotasService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/boletim")
public class BoletimRest {
    private static final Logger LOGGER = LoggerFactory.getLogger(BoletimRest.class);
    private BoletimService boletimService;

    @Autowired
    public BoletimRest(BoletimService boletimService) {
        this.boletimService = boletimService;
    }

    @PostMapping
    public BoletimDTO save(@RequestBody BoletimDTO boletimDTO) throws IOException {
        LOGGER.info("Salvando boletim...");
        LOGGER.debug("Boletim: {}", boletimDTO);
        return this.boletimService.save(boletimDTO);
    }

    @GetMapping("/{id}")
    public BoletimDTO findBoletim(@PathVariable("id") Long id) {
        LOGGER.info("Procurando com base em id: [{}]", id);
        return this.boletimService.findById(id);
    }
}