package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.Cozinha;
import com.caio.algaworks.quefome.repository.CozinhaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

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
    public void cadastrar(String nome){

        System.out.println("CADASTRANDO COZINHA...");
        entityManager.persist(new Cozinha(null, nome));
    }


    @Override
    public void atualizar(Long idObjeto, String novoNomeObjeto){

        System.out.println("ATUALIZANDO COZINHA....");
        var cozinha = buscarPorId(idObjeto);
        System.out.println("Atualizando cozinha " + cozinha.getNome() + " para " + novoNomeObjeto);
        cozinha.setNome(novoNomeObjeto);
    }

    @Override
    public void deletarPorId(Long id){

        System.out.println("DELETANDO COZINHA...");
        entityManager.remove(buscarPorId(id));

    }
}
