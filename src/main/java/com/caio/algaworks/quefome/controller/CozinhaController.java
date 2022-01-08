package com.caio.algaworks.quefome.controller;

import com.caio.algaworks.quefome.exception.EntidadeEmUsoException;
import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Cozinha;
import com.caio.algaworks.quefome.repository.implementation.CozinhaRepositoryImpl;
import com.caio.algaworks.quefome.service.CadastroCozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/quefome")
@AllArgsConstructor
public class CozinhaController {

    private CozinhaRepositoryImpl cozinhaRepository;
    private CadastroCozinhaService cadastroCozinha;

    @GetMapping("/cozinhas")
    public ResponseEntity<List<Cozinha>> lista(){

        var cozinhas = cadastroCozinha.listar();

        return ResponseEntity.ok(cozinhas);
    }

    @GetMapping("/cozinhas/{id}")
    public ResponseEntity<Cozinha> busca(@PathVariable("id") Long idCozinha){

        var cozinha = cadastroCozinha.buscar(idCozinha);

        if(cozinha == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cozinha);
    }

    @PostMapping("/cozinhas")
    public ResponseEntity<Object> cadastra(@RequestBody Cozinha cozinha){

        var cozinhaCadastrada = cadastroCozinha.salvar(cozinha);

        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                                    .path("/{id}")
                                    .buildAndExpand(cozinhaCadastrada.getId())
                                    .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/cozinhas/{id}")
    public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody Cozinha cozinha){

        var cozinhaAtual = cadastroCozinha.atualizar(id, cozinha);

        if(cozinhaAtual == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/cozinhas/{id}")
    public ResponseEntity<?> exclui(@PathVariable Long id){

        try{
            cadastroCozinha.excluir(id);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.notFound().build();

        }catch (EntidadeEmUsoException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
