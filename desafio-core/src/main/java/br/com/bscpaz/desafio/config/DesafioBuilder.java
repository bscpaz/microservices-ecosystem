package br.com.bscpaz.desafio.config;

import br.com.bscpaz.desafio.application.ports.DesafioOrchestrator;
import br.com.bscpaz.desafio.application.ports.impl.DesafioOrchestratorImpl;
import br.com.bscpaz.desafio.domain.ports.DesafioRepository;
import br.com.bscpaz.desafio.domain.services.DesafioService;
import br.com.bscpaz.desafio.domain.services.impl.DesafioServiceImpl;

public class DesafioBuilder {

    public static DesafioService getDesafioService(DesafioRepository desafioRepository) {
        return new DesafioServiceImpl(desafioRepository);
    }

    public static DesafioOrchestrator getDesafioOrchestrator(DesafioRepository desafioRepository) {
        DesafioService desafioService = getDesafioService(desafioRepository);
        return new DesafioOrchestratorImpl(desafioService);
    }

}