package com.paulos3r.projetoapispring.controller;

import com.paulos3r.projetoapispring.model.Client;
import com.paulos3r.projetoapispring.repository.ClientRepository;
import com.sun.jdi.VoidValue;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping()
    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findClient(@PathVariable long id){
//        Optional<Client> client;
//        client = clientRepository.findById(id);
//
//        if( client.isPresent()){
//            return ResponseEntity.ok(client.get());
//        }
//
//        return ResponseEntity.notFound().build();
        return clientRepository.findById(id)
                .map(client -> ResponseEntity.ok(client))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@Valid @RequestBody Client client){
        return clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,@Valid @RequestBody Client client){
        if(!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        client.setId(id);
        client = clientRepository.save(client);

        return ResponseEntity.ok(client);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id){
        if (!clientRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        clientRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
