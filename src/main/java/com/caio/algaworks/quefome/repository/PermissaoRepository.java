package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.Permissao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository {

    Permissao cadastrar(Permissao permissao);

    Permissao buscarPorId(Long id);

    List<Permissao> listarTodas();

    void deletarPorId(Long id);

}
