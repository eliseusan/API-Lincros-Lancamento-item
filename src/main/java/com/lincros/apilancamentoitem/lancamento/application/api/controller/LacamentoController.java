package com.lincros.apilancamentoitem.lancamento.application.api.controller;

import com.lincros.apilancamentoitem.lancamento.application.api.requests.LacamentoAlteracaoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoDetalhadoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoResponse;
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
        log.info("[oidLacamento] {}", oidLacamento);
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

    @Override
    public void deletaLacamentoPorOId(UUID oidLacamento) {
        log.info("[start] LacamentoController - deletaLacamentoPorOId");
        log.info("[oidLacamento] {}", oidLacamento);
        lacamentoService.deletaLacamentoPorOId(oidLacamento);
        log.info("[finish] LacamentoController - deletaLacamentoPorOId");
    }

    @Override
    public void alteraLacamento(UUID oidLacamento, LacamentoAlteracaoRequest lacamentoAlteracaoRequest) {
        log.info("[start] LacamentoController - alteraLacamento");
        log.info("[oidLacamento] {}", oidLacamento);
        lacamentoService.alteraLacamento(oidLacamento, lacamentoAlteracaoRequest);
        log.info("[finish] LacamentoController - alteraLacamento");
    }
}
