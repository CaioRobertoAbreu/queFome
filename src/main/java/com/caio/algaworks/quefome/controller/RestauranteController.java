package com.caio.algaworks.quefome.controller;

import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.service.CadastroRestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quefome")
@AllArgsConstructor
public class RestauranteController {

    private final CadastroRestauranteService cadastroRestaurante;

    @GetMapping("/restaurantes")
    public ResponseEntity<List<Restaurante>> lista(){

        var restaurantes = cadastroRestaurante.lista();

        return ResponseEntity.ok().body(restaurantes);
    }

    @GetMapping("/restaurantes/{id}")
    public ResponseEntity<Restaurante> busca(@PathVariable Long id){

        var restaurante = cadastroRestaurante.busca(id);

        if(restaurante == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(restaurante);

    }
}
