package com.caio.algaworks.quefome.service;

import com.caio.algaworks.quefome.exception.EntidadeEmUsoException;
import com.caio.algaworks.quefome.exception.EntidadeNaoEncontradaException;
import com.caio.algaworks.quefome.model.Cidade;
import com.caio.algaworks.quefome.repository.CidadeRepository;
import com.caio.algaworks.quefome.repository.EstadoRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CadastroCidadeService {

    private final CidadeRepository cidadeRepository;
    private final EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade){
        var cozinha = estadoRepository.buscarPorId(cidade.getEstado().getId());

        if(cozinha == null) {

            throw new EntidadeNaoEncontradaException("Estado não encontrado");
        }

        return cidadeRepository.cadastrar(cidade);
    }

    public List<Cidade> lista(){

        return cidadeRepository.listarTodos();
    }

    public Cidade busca(Long idCidade){

        return cidadeRepository.buscarPorId(idCidade);

    }

    public Cidade atualizar(Long idCidade, Cidade cidade){

        var estado = estadoRepository.buscarPorId(cidade.getEstado().getId());

        if(estado == null){
            throw new EntidadeNaoEncontradaException("estado nao encontrado");
        }

        return cidadeRepository.atualizar(idCidade, cidade.getNome());
    }

    public void excluir(Long idCidade){

        try {
            cidadeRepository.deletarPorId(idCidade);

        }catch (EmptyResultDataAccessException e){

            throw new EntidadeNaoEncontradaException("Cidade não encontrada");

        } catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException("Cidade não pode ser removida pois está em uso");
        }
    }
}
