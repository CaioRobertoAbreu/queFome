package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.QueFomeApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

public class CadastroCozinhaMain {

    public static void main(String[] args) {

        var context = new SpringApplicationBuilder(QueFomeApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        var cadastroCozinha = context.getBean(CadastroCozinha.class);

        cadastroCozinha.cadastrar("Italiana");

        cadastroCozinha.listar()
                .forEach(cozinha -> System.out.println(cozinha.getNome()));
    }
}
