package com.lincros.apilancamentoitem.lancamento.application.service;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;
import com.lincros.apilancamentoitem.lancamento.application.repository.LacamentoRepository;
import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

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

}
