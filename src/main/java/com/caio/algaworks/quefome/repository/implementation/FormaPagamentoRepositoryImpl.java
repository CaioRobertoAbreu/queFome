package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.FormaPagamento;
import com.caio.algaworks.quefome.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public FormaPagamento buscarPorId(Long id) {

        return entityManager.find(FormaPagamento.class, id);
    }

    @Override
    public List<FormaPagamento> listarTodas() {

        return entityManager.createQuery("SELECT fp FROM FormaPagamento fp", FormaPagamento.class).getResultList();
    }

    @Override
    public void deletarPorId(Long id) {

        var formaPagamento = buscarPorId(id);
        entityManager.remove(formaPagamento);
    }
}
