package br.com.bscpaz.desafio.application.ports;

import br.com.bscpaz.desafio.application.exceptions.NegocioException;
import br.com.bscpaz.desafio.domain.entities.Desafio;

import java.util.List;

public interface DesafioOrchestrator {

    List<Desafio> findByPalavraChave(String palavraChave) throws NegocioException;

}
