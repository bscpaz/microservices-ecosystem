package br.com.bscpaz.poc.controllers.v1;

import br.com.bscpaz.poc.infra.ApiVersions;
import br.com.bscpaz.poc.services.ChurrasqueiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
        path = ApiVersions.V1 + ChurrasqueiraController.PATH,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ChurrasqueiraController {

    public final static String PATH = "/transaction";

    @Autowired
    private ChurrasqueiraService service;

    @GetMapping
    public void getRequiresNew(){
        service.findAll();
    }

}
