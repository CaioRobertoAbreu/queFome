package com.caio.algaworks.quefome.controller;

import com.caio.algaworks.quefome.model.Estado;
import com.caio.algaworks.quefome.repository.implementation.EstadoRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quefome")
@AllArgsConstructor
public class EstadoController {

    private EstadoRepositoryImpl estadoRepository;

    @GetMapping(value = "/estados")
    public ResponseEntity<List<Estado>> listarEstados(){

        var estados = estadoRepository.listarTodos();

        return ResponseEntity.ok(estados);

    }

}
