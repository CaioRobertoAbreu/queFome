package com.caio.algaworks.quefome.repository.implementation;

import com.caio.algaworks.quefome.model.Cidade;
import com.caio.algaworks.quefome.repository.CidadeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
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
    public Cidade atualizar(Long idObjeto, String novoNomeObjeto) {
        var cidade = buscarPorId(idObjeto);

        if (cidade == null) {

            return null;
        }

        cidade.setNome(novoNomeObjeto);

        return cidade;
    }

    @Override
    public void deletarPorId(Long id) {

        var codade = buscarPorId(id);

        if(codade == null) {

            throw new EmptyResultDataAccessException(1);
        }

        System.out.println("DELETANDO COZINHA...");
        entityManager.remove(codade);
    }
}
