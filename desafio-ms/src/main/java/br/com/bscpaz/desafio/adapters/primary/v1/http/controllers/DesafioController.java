package br.com.bscpaz.desafio.adapters.primary.v1.http.controllers;

import br.com.bscpaz.desafio.adapters.primary.v1.http.dtos.DesafioDto;
import br.com.bscpaz.desafio.adapters.primary.v1.http.dtos.ResponseDto;
import br.com.bscpaz.desafio.adapters.secundary.database.DesafioJpaRepository;
import br.com.bscpaz.desafio.adapters.secundary.database.entities.DesafioEntity;
import br.com.bscpaz.desafio.application.ports.DesafioOrchestratorPort;
import br.com.bscpaz.desafio.config.ApiVersions;
import br.com.bscpaz.desafio.domain.entities.Desafio;

import br.com.bscpaz.desafio.domain.services.DesafioServicePort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = ApiVersions.V1 + DesafioController.PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class DesafioController {

    public final static String PATH = "/desafios";

    private DesafioServicePort desafioServicePort;
    private DesafioOrchestratorPort desafioOrchestratorPort;

    @Autowired
    private DesafioJpaRepository desafioJpaRepository;

    @GetMapping
    public ResponseDto<List<DesafioDto>> listarTodos() {
        try {
            //Some services can bypass hexagonal-architecture as they are very simple.
            List<DesafioEntity> desafios = desafioJpaRepository.findAll();
            return new ResponseDto<>(DesafioDto.entitiesToDtos(desafios), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST, "Erro ao listar todos.");
        }
    }

    @GetMapping("/{palavras}")
    public ResponseDto<List<DesafioDto>> pesquisarPorPalavrasChave(@PathVariable String palavras) {
        try {
            List<Desafio> desafios = desafioOrchestratorPort.findByPalavraChave(palavras);
            return new ResponseDto<>(DesafioDto.domainsToDtos(desafios), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST, "Erro ao listar todos.");
        }
    }

    @PostMapping
    public ResponseDto<DesafioDto> cadastrar(@RequestBody DesafioDto desafioDto) {
        try {
            Desafio desafio = DesafioDto.dtoToDomain(desafioDto);
            desafio = desafioServicePort.save(desafio);
            return new ResponseDto<>(DesafioDto.domainToDto(desafio), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseDto<>(desafioDto, HttpStatus.BAD_REQUEST);
        }
    }
}
