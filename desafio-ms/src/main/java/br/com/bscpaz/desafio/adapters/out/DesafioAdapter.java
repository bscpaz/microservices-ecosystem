package br.com.bscpaz.desafio.adapters.out;

import br.com.bscpaz.desafio.application.core.domains.Desafio;
import br.com.bscpaz.desafio.application.ports.out.DesafioPortOut;
import br.com.bscpaz.desafio.infra.entities.DesafioEntity;
import br.com.bscpaz.desafio.infra.repositories.DesafioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesafioAdapter implements DesafioPortOut {

    @Autowired
    private DesafioRepository desafioRepository;

    @Override
    public Desafio save(Desafio desafio) {
        DesafioEntity desafioEntity = DesafioEntity.domainToEntity(desafio);
        desafioEntity = desafioRepository.save(desafioEntity);
        return DesafioEntity.entityToDomain(desafioEntity);
    }

    @Override
    public List<Desafio> findAll() {
        List<DesafioEntity> desafiosEntities = desafioRepository.findAll();
        return DesafioEntity.entitiesToDomains(desafiosEntities);
    }
}
