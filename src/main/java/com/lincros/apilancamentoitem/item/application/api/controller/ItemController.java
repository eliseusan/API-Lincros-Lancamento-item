package com.lincros.apilancamentoitem.item.application.api.controller;

import com.lincros.apilancamentoitem.item.application.api.requests.ItemAlteracaoRequest;
import com.lincros.apilancamentoitem.item.application.api.requests.ItemRequest;
import com.lincros.apilancamentoitem.item.application.api.response.ItemDetalhadoListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemResponse;
import com.lincros.apilancamentoitem.item.application.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@Log4j2
@RestController
@RequiredArgsConstructor
public class ItemController implements ItemAPi {

    private final ItemService itemService;

    @Override
    public ItemResponse salvaItem(ItemRequest itemRequest) {
        log.info("[start] ItemController - salvaItem");
        var item = itemService.criaItem(itemRequest);
        log.info("[finish] ItemController - salvaItem");
        return item;
    }

    @Override
    public ItemDetalhadoListResponse buscaItemPorOId(UUID oidItem) {
        log.info("[start] ItemController - buscaItemPorId");
        log.info("[oidItem] {}", oidItem);
        var itemPorOId = itemService.buscaItemPorOId(oidItem);
        log.info("[finish] ItemController - buscaItemPorId");
        return itemPorOId;
    }

    @Override
    public List<ItemListResponse> buscaTodosItens() {
        log.info("[start] ItemController - buscaTodosItens");
        var listaDeItens = itemService.buscaTodosItens();
        log.info("[finish] ItemController - buscaTodosItens");
        return listaDeItens;
    }


    @Override
    public void deletaItemPorOId(UUID oidItem) {
        log.info("[start] ItemController - deletaItemPorOId");
        log.info("[oidItem] {}", oidItem);
        itemService.deletaItemPorOId(oidItem);
        log.info("[finish] ItemController - deletaLacamentoPorOId");
    }

    @Override
    public void alteraItem(UUID oidItem, ItemAlteracaoRequest itemAlteracaoRequest) {
        log.info("[start] ItemController - alteraLacamento");
        log.info("[oidItem] {}", oidItem);
        itemService.alteraItem(oidItem, itemAlteracaoRequest);
        log.info("[finish] ItemController - alteraLacamento");
    }
}
