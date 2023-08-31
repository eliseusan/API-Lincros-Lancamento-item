package com.lincros.apilancamentoitem.lancamento.application.service;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;

public interface LacamentoService {
    LacamentoResponse criaLacamento(LacamentoRequest lacamentoRequest);
}
