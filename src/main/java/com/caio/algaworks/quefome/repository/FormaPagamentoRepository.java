package com.caio.algaworks.quefome.repository;

import com.caio.algaworks.quefome.model.FormaPagamento;
import org.springframework.stereotype.Repository;

import java.text.Normalizer;
import java.util.List;

@Repository
public interface FormaPagamentoRepository {

    FormaPagamento buscarPorId(Long id);

    List<FormaPagamento> listarTodas();

    void deletarPorId(Long id);

}
