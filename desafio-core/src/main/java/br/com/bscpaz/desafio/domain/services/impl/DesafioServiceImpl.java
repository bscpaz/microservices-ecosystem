package br.com.bscpaz.desafio.domain.services.impl;

import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.ports.DesafioRepository;
import br.com.bscpaz.desafio.domain.services.DesafioService;

import java.util.List;

public class DesafioServiceImpl implements DesafioService {

    private final DesafioRepository desafioRepository;

    public DesafioServiceImpl(DesafioRepository desafioRepository) {
        this.desafioRepository = desafioRepository;
    }

    @Override
    public Desafio save(Desafio desafio) {
        return desafioRepository.save(desafio);
    }

    @Override
    public List<Desafio> findAll() {
        return desafioRepository.findAll();
    }

    @Override
    public List<Desafio> findByPalavrasChave(final String palavrasChave) {
        if (palavrasChave == null || palavrasChave.trim().isEmpty()) {
            throw new IllegalArgumentException("A palavras-chave não pode ser nula ou vazia");
        }
        String palavrasChaveSearch = palavrasChave.replaceAll(" ", "%");
        return desafioRepository.findByPalavrasChave("%" + palavrasChaveSearch + "%");
    }
}
