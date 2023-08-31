package com.lincros.apilancamentoitem.lancamento.application.api.controller.responses;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Builder
@Value
public class LacamentoResponse {
    private UUID oid;
}
