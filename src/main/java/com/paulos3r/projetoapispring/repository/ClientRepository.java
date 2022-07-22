package com.paulos3r.projetoapispring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.paulos3r.projetoapispring.model.Client;

import java.util.List;

@Repository
public interface ClientRepository  extends JpaRepository<Client, Long> {

    List<Client> findByName(String name);
}
