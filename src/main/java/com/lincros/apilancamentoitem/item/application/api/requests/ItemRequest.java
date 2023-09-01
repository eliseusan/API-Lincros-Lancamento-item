package com.lincros.apilancamentoitem.item.application.api.requests;

import lombok.Value;

import java.math.BigDecimal;
@Value
public class ItemRequest {
    private String descricao;
    private BigDecimal valor;
}
