package br.com.bscpaz.desafio.domain.services;

import br.com.bscpaz.desafio.domain.entities.Desafio;

import java.util.List;

public interface DesafioService {

    Desafio save(Desafio desafio);

    List<Desafio> findAll();

    List<Desafio> findByPalavrasChave(String palavrasChave);

}
