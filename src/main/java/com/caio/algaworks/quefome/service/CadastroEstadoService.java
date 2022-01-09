package com.caio.algaworks.quefome.service;

import com.caio.algaworks.quefome.exception.EntidadeEmUsoException;
import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Estado;
import com.caio.algaworks.quefome.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadastroEstadoService {

    private final EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){

        return estadoRepository.cadastrar(estado);
    }

    public List<Estado> lista(){

        return estadoRepository.listarTodos();
    }

    public Estado busca(Long idEstado){

        return estadoRepository.buscarPorId(idEstado);

    }

    public Estado atualizar(Long idEstado, Estado estado){

        return estadoRepository.atualizar(idEstado, estado.getNome());
    }

    public void excluir(Long idEstado){

        try {
            estadoRepository.deletarPorId(idEstado);

        }catch (EmptyResultDataAccessException e){

            throw new EntidadeNaoEncontradaException("Estado não encontrado");

        } catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException("Estado não pode ser removido pois está em uso");
        }
    }
}
