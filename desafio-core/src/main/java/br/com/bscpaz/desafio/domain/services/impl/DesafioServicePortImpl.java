package br.com.bscpaz.desafio.domain.services.impl;

import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.ports.DesafioRepositoryPort;
import br.com.bscpaz.desafio.domain.services.DesafioServicePort;

import java.util.List;

public class DesafioServicePortImpl implements DesafioServicePort {

    private final DesafioRepositoryPort desafioRepositoryPort;

    public DesafioServicePortImpl(DesafioRepositoryPort desafioRepositoryPort) {
        this.desafioRepositoryPort = desafioRepositoryPort;
    }

    @Override
    public Desafio save(Desafio desafio) {
        return desafioRepositoryPort.save(desafio);
    }

    @Override
    public List<Desafio> findByPalavrasChave(final String palavrasChave) {
        if (palavrasChave == null || palavrasChave.trim().isEmpty()) {
            throw new IllegalArgumentException("A palavras-chave não pode ser nula ou vazia");
        }
        String palavrasChaveSearch = palavrasChave.replaceAll(" ", "%");
        return desafioRepositoryPort.findByPalavrasChave("%" + palavrasChaveSearch + "%");
    }
}
