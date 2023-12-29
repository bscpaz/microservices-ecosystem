package br.com.bscpaz.desafio.infra.repositories;

import br.com.bscpaz.desafio.infra.entities.DesafioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafioRepository extends JpaRepository<DesafioEntity, Long> {
}
