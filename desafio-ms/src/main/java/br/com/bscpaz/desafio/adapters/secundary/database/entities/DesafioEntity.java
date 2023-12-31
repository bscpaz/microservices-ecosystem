package br.com.bscpaz.desafio.adapters.secundary.database.entities;

import br.com.bscpaz.desafio.domain.entities.Desafio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_desafio")
public class DesafioEntity {

    @Id
    @Column(name = "id_desafio", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_tb_desafio")
    private Long id;

    @Column(name = "ds_pergunta", nullable = false)
    private String pergunta;

    @Column(name = "ds_resposta", nullable = false)
    private String resposta;

    @Column(name = "ds_chaves")
    private String palavrasChaves;

    @Transient
    public static DesafioEntity domainToEntity(Desafio domain) {
        DesafioEntity entity = new DesafioEntity();
        BeanUtils.copyProperties(domain, entity);
        return entity;
    }

    @Transient
    public static Desafio entityToDomain(DesafioEntity entity) {
        Desafio domain = new Desafio();
        BeanUtils.copyProperties(entity, domain);
        return domain;
    }

    @Transient
    public static List<Desafio> entitiesToDomains(List<DesafioEntity> entities) {
        return entities.stream().map(item -> {
            Desafio desafio = new Desafio();
            desafio.setId(item.getId());
            desafio.setPergunta(item.getPergunta());
            desafio.setResposta(item.getResposta());
            desafio.setPalavrasChaves(item.getPalavrasChaves());
            return desafio;
        }).collect(Collectors.toList());
    }
}
