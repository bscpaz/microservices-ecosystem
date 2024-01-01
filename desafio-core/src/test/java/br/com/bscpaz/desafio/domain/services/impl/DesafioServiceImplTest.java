package br.com.bscpaz.desafio.domain.services.impl;

import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.ports.DesafioRepository;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesafioServiceImplTest extends TestCase {

    private static Desafio getDesafioJackBauer() {
        Desafio desafio = new Desafio();
        desafio.setId(1L);
        desafio.setPergunta("Quem é Jack Bauer do seriado 24 horas?");
        desafio.setResposta("Jack Bauer é um agente de campo experiente com formação militar.");
        desafio.setPalavrasChaves("Jack Bauer 24 horas");
        return desafio;
    }

    private static Desafio getDesafioNinaMyers() {
        Desafio desafio = new Desafio();
        desafio.setId(2L);
        desafio.setPergunta("Quem é Nina Myers do seriado 24 horas?");
        desafio.setResposta("Nina Myers é uma agente federal distinta e vice-diretora da CTU Los Angeles.");
        desafio.setPalavrasChaves("Nina Myers 24 horas");
        return desafio;
    }

    private static class DesafioRepositoryMock implements DesafioRepository {
        @Override
        public Desafio save(Desafio desafio) {
            desafio.setId(100L);
            return desafio;
        }

        @Override
        public List<Desafio> findAll() {
            List<Desafio> desafios = new ArrayList<>();
            desafios.add(getDesafioJackBauer());
            desafios.add(getDesafioNinaMyers());
            return desafios;
        }

        @Override
        public List<Desafio> findByPalavrasChave(String palavrasChave) {
            if (palavrasChave.equals("%Jack%Bauer%")) {
                List<Desafio> desafios = new ArrayList<>();
                desafios.add(getDesafioJackBauer());
                return desafios;
            }
            return Collections.emptyList();
        }
    }

    public void test_check_null_argument() {
        DesafioRepository desafioRepositoryMock = new DesafioRepositoryMock();
        DesafioServiceImpl desafioService = new DesafioServiceImpl(desafioRepositoryMock);

        try {
            desafioService.findByPalavrasChave(null);
            fail("Deveria ter lançado uma IllegalArgumentException para argumento nulo.");
        } catch (IllegalArgumentException e) {
            assertEquals("A palavras-chave não pode ser nula ou vazia", e.getMessage());
        }
    }

    public void test_check_empty_argument() {
        DesafioRepository desafioRepositoryMock = new DesafioRepositoryMock();
        DesafioServiceImpl desafioService = new DesafioServiceImpl(desafioRepositoryMock);

        try {
            desafioService.findByPalavrasChave("");
            fail("Deveria ter lançado uma IllegalArgumentException para argumento vazio.");
        } catch (IllegalArgumentException e) {
            assertEquals("A palavras-chave não pode ser nula ou vazia", e.getMessage());
        }
    }

    public void test_check_whitespaces_argument() {
        DesafioRepository desafioRepositoryMock = new DesafioRepositoryMock();
        DesafioServiceImpl desafioService = new DesafioServiceImpl(desafioRepositoryMock);

        try {
            desafioService.findByPalavrasChave("  ");
            fail("Deveria ter lançado uma IllegalArgumentException para argumento com espaços em branco.");
        } catch (IllegalArgumentException e) {
            assertEquals("A palavras-chave não pode ser nula ou vazia", e.getMessage());
        }
    }

    public void test_check_find_desafio() {
        DesafioRepository desafioRepositoryMock = new DesafioRepositoryMock();
        DesafioServiceImpl desafioService = new DesafioServiceImpl(desafioRepositoryMock);

        List<Desafio> result = desafioService.findByPalavrasChave("Jack Bauer");

        assertEquals(1, result.size());
        assertEquals(1L, result.get(0).getId().longValue());
    }

    public void test_check_nomatch_find() {
        DesafioRepository desafioRepositoryMock = new DesafioRepositoryMock();
        DesafioServiceImpl desafioService = new DesafioServiceImpl(desafioRepositoryMock);

        List<Desafio> result = desafioService.findByPalavrasChave("Tony Almeida");

        assertEquals(Collections.emptyList(), result);
    }
}