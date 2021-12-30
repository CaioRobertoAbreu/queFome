package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Estado;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository {

    Estado cadastrar(Estado estado);

    List<Estado> listarTodos();

    Estado buscarPorId(Long id);

    void deletarPorId(Long id);
}
