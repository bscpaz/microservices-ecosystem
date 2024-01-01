package br.com.bscpaz.desafio.adapters.secundary.database;

import br.com.bscpaz.desafio.adapters.secundary.database.entities.DesafioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DesafioJpaRepository extends JpaRepository<DesafioEntity, Long> {

    @Query("SELECT d FROM DesafioEntity d WHERE d.palavrasChaves ILIKE :palavrasChave")
    List<DesafioEntity> findByPalavrasChaves(@Param("palavrasChave") String palavrasChave);
}
