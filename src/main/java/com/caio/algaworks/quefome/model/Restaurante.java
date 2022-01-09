package com.caio.algaworks.quefome.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Setter
    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    @Setter
    private BigDecimal taxaFrete;

    private Boolean ativo;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Setter
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cozinha cozinha;

}
