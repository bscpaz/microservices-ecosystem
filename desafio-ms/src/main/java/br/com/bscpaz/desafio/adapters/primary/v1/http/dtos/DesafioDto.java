package br.com.bscpaz.desafio.adapters.primary.v1.http.dtos;

import br.com.bscpaz.desafio.adapters.secundary.database.entities.DesafioEntity;
import br.com.bscpaz.desafio.domain.entities.Desafio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DesafioDto {

    private Long id;

    private String pergunta;

    private String resposta;

    private String palavrasChaves;

    public static DesafioDto domainToDto(Desafio domain) {
        DesafioDto dto = new DesafioDto();
        BeanUtils.copyProperties(domain, dto);
        return dto;
    }

    public static Desafio dtoToDomain(DesafioDto dto) {
        Desafio domain = new Desafio();
        BeanUtils.copyProperties(dto, domain);
        return domain;
    }

    public static List<DesafioDto> domainsToDtos(List<Desafio> domains) {
        return domains.stream().map(item -> {
            DesafioDto dto = new DesafioDto();
            dto.setId(item.getId());
            dto.setPergunta(item.getPergunta());
            dto.setResposta(item.getResposta());
            dto.setPalavrasChaves(item.getPalavrasChaves());
            return dto;
        }).collect(Collectors.toList());
    }

    public static List<DesafioDto> entitiesToDtos(List<DesafioEntity> entities) {
        return entities.stream().map(item -> {
            DesafioDto dto = new DesafioDto();
            dto.setId(item.getId());
            dto.setPergunta(item.getPergunta());
            dto.setResposta(item.getResposta());
            dto.setPalavrasChaves(item.getPalavrasChaves());
            return dto;
        }).collect(Collectors.toList());
    }

}
