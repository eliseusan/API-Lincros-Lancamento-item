package com.lincros.apilancamentoitem.lancamento.application.api.requests;

import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
@Value
public class LacamentoRequest {

    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private BigDecimal vlTotal;
    private String observacao;
}
