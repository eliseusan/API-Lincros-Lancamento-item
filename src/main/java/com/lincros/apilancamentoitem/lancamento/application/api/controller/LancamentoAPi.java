package com.lincros.apilancamentoitem.lancamento.application.api.controller;

import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import com.lincros.apilancamentoitem.lancamento.application.api.controller.responses.LacamentoResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/lacamentos")
public interface LancamentoAPi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LacamentoResponse salvaLancamento(@Valid @RequestBody LacamentoRequest lacamentoRequest);
}
