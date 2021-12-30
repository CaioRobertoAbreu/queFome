package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.Estado;
import com.caio.algaworks.quefome.repository.EstadoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Estado cadastrar(Estado estado) {

        System.out.println("CADASTRANDO ESTADO...");
        return entityManager.merge(estado);
    }

    @Override
    public List<Estado> listarTodos() {

        System.out.println("======= LISTANDO ESTADOS ==========");
        return entityManager.createQuery("SELECT e FROM Estado e", Estado.class).getResultList();
    }

    @Override
    public Estado buscarPorId(Long id) {

        System.out.println("======= BUSCANDO POR ID ==========");
        return entityManager.find(Estado.class, id);
    }

    @Override
    public void deletarPorId(Long id) {

        System.out.println("DELETANDO ESTADO...");
        entityManager.remove(buscarPorId(id));
    }
}
