package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RestauranteRepository {

    @Transactional
    Restaurante cadastrar(Restaurante restaurante);

    @Transactional
    List<Restaurante> listarTodos();

    @Transactional
    Restaurante buscarPorId(Long id);

    @Transactional
    Restaurante atualizar(Long idObjeto, Restaurante atualizaRestaurante);

    @Transactional
    void deletarPorId(Long id);

}
