package com.hbsis.boletim.sala;

import com.hbsis.boletim.escola.EscolaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class SalaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SalaService.class);
    private SalaRepository salaRepository;
    private EscolaService escolaService;

    public SalaService(SalaRepository salaRepository, EscolaService escolaService){
        this.salaRepository = salaRepository;
        this.escolaService = escolaService;
    }

    public SalaDTO save(SalaDTO salaDTO) throws IOException {
        this.validate(salaDTO);
        LOGGER.info("Salvando sala");
        LOGGER.debug("Sala {}", salaDTO);

        Sala sala = new Sala();
        sala.setCodigoSala(salaDTO.getCodigoSala());
        sala.setNomeSala(salaDTO.getNomeSala());
        sala.setEscola(escolaService.findByEscolaId(salaDTO.getEscola()));
        sala = this.salaRepository.save(sala);

        return salaDTO.of(sala);
    }

    public SalaDTO findById(Long id) {
        Optional<Sala> salaOptional = this.salaRepository.findById(id);

        if (salaOptional.isPresent()) {
            Sala sala = salaOptional.get();
            return SalaDTO.of(sala);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    private void validate(SalaDTO salaDTO) {
        LOGGER.info("Validando sala...");

        if (salaDTO == null) {
            throw new IllegalArgumentException("Sala não deve ser nula!");
        }
        if (StringUtils.isEmpty(salaDTO.getCodigoSala())){
            throw new IllegalArgumentException("Codigo da sala não deve ser nulo");
        }
        if (StringUtils.isEmpty(salaDTO.getNomeSala())){
            throw new IllegalArgumentException("Nome da sala não deve ser nulo");
        }
        if (StringUtils.isEmpty(salaDTO.getEscola())){
            throw new IllegalArgumentException("Escola de referência da sala não deve ser nulo");
        }
    }

    public SalaDTO update(SalaDTO salaDTO, Long id) {
        this.validate(salaDTO);
        Optional<Sala> salaOptional = this.salaRepository.findById(id);

        if (salaOptional.isPresent()) {
            Sala salaJaExiste = salaOptional.get();

            LOGGER.info("Atualizando sala, id: [{}]", salaDTO.getId());
            salaJaExiste.setEscola(escolaService.findByEscolaId(salaDTO.getEscola()));
            salaJaExiste.setNomeSala(salaDTO.getNomeSala());
            salaJaExiste.setCodigoSala(salaDTO.getCodigoSala());
            salaJaExiste = this.salaRepository.save(salaJaExiste);

            return salaDTO.of(salaJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em sala de id: ", id);
        this.salaRepository.deleteById(id);
    }
}