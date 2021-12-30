package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.FormaPagamento;
import com.caio.algaworks.quefome.model.Permissao;
import com.caio.algaworks.quefome.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PermissaoRepositoryImpl implements PermissaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Permissao cadastrar(Permissao permissao) {

        return entityManager.merge(permissao);
    }

    @Override
    public Permissao buscarPorId(Long id) {

        return entityManager.find(Permissao.class, id);
    }

    @Override
    public List<Permissao> listarTodas() {

        return entityManager.createQuery("SELECT fp FROM FormaPagamento fp", Permissao.class).getResultList();
    }

    @Override
    public void deletarPorId(Long id) {

        var permisao = buscarPorId(id);
        entityManager.remove(permisao);
    }
}
