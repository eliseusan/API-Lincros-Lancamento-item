package com.lincros.apilancamentoitem.lancamento.application.repository;

import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;

import java.util.List;
import java.util.UUID;

public interface LacamentoRepository {
    Lacamento salvaLacamento(Lacamento lacamento);

    Lacamento buscaLacamentoPorOId(UUID oidLacamento);

    List<Lacamento> buscaTodosLancamentos();

    void deletaLacamento(Lacamento lacamento);
}
