package com.lincros.apilancamentoitem.lancamento.application.service;

import com.lincros.apilancamentoitem.lancamento.application.api.requests.LacamentoAlteracaoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoDetalhadoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoResponse;

import java.util.List;
import java.util.UUID;

public interface LacamentoService {
    LacamentoResponse criaLacamento(LacamentoRequest lacamentoRequest);

    LacamentoDetalhadoListResponse buscaLacamentoPorOId(UUID oidLacamento);

    List<LacamentoListResponse> buscaTodosLancamentos();

    void deletaLacamentoPorOId(UUID oidLacamento);

    void alteraLacamento(UUID oidLacamento, LacamentoAlteracaoRequest lacamentoAlteracaoRequest);
}
