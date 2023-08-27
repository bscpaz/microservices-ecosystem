package br.com.bscpaz.poc.services;

import br.com.bscpaz.poc.models.Churrasqueira;
import br.com.bscpaz.poc.repositories.ChurrasqueiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChurrasqueiraService {

    @Autowired
    private ChurrasqueiraRepository churrasqueiraRepository;

    public List<Churrasqueira> findAll() {
        return churrasqueiraRepository.findAll();
    }

    @Transactional
    public void requiresNew() {
        Churrasqueira churrasqueira = new Churrasqueira();
        churrasqueira.setSetor("Setor X");

        innerRequiresNewMethod();

        churrasqueiraRepository.save(churrasqueira);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void innerRequiresNewMethod() {

    }
}
