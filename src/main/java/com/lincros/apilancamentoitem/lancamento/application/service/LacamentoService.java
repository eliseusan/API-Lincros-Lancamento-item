package com.lincros.apilancamentoitem.lancamento.application.service;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoDetalhadoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;

import java.util.UUID;

public interface LacamentoService {
    LacamentoResponse criaLacamento(LacamentoRequest lacamentoRequest);

    LacamentoDetalhadoListResponse buscaLacamentoPorOId(UUID oidLacamento);
}