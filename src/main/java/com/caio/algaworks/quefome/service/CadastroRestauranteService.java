package com.caio.algaworks.quefome.service;

import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Cozinha;
import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.repository.CozinhaRepository;
import com.caio.algaworks.quefome.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadastroRestauranteService {

    private final RestauranteRepository restauranteRepository;
    private final CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante){
        var cozinha = cozinhaRepository.buscarPorId(restaurante.getCozinha().getId());

        if(cozinha == null) {

            throw new EntidadeNaoEncontradaException("Cozinha não encontrada");
        }


        return restauranteRepository.cadastrar(restaurante);
    }

    public List<Restaurante> lista(){

        return restauranteRepository.listarTodos();
    }

    public Restaurante busca(Long idRestaurante){

       return restauranteRepository.buscarPorId(idRestaurante);

    }

    public Restaurante atualizar(Long idRestaurante, Restaurante restaurante){

        var cozinha = cozinhaRepository.buscarPorId(restaurante.getCozinha().getId());

        if(cozinha == null){
            throw new EntidadeNaoEncontradaException("cozinha nao encontrada");
        }

        return restauranteRepository.atualizar(idRestaurante, restaurante);
    }
}
