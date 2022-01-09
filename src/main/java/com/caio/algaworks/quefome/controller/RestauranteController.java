package com.caio.algaworks.quefome.controller;

import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.service.CadastroRestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PostMapping("/restaurantes")
    public ResponseEntity<Object> cadastra(@RequestBody Restaurante restaurante){

        try {
            var restauranteCadastrado = cadastroRestaurante.salvar(restaurante);

            var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(restauranteCadastrado.getId())
                    .toUri();

            return ResponseEntity.created(uri).build();

        }catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/restaurantes/{id}")
    public ResponseEntity<Object> atualiza(@RequestBody Restaurante restaurante, @PathVariable Long id){

        try{
            var restauranteAtual = cadastroRestaurante.atualizar(id, restaurante);

            if(restauranteAtual == null){

                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }



    }
}
