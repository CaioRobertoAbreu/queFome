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

        System.out.println("======= LISTANDO COZINHAS ==========");
        return entityManager.createQuery("SELECT c FROM Cozinha c", Cozinha.class).getResultList();
    }

    @Transactional
    public Cozinha buscarPorId(Long id){

        System.out.println("======= BUSCANDO POR ID ==========");
        return entityManager.find(Cozinha.class, id);
    }

    @Transactional
    public void cadastrar(String nome){

        System.out.println("CADASTRANDO COZINHA...");
        entityManager.persist(new Cozinha(null, nome));
    }

    @Transactional
    public void atualizar(Long idObjeto, String novoNomeObjeto){

        System.out.println("ATUALIZANDO COZINHA....");
        var cozinha = buscarPorId(idObjeto);
        System.out.println("Atualizando cozinha " + cozinha.getNome() + " para " + novoNomeObjeto);
        cozinha.setNome(novoNomeObjeto);
    }
}
