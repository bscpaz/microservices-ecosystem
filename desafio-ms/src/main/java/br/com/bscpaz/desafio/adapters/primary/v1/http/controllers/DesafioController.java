package br.com.bscpaz.desafio.adapters.primary.v1.http.controllers;

import br.com.bscpaz.desafio.adapters.primary.v1.http.dtos.DesafioDto;
import br.com.bscpaz.desafio.adapters.primary.v1.http.dtos.ResponseDto;
import br.com.bscpaz.desafio.application.ports.DesafioOrchestrator;
import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.services.DesafioService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
@AllArgsConstructor
public class DesafioController {

    private DesafioService desafioService;
    private DesafioOrchestrator desafioOrchestrator;

    @GetMapping
    public ResponseDto<List<DesafioDto>> listarTodos() {
        try {
            List<Desafio> desafios = desafioService.findAll();
            return new ResponseDto<>(DesafioDto.domainsToDtos(desafios), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST, "Erro ao listar todos.");
        }
    }

    @GetMapping("/{palavras}")
    public ResponseDto<List<DesafioDto>> findByPalavrasChave(@PathVariable String palavras) {
        try {
            List<Desafio> desafios = desafioOrchestrator.findByPalavraChave(palavras);
            return new ResponseDto<>(DesafioDto.domainsToDtos(desafios), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseDto<>(HttpStatus.BAD_REQUEST, "Erro ao listar todos.");
        }
    }

    @PostMapping
    public ResponseDto<DesafioDto> cadastrar(@RequestBody DesafioDto desafioDto) {
        try {
            Desafio desafio = DesafioDto.dtoToDomain(desafioDto);
            desafio = desafioService.save(desafio);
            return new ResponseDto<>(DesafioDto.domainToDto(desafio), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseDto<>(desafioDto, HttpStatus.BAD_REQUEST);
        }
    }
}
