package com.caio.algaworks.quefome.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "table_restaurante")
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

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    private Boolean ativo;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @Setter
    private LocalDateTime dataAtualizacao;

}
