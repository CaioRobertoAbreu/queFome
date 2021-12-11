package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.QueFomeApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Random;

public class CadastroCozinhaMain {

    public static void main(String[] args) {

        var context = new SpringApplicationBuilder(QueFomeApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        var cadastroCozinha = context.getBean(CadastroCozinha.class);

        cadastroCozinha.cadastrar("Italiana");

        cadastroCozinha.listar()
                .forEach(cozinha -> System.out.println(cozinha.getNome()));

        var id = criaRandomComBaseNaQuantidadeElementos(cadastroCozinha.listar().size()).longValue();
        var cozinha = cadastroCozinha.buscarPorId(id);


        System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());

        cadastroCozinha.atualizar(id, "Japonesa");

        cadastroCozinha.listar()
                .forEach(cozinha2 -> System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome()));
    }

    private static Integer criaRandomComBaseNaQuantidadeElementos(Integer qntElementos) {

        return new Random().nextInt(qntElementos + 1);
    }
}
