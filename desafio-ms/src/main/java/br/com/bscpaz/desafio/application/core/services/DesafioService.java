package br.com.bscpaz.desafio.application.core.services;

import br.com.bscpaz.desafio.application.core.domains.Desafio;
import br.com.bscpaz.desafio.application.core.exceptions.NegocioException;
import br.com.bscpaz.desafio.application.ports.in.DesafioPortIn;
import br.com.bscpaz.desafio.application.ports.out.DesafioPortOut;

import java.util.List;

public class DesafioService implements DesafioPortIn {

    private final DesafioPortOut desafioPortOut;

    public DesafioService(DesafioPortOut desafioPortOut) {
        this.desafioPortOut = desafioPortOut;
    }

    @Override
    public Desafio cadastrar(Desafio desafio) throws NegocioException {
        validarDados(desafio);
        return desafioPortOut.save(desafio);
    }

    @Override
    public List<Desafio> listarTodos() {
        return desafioPortOut.findAll();
    }

    private void validarDados(Desafio desafio) throws NegocioException {
        if (desafio.getPergunta() == null || desafio.getPergunta().trim().isEmpty()) {
            throw new NegocioException("A pergunta não pode ser vazia");
        }

        if (desafio.getResposta() == null || desafio.getResposta().trim().isEmpty()) {
            throw new NegocioException("A resposta não pode ser vazia");
        }
    }
}
