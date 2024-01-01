package br.com.bscpaz.desafio.application.ports.impl;

import br.com.bscpaz.desafio.application.exceptions.NegocioException;
import br.com.bscpaz.desafio.application.ports.DesafioOrchestrator;
import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.services.DesafioService;

import java.util.List;

public class DesafioOrchestratorImpl implements DesafioOrchestrator {

    private final DesafioService desafioService;

    public DesafioOrchestratorImpl(DesafioService desafioService) {
        this.desafioService = desafioService;
    }

    @Override
    public List<Desafio> findByPalavraChave(String palavrasChave) throws NegocioException {
        return desafioService.findByPalavrasChave(palavrasChave);
    }
}
