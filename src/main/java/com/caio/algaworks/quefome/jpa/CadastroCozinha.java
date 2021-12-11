package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Transactional
    public List<Cozinha> listar(){

        var entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT c FROM Cozinha c", Cozinha.class).getResultList();
    }

    public void cadastrar(String nome){

        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(new Cozinha(null, nome));
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
