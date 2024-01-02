package br.com.bscpaz.desafio.application.ports.impl;

import br.com.bscpaz.desafio.application.exceptions.NegocioException;
import br.com.bscpaz.desafio.application.ports.DesafioOrchestratorPort;
import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.services.DesafioServicePort;

import java.util.List;

public class DesafioOrchestratorPortImpl implements DesafioOrchestratorPort {

    private final DesafioServicePort desafioServicePort;

    public DesafioOrchestratorPortImpl(DesafioServicePort desafioServicePort) {
        this.desafioServicePort = desafioServicePort;
    }

    @Override
    public List<Desafio> findByPalavraChave(String palavrasChave) throws NegocioException {
        return desafioServicePort.findByPalavrasChave(palavrasChave);
    }
}
