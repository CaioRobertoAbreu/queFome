package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.QueFomeApplication;
import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.repository.implementation.RestauranteRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.math.BigDecimal;

public class RestauranteMain {

    public static void main(String[] args) {

        var context = new SpringApplicationBuilder(QueFomeApplication.class)
                                                                            .web(WebApplicationType.NONE)
                                                                            .run(args);

        var cadastroRestaurante = context.getBean(RestauranteRepositoryImpl.class);

        cadastroRestaurante.cadastrar(Restaurante.builder()
                                                .nome("Delicias da Tata")
                                                .taxaFrete(BigDecimal.valueOf(3.))
                                                .ativo(true)
                                                .build());

        cadastroRestaurante.cadastrar(Restaurante.builder()
                                                .nome("Açaí da Nina")
                                                .taxaFrete(BigDecimal.valueOf(4.))
                                                .ativo(true)
                                                .build());

        cadastroRestaurante.listarTodos().forEach(restaurante ->
                System.out.printf("%d - %s%n", restaurante.getId(), restaurante.getNome()));

        System.out.println(cadastroRestaurante.buscarPorId(1L).getNome());

        cadastroRestaurante.atualizar(2L, "Point XVIII");

        cadastroRestaurante.listarTodos().forEach(restaurante ->
            System.out.printf("%d - %s - %s %n", restaurante.getId(), restaurante.getNome(), restaurante.getDataAtualizacao()));


        cadastroRestaurante.deletarPorId(2L);

        cadastroRestaurante.listarTodos().forEach(restaurante ->
                System.out.printf("%d - %s%n", restaurante.getId(), restaurante.getNome()));
    }
}
