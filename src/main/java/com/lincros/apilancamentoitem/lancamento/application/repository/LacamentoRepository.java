package com.lincros.apilancamentoitem.lancamento.application.repository;

import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;

public interface LacamentoRepository {
    Lacamento salvaLacamento(Lacamento lacamento);
}
