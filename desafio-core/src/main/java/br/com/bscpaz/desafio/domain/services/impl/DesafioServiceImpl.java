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
}
