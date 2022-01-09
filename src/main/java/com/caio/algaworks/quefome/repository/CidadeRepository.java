package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Cidade;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CidadeRepository {

    @Transactional
    Cidade cadastrar(Cidade cidade);

    @Transactional
    List<Cidade> listarTodos();

    @Transactional
    Cidade buscarPorId(Long id);

    @Transactional
    Cidade atualizar(Long idObjeto, String novoNomeObjeto);

    @Transactional
    void deletarPorId(Long id);
}
