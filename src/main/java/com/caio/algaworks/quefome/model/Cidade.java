package com.caio.algaworks.quefome.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false)
    @Setter
    private Estado estado;

}
