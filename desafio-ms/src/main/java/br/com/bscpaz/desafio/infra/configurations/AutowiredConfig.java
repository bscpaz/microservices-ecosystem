package br.com.bscpaz.desafio.infra.configurations;

import br.com.bscpaz.desafio.adapters.out.DesafioAdapter;
import br.com.bscpaz.desafio.application.core.services.DesafioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfig {

    @Bean
    public DesafioService createDesafioService(DesafioAdapter desafioAdapter) {
        return new DesafioService(desafioAdapter);
    }
}
