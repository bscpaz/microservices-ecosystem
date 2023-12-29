package br.com.bscpaz.desafio.application.core.domains;

import java.io.Serializable;
import java.util.Objects;

public class Desafio implements Serializable {

    private Long id;

    private String pergunta;

    private String resposta;

    private String palavrasChaves;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String getPalavrasChaves() {
        return palavrasChaves;
    }

    public void setPalavrasChaves(String palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desafio desafio = (Desafio) o;
        return Objects.equals(id, desafio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
