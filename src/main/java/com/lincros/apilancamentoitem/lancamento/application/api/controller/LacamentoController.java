package com.lincros.apilancamentoitem.lancamento.application.api.controller;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;
import com.lincros.apilancamentoitem.lancamento.application.service.LacamentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

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
}
