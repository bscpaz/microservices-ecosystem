package br.com.bscpaz.desafio.config;

import br.com.bscpaz.desafio.adapters.secundary.database.DesafioAdapter;
import br.com.bscpaz.desafio.domain.services.DesafioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutowiredConfig {

    @Bean
    public DesafioService createDesafioService(DesafioAdapter desafioAdapter) {
        return DesafioBuilder.getDesafioService(desafioAdapter);
    }
}
