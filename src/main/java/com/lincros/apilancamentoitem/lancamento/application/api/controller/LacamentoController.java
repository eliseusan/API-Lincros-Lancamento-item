package com.lincros.apilancamentoitem.lancamento.application.api.controller;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoDetalhadoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;
import com.lincros.apilancamentoitem.lancamento.application.service.LacamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Log4j2
@RestController
@RequiredArgsConstructor
public class LacamentoController implements LancamentoAPi {

    private final LacamentoService lacamentoService;
    @Override
    public LacamentoResponse salvaLancamento(LacamentoRequest lacamentoRequest) {
        log.info("[start] LacamentoController - salvaLancamento");
        var lacamento = lacamentoService.criaLacamento(lacamentoRequest);
        log.info("[finish] LacamentoController - salvaLancamento");
        return lacamento;
    }

    @Override
    public LacamentoDetalhadoListResponse buscaLacamentoPorId(UUID oidLacamento) {
        log.info("[start] LacamentoController - buscaLacamentoPorId");
        log.info("[idProduto] {}", oidLacamento);
        var lacamentoPorId = lacamentoService.buscaLacamentoPorOId(oidLacamento);
        log.info("[finish] LacamentoController - buscaLacamentoPorId");
        return lacamentoPorId;
    }

    @Override
    public List<LacamentoListResponse> buscaTodosLacamentos() {
        log.info("[start] LacamentoController - buscaTodosLacamentos");
        var listaDeLancamentos = lacamentoService.buscaTodosLancamentos();
        log.info("[finish] LacamentoController - buscaTodosLacamentos");
        return listaDeLancamentos;
    }
}
