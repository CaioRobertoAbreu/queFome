package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Cozinha> listar(){

        return entityManager.createQuery("SELECT c FROM Cozinha c", Cozinha.class).getResultList();
    }

    @Transactional
    public void cadastrar(String nome){

        entityManager.persist(new Cozinha(null, nome));
    }
}
