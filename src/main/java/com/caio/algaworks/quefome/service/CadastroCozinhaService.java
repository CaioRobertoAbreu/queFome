package com.caio.algaworks.quefome.service;

import com.caio.algaworks.quefome.exception.EntidadeEmUsoException;
import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Cozinha;
import com.caio.algaworks.quefome.repository.CozinhaRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadastroCozinhaService {

    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){

        return cozinhaRepository.cadastrar(cozinha);
    }

    public Cozinha buscar(Long idCozinha){

        return cozinhaRepository.buscarPorId(idCozinha);
    }

    public List<Cozinha> listar(){

        return cozinhaRepository.listar();
    }

    public Cozinha atualizar(Long idCozinha, Cozinha cozinha){

        return cozinhaRepository.atualizar(idCozinha, cozinha.getNome());
    }

    public void excluir(Long idCozinha){

        try {
            cozinhaRepository.deletarPorId(idCozinha);

        }catch (EmptyResultDataAccessException e){

            throw new EntidadeNaoEncontradaException("Cozinha não encontrada");

        } catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException("Cozinha não pode ser removida pois está em uso");
        }
    }
}
