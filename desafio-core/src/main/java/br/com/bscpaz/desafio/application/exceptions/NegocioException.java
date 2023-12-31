package br.com.bscpaz.desafio.application.exceptions;

public class NegocioException extends Exception {

    public NegocioException() {
        super();
    }

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Exception e) {
        super(msg, e);
    }
}
