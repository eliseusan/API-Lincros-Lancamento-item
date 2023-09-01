package com.lincros.apilancamentoitem.item.application.api.response;

import com.lincros.apilancamentoitem.item.domain.entities.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ItemListResponse {
    private UUID oid;
    private String descricao;
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public ItemListResponse(Item item) {
        this.oid = item.getOid();
        this.descricao = item.getDescricao();
        this.valor = item.getValor();
        this.dataHoraDoCadastro = item.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = item.getDataHoraDaUltimaAlteracao();
    }
    public static List<ItemListResponse> converte(List<Item> itens) {
        return itens.stream()
                .map(ItemListResponse::new)
                .collect(Collectors.toList());
    }
}
