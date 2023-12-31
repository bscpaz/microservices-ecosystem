package br.com.bscpaz.desafio.domain.ports;


import br.com.bscpaz.desafio.domain.entities.Desafio;

import java.util.List;

public interface DesafioRepository {

    Desafio save(Desafio desafio);

    List<Desafio> findAll();
}
