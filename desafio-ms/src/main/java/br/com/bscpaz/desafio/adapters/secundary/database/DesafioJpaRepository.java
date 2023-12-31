package br.com.bscpaz.desafio.adapters.secundary.database;

import br.com.bscpaz.desafio.adapters.secundary.database.entities.DesafioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafioJpaRepository extends JpaRepository<DesafioEntity, Long> {
}
