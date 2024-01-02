package br.com.bscpaz.desafio.config;

import br.com.bscpaz.desafio.adapters.secundary.database.DesafioAdapter;
import br.com.bscpaz.desafio.application.ports.DesafioOrchestratorPort;
import br.com.bscpaz.desafio.domain.services.DesafioServicePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfig {

    @Bean
    public DesafioServicePort createDesafioService(DesafioAdapter desafioAdapter) {
        return DesafioBuilder.getDesafioService(desafioAdapter);
    }

    @Bean
    public DesafioOrchestratorPort createDesafioOrchestratore(DesafioAdapter desafioAdapter) {
        return DesafioBuilder.getDesafioOrchestrator(desafioAdapter);
    }
}
