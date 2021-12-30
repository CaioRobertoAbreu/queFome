package com.caio.algaworks.quefome.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

}
