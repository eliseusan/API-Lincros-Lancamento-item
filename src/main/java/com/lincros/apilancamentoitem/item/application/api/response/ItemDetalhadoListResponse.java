package com.lincros.apilancamentoitem.item.application.api.response;

import com.lincros.apilancamentoitem.item.domain.entities.Item;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ItemDetalhadoListResponse {
    private UUID oid;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public ItemDetalhadoListResponse(Item item) {
        this.oid = item.getOid();
        this.descricao = item.getDescricao();
        this.valor = item.getValor();
        this.dataHoraDoCadastro = item.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = item.getDataHoraDaUltimaAlteracao();
    }
}
