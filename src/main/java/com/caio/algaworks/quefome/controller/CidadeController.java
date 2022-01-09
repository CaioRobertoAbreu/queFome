package com.caio.algaworks.quefome.controller;


import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Cidade;
import com.caio.algaworks.quefome.service.CadastroCidadeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/quefome")
@AllArgsConstructor
public class CidadeController {

    private final CadastroCidadeService cadastroCidade;

    @GetMapping("/cidades")
    public ResponseEntity<List<Cidade>> lista(){

        var cidades = cadastroCidade.lista();

        return ResponseEntity.ok().body(cidades);
    }

    @GetMapping("/cidades/{id}")
    public ResponseEntity<Cidade> busca(@PathVariable Long id){

        var cidade = cadastroCidade.busca(id);

        if(cidade == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(cidade);
    }

    @PostMapping("/cidades")
    public ResponseEntity<Object> cadastra(@RequestBody Cidade cidade){

        try {
            var cidadeCadastrada = cadastroCidade.salvar(cidade);

            var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                    .path("/{id}")
                    .buildAndExpand(cidadeCadastrada.getId())
                    .toUri();

            return ResponseEntity.created(uri).build();

        }catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/cidades/{id}")
    public ResponseEntity<Object> atualiza(@RequestBody Cidade cidade, @PathVariable Long id){

        try{
            var cidaddeAtual = cadastroCidade.atualizar(id, cidade);

            if(cidaddeAtual == null){

                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/cidades/{id}")
    public ResponseEntity<?> exclui(@PathVariable Long id){

        try{
            cadastroCidade.excluir(id);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.notFound().build();

        }

    }
}
