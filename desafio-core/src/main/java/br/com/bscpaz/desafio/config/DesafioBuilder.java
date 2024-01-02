package br.com.bscpaz.desafio.config;

import br.com.bscpaz.desafio.application.ports.DesafioOrchestratorPort;
import br.com.bscpaz.desafio.application.ports.impl.DesafioOrchestratorPortImpl;
import br.com.bscpaz.desafio.domain.ports.DesafioRepositoryPort;
import br.com.bscpaz.desafio.domain.services.DesafioServicePort;
import br.com.bscpaz.desafio.domain.services.impl.DesafioServicePortImpl;

public class DesafioBuilder {

    public static DesafioServicePort getDesafioService(DesafioRepositoryPort desafioRepositoryPort) {
        return new DesafioServicePortImpl(desafioRepositoryPort);
    }

    public static DesafioOrchestratorPort getDesafioOrchestrator(DesafioRepositoryPort desafioRepositoryPort) {
        DesafioServicePort desafioServicePort = getDesafioService(desafioRepositoryPort);
        return new DesafioOrchestratorPortImpl(desafioServicePort);
    }

}