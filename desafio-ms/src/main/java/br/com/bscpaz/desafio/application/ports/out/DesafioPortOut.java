package br.com.bscpaz.desafio.application.ports.out;

import br.com.bscpaz.desafio.application.core.domains.Desafio;

import java.util.List;

public interface DesafioPortOut {

    Desafio save(Desafio desafio);

    List<Desafio> findAll();
}
