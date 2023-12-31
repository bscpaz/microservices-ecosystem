package br.com.bscpaz.desafio.adapters.primary.v1.http.controllers;

import br.com.bscpaz.desafio.adapters.primary.v1.http.dtos.DesafioDto;
import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.services.DesafioService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
@AllArgsConstructor
public class DesafioController {

    private DesafioService desafioService;

    @GetMapping
    public List<DesafioDto> listarTodos() {
        List<Desafio> desafios = desafioService.findAll();
        return DesafioDto.domainsToDtos(desafios);
    }

    @PostMapping
    public DesafioDto cadastrar(@RequestBody DesafioDto desafioDto) {
        Desafio desafio = DesafioDto.dtoToDomain(desafioDto);
        desafio = desafioService.save(desafio);
        return DesafioDto.domainToDto(desafio);
    }
}
