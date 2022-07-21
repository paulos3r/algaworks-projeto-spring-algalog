package com.paulos3r.projetoapispring.controller;

import com.paulos3r.projetoapispring.model.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @GetMapping("/client")
    public List<Client> getClient(){
        return manager.createQuery("from client", Client.class)
                .getResultList();
    }
}
