package com.lincros.apilancamentoitem.item.application.service;

import com.lincros.apilancamentoitem.item.application.api.requests.ItemAlteracaoRequest;
import com.lincros.apilancamentoitem.item.application.api.requests.ItemRequest;
import com.lincros.apilancamentoitem.item.application.api.response.ItemDetalhadoListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemResponse;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    ItemResponse criaItem(ItemRequest itemRequest);

    ItemDetalhadoListResponse buscaItemPorOId(UUID oidItem);

    void deletaItemPorOId(UUID oidItem);

    void alteraItem(UUID oidItem, ItemAlteracaoRequest itemAlteracaoRequest);

    List<ItemListResponse> buscaTodosItens();
}
