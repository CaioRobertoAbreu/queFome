package com.caio.algaworks.quefome.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "table_restaurante")
@Entity
@Getter
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;
    private Boolean ativo;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
}
