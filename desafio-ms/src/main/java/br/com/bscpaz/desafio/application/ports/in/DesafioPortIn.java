package br.com.bscpaz.desafio.application.ports.in;

import br.com.bscpaz.desafio.application.core.domains.Desafio;
import br.com.bscpaz.desafio.application.core.exceptions.NegocioException;

import java.util.List;

public interface DesafioPortIn {

    Desafio cadastrar(Desafio desafio) throws NegocioException;

    List<Desafio> listarTodos();

}
