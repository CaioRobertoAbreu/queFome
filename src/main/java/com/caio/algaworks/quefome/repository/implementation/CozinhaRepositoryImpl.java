package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.Cozinha;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements com.caio.algaworks.quefome.repository.CozinhaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cozinha> listar(){

        System.out.println("======= LISTANDO COZINHAS ==========");
        return entityManager.createQuery("SELECT c FROM Cozinha c", Cozinha.class).getResultList();
    }

    @Override
    public Cozinha buscarPorId(Long id){

        System.out.println("======= BUSCANDO POR ID ==========");
        return entityManager.find(Cozinha.class, id);
    }

    @Override
    public Cozinha cadastrar(Cozinha cozinha){

        System.out.println("CADASTRANDO COZINHA...");
        return entityManager.merge(cozinha);
    }


    @Override
    public Cozinha atualizar(Long idObjeto, String novoNomeObjeto){

        System.out.println("ATUALIZANDO COZINHA....");
        var cozinha = buscarPorId(idObjeto);

        if (cozinha == null) {

            return null;
        }
        System.out.println("Atualizando cozinha " + cozinha.getNome() + " para " + novoNomeObjeto);
        cozinha.setNome(novoNomeObjeto);

        return cozinha;
    }

    @Override
    public void deletarPorId(Long idCozinha){

        var cozinha = buscarPorId(idCozinha);

        if(cozinha == null) {

            throw new EmptyResultDataAccessException(1);
        }

        System.out.println("DELETANDO COZINHA...");
        entityManager.remove(cozinha);
    }
}
