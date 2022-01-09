package com.caio.algaworks.quefome.service;

import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadastroRestauranteService {

    private final RestauranteRepository repository;

    public List<Restaurante> lista(){

        return repository.listarTodos();
    }

    public Restaurante busca(Long idRestaurante){

       return repository.buscarPorId(idRestaurante);

    }
}
