package com.caio.algaworks.quefome.controller;

import com.caio.algaworks.quefome.exception.EntidadeEmUsoException;
import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Estado;
import com.caio.algaworks.quefome.service.CadastroEstadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/quefome")
@AllArgsConstructor
public class EstadoController {

    private CadastroEstadoService cadastroEstado;

    @GetMapping(value = "/estados")
    public ResponseEntity<List<Estado>> listarEstados(){

        var estados = cadastroEstado.lista();

        return ResponseEntity.ok(estados);
    }

    @GetMapping("/estados/{id}")
    public ResponseEntity<Estado> busca(@PathVariable("id") Long idEstado){

        var estado = cadastroEstado.busca(idEstado);

        if(estado == null) {

            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(estado);
    }

    @PostMapping("/estados")
    public ResponseEntity<Object> cadastra(@RequestBody Estado estado){

        var estadoCadastrado = cadastroEstado.salvar(estado);

        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(estadoCadastrado.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/estados/{id}")
    public ResponseEntity<?> atualiza(@PathVariable Long id, @RequestBody Estado estado){

        var estadoAtual = cadastroEstado.atualizar(id, estado);

        if(estadoAtual == null){

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/estados/{id}")
    public ResponseEntity<?> exclui(@PathVariable Long id){

        try{
            cadastroEstado.excluir(id);
            return ResponseEntity.noContent().build();

        }catch (EntidadeNaoEncontradaException e){

            return ResponseEntity.notFound().build();

        }catch (EntidadeEmUsoException e){

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
