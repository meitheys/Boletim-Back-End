package com.hbsis.boletim.escola;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

@Service
public class EscolaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EscolaService.class);
    private EscolaRepository escolaRepository;

    public EscolaService(EscolaRepository escolaRepository){
        this.escolaRepository = escolaRepository;
    }

    public EscolaDTO save(EscolaDTO escolaDTO) throws IOException {
        this.validate(escolaDTO);
        LOGGER.info("Salvando escola");
        LOGGER.debug("Escola {}", escolaDTO);

        Escola escola = new Escola();
        escola.setNomeEscola(escolaDTO.getNomeEscola());
        escola.setEndereco(escolaDTO.getEndereco());
        escola.setTelefone(escolaDTO.getTelefone());
        escola.setCodigoEscola(escolaDTO.getCodigoEscola());
        escola = this.escolaRepository.save(escola);

        return escolaDTO.of(escola);
    }

    public EscolaDTO findById(Long id) {
        Optional<Escola> escolaOptional = this.escolaRepository.findById(id);

        if (escolaOptional.isPresent()) {
            Escola escola = escolaOptional.get();
            return EscolaDTO.of(escola);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public Escola findByEscolaId(Long id){
        Optional<Escola> escolaOptional = this.escolaRepository.findById(id);

        if(escolaOptional.isPresent()){
            return escolaOptional.get();
        }
        throw new IllegalArgumentException(String.format("Id %s não existe", id));
    }

    private void validate(EscolaDTO escolaDTO) {
        LOGGER.info("Validando escola...");

        if (escolaDTO == null) {
            throw new IllegalArgumentException("Escola não deve ser nula!");
        }

        if (StringUtils.isEmpty(escolaDTO.getNomeEscola())){
            throw new IllegalArgumentException("Nome da escola não deve ser nulo");
        }
        if (StringUtils.isEmpty(escolaDTO.getEndereco())){
            throw new IllegalArgumentException("Endereço da escola não deve ser nulo");
        }
        if (StringUtils.isEmpty(escolaDTO.getTelefone())){
            throw new IllegalArgumentException("Telefone da escola não deve ser nulo");
        }
        if (StringUtils.isEmpty(escolaDTO.getCodigoEscola())){
            throw new IllegalArgumentException("Codigo da escola não deve ser nulo");
        }
    }

    public EscolaDTO update(EscolaDTO escolaDTO, Long id) {
        this.validate(escolaDTO);
        Optional<Escola> escolaExistente = this.escolaRepository.findById(id);

        if (escolaExistente.isPresent()) {
            Escola escolaJaExiste = escolaExistente.get();

            LOGGER.info("Atualizando escola, id: [{}]", escolaDTO.getId());

            escolaJaExiste.setNomeEscola(escolaDTO.getNomeEscola());
            escolaJaExiste.setEndereco(escolaDTO.getEndereco());
            escolaJaExiste.setTelefone(escolaDTO.getTelefone());
            escolaJaExiste.setCodigoEscola(escolaDTO.getCodigoEscola());
            escolaJaExiste = this.escolaRepository.save(escolaJaExiste);

            return escolaDTO.of(escolaJaExiste);
        }
        throw new IllegalArgumentException(String.format("ID %s não existe", id));
    }

    public void delete(Long id) {
        LOGGER.info("Delete em escola de id: ", id);
        this.escolaRepository.deleteById(id);
    }
}
