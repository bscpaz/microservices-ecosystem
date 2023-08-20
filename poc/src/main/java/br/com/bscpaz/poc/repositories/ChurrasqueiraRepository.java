package br.com.bscpaz.poc.repositories;

import br.com.bscpaz.poc.models.Churrasqueira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChurrasqueiraRepository extends JpaRepository<Churrasqueira, String> {

    List<Churrasqueira> findAll();

}
