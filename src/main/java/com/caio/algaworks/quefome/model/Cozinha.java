package com.caio.algaworks.quefome.model;

import lombok.Getter;

import javax.persistence.*;

@Table(name = "table_cozinha")
@Entity
@Getter
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

}
