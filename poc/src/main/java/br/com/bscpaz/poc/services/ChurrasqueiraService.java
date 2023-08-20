package br.com.bscpaz.poc.services;

import br.com.bscpaz.poc.models.Churrasqueira;
import br.com.bscpaz.poc.repositories.ChurrasqueiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChurrasqueiraService {

    @Autowired
    private ChurrasqueiraRepository repository;

    public List<Churrasqueira> findAll() {
        return repository.findAll();
    }
}
