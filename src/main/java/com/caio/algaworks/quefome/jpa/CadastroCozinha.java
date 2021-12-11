package com.caio.algaworks.quefome.jpa;

import com.caio.algaworks.quefome.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cozinha> listar(){

        return entityManager.createQuery("SELECT c FROM Cozinha c", Cozinha.class).getResultList();

    }
}
