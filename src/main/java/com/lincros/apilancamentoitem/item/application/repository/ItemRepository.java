package com.lincros.apilancamentoitem.item.application.repository;

import com.lincros.apilancamentoitem.item.domain.entities.Item;

import java.util.List;
import java.util.UUID;

public interface ItemRepository {
    Item salvaItem(Item item);

    Item buscaItemPorOId(UUID oidItem);

    void deletaItem(Item item);

    List<Item> buscaTodosItens();
}
