package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Cozinha;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CozinhaRepository {

    @Transactional
    void cadastrar(String nome);

    @Transactional
    Cozinha buscarPorId(Long id);

    @Transactional
    List<Cozinha> listar();

    @Transactional
    void atualizar(Long idObjeto, String novoNomeObjeto);

    @Transactional
    void deletarPorId(Long id);



}
