package com.caio.algaworks.quefome.repository.implementation;


import com.caio.algaworks.quefome.model.Restaurante;
import com.caio.algaworks.quefome.repository.RestauranteRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Restaurante cadastrar(Restaurante restaurante) {

        return entityManager.merge(restaurante);
    }

    @Override
    public List<Restaurante> listarTodos() {

        System.out.println("---------- LISTANDO RESTAURANTES ------------");
        return entityManager.createQuery("SELECT r FROM Restaurante r", Restaurante.class)
                            .getResultList();
    }

    @Override
    public Restaurante buscarPorId(Long id) {

        System.out.println("---------- BUSCANDO RESTAURANTE POR ID ------------");
        return entityManager.find(Restaurante.class, id);
    }

    @Override
    public Restaurante atualizar(Long idObjeto, Restaurante atualizaRestaurante) {

        var restaurante = buscarPorId(idObjeto);

        if (restaurante == null) {

            return null;
        }

        restaurante.setNome(atualizaRestaurante.getNome());
        restaurante.setTaxaFrete(atualizaRestaurante.getTaxaFrete());
        restaurante.setDataAtualizacao(LocalDateTime.now());

        return restaurante;
    }

    @Override
    public void deletarPorId(Long id) {

        var restaurante = buscarPorId(id);
        entityManager.remove(restaurante);
    }
}
