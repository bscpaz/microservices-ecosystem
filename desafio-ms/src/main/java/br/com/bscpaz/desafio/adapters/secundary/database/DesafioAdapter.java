package br.com.bscpaz.desafio.adapters.secundary.database;

import br.com.bscpaz.desafio.domain.entities.Desafio;
import br.com.bscpaz.desafio.domain.ports.DesafioRepository;
import br.com.bscpaz.desafio.adapters.secundary.database.entities.DesafioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DesafioAdapter implements DesafioRepository {

    @Autowired
    private DesafioJpaRepository desafioJpaRepository;

    @Override
    public Desafio save(Desafio desafio) {
        DesafioEntity desafioEntity = DesafioEntity.domainToEntity(desafio);
        desafioEntity = desafioJpaRepository.save(desafioEntity);
        return DesafioEntity.entityToDomain(desafioEntity);
    }

    @Override
    public List<Desafio> findAll() {
        List<DesafioEntity> desafiosEntities = desafioJpaRepository.findAll();
        return DesafioEntity.entitiesToDomains(desafiosEntities);
    }

    @Override
    public List<Desafio> findByPalavrasChave(String palavrasChave) {
        List<DesafioEntity> desafiosEntities = desafioJpaRepository.findByPalavrasChaves(palavrasChave);
        return DesafioEntity.entitiesToDomains(desafiosEntities);
    }
}
