package com.lincros.apilancamentoitem.lancamento.application.service;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoDetalhadoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoListResponse;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;
import com.lincros.apilancamentoitem.lancamento.application.repository.LacamentoRepository;
import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class LacamentoApplicationService implements LacamentoService {

    private final LacamentoRepository lacamentoRepository;
    @Override
    public LacamentoResponse criaLacamento(LacamentoRequest lacamentoRequest) {
        log.info("[start] LacamentoApplicationService - criaLacamento");
        Lacamento lacamento = lacamentoRepository.salvaLacamento(new Lacamento(lacamentoRequest));
        log.info("[finish] LacamentoApplicationService - criaLacamento");
        return LacamentoResponse.builder()
                .oid(lacamento.getOid())
                .build();
    }

    @Override
    public LacamentoDetalhadoListResponse buscaLacamentoPorOId(UUID oidLacamento) {
        log.info("[start] LacamentoApplicationService - buscaLacamentoPorOId");
        Lacamento lacamento = lacamentoRepository.buscaLacamentoPorOId(oidLacamento);
        log.info("[finish] LacamentoApplicationService - buscaLacamentoPorOId");
        return new LacamentoDetalhadoListResponse(lacamento);
    }

    @Override
    public List<LacamentoListResponse> buscaTodosLancamentos() {
        log.info("[start] LacamentoApplicationService - buscaTodosLancamentos");
        List<Lacamento> lacamentos = lacamentoRepository.buscaTodosLancamentos();
        log.info("[finish] LacamentoApplicationService - buscaTodosLancamentos");
        return LacamentoListResponse.converte(lacamentos);
    }

    @Override
    public void deletaLacamentoPorOId(UUID oidLacamento) {
        log.info("[start] LacamentoApplicationService - deletaLacamentoPorOId");
        Lacamento lacamento = lacamentoRepository.buscaLacamentoPorOId(oidLacamento);
        lacamentoRepository.deletaLacamento(lacamento);
        log.info("[finish] LacamentoApplicationService - deletaLacamentoPorOId");
    }
}
