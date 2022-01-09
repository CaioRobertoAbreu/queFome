package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Estado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EstadoRepository {

    @Transactional
    Estado cadastrar(Estado estado);

    @Transactional
    List<Estado> listarTodos();

    @Transactional
    Estado buscarPorId(Long id);

    @Transactional
    Estado atualizar(Long idObjeto, String novoNomeObjeto);

    @Transactional
    void deletarPorId(Long id);
}
