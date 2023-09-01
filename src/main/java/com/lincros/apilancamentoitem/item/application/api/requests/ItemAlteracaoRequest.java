package com.lincros.apilancamentoitem.item.application.api.requests;

import lombok.Value;

import java.math.BigDecimal;
@Value
public class ItemAlteracaoRequest {
    private String descricao;
    private BigDecimal valor;
}
