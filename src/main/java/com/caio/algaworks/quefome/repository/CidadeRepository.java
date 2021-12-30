package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository {

    Cidade cadastrar(Cidade cidade);

    List<Cidade> listarTodos();

    Cidade buscarPorId(Long id);

    void deletarPorId(Long id);
}
