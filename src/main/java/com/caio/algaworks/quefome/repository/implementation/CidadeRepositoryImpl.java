package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.Cidade;
import com.caio.algaworks.quefome.repository.CidadeRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cidade cadastrar(Cidade cidade) {

        System.out.println("CADASTRANDO CIDADE...");
        return entityManager.merge(cidade);
    }

    @Override
    public List<Cidade> listarTodos() {

        System.out.println("======= LISTANDO CIDADES ==========");
        return entityManager.createQuery("SELECT c FROM Cidade c", Cidade.class).getResultList();
    }

    @Override
    public Cidade buscarPorId(Long id) {

        System.out.println("======= BUSCANDO POR ID ==========");
        return entityManager.find(Cidade.class, id);
    }

    @Override
    public void deletarPorId(Long id) {

        System.out.println("DELETANDO CIDADE...");
        entityManager.remove(buscarPorId(id));
    }
}
