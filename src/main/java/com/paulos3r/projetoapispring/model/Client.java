package com.paulos3r.projetoapispring.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Client {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String telephone;
}
