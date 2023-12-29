package br.com.bscpaz.desafio.adapters.in.api.v1.controllers;

import br.com.bscpaz.desafio.adapters.in.api.v1.dtos.DesafioDto;
import br.com.bscpaz.desafio.application.core.domains.Desafio;
import br.com.bscpaz.desafio.application.core.exceptions.NegocioException;
import br.com.bscpaz.desafio.application.ports.in.DesafioPortIn;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desafios")
@AllArgsConstructor
public class DesafioController {

    private DesafioPortIn desafioPortIn;

    @GetMapping
    public List<DesafioDto> listarTodos() {
        List<Desafio> desafios = desafioPortIn.listarTodos();
        return DesafioDto.domainsToDtos(desafios);
    }

    @PostMapping
    public DesafioDto cadastrar(@RequestBody DesafioDto desafioDto) {
        Desafio desafio = DesafioDto.dtoToDomain(desafioDto);
        try {
            desafio = desafioPortIn.cadastrar(desafio);
        } catch (NegocioException e) {
            throw new RuntimeException(e);
        }
        return DesafioDto.domainToDto(desafio);
    }
}
