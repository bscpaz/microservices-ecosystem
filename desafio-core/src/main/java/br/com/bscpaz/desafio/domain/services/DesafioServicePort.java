package br.com.bscpaz.desafio.domain.services;

import br.com.bscpaz.desafio.domain.entities.Desafio;

import java.util.List;

public interface DesafioServicePort {

    Desafio save(Desafio desafio);

    List<Desafio> findByPalavrasChave(String palavrasChave);

}
