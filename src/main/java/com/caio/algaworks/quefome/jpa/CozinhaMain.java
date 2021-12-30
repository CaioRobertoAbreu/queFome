package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.QueFomeApplication;
import com.caio.algaworks.quefome.model.Cozinha;
import com.caio.algaworks.quefome.repository.implementation.CozinhaRepositoryImpl;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Random;

public class CozinhaMain {

    public static void main(String[] args) {

        var context = new SpringApplicationBuilder(QueFomeApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        var cadastroCozinha = context.getBean(CozinhaRepositoryImpl.class);

        cadastroCozinha.cadastrar(new Cozinha(null, "Italiana", null));

        cadastroCozinha.listar()
                .forEach(cozinha -> System.out.println(cozinha.getNome()));

        var id = criaRandomComBaseNaQuantidadeElementos(cadastroCozinha.listar().size()).longValue();
        var cozinha = cadastroCozinha.buscarPorId(id);


        System.out.printf("%d - %s\n", cozinha.getId(), cozinha.getNome());

        cadastroCozinha.atualizar(id, "Japonesa");

        cadastroCozinha.listar()
                .forEach(cozinha2 -> System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome()));

        cadastroCozinha.deletarPorId(id);

        cadastroCozinha.listar()
                .forEach(cozinha2 -> System.out.printf("%d - %s\n", cozinha2.getId(), cozinha2.getNome()));
    }

    private static Integer criaRandomComBaseNaQuantidadeElementos(Integer qntElementos) {

        return new Random().nextInt(qntElementos + 1);
    }
}
