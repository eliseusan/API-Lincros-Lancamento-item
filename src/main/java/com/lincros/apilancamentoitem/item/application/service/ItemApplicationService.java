package com.lincros.apilancamentoitem.item.application.service;

import com.lincros.apilancamentoitem.item.application.api.requests.ItemAlteracaoRequest;
import com.lincros.apilancamentoitem.item.application.api.requests.ItemRequest;
import com.lincros.apilancamentoitem.item.application.api.response.ItemDetalhadoListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemResponse;
import com.lincros.apilancamentoitem.item.application.repository.ItemRepository;
import com.lincros.apilancamentoitem.item.domain.entities.Item;
import com.lincros.apilancamentoitem.lancamento.application.api.responses.LacamentoListResponse;
import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ItemApplicationService implements ItemService {

    private final ItemRepository itemRepository;
    @Override
    public ItemResponse criaItem(ItemRequest itemRequest) {
        log.info("[start] ItemApplicationService - criaItem");
        Item item = itemRepository.salvaItem(new Item(itemRequest));
        log.info("[finish] ItemApplicationService - criaItem");
        return ItemResponse.builder()
                .oid(item.getOid())
                .build();
    }

    @Override
    public ItemDetalhadoListResponse buscaItemPorOId(UUID oidItem) {
        log.info("[start] ItemApplicationService - buscaItemPorOId");
        Item item = itemRepository.buscaItemPorOId(oidItem);
        log.info("[finish] ItemApplicationService - buscaItemPorOId");
        return new ItemDetalhadoListResponse(item);
    }



    @Override
    public void deletaItemPorOId(UUID oidItem) {
        log.info("[start] ItemApplicationService - deletaItemPorOId");
        Item item = itemRepository.buscaItemPorOId(oidItem);
        itemRepository.deletaItem(item);
        log.info("[finish] ItemApplicationService - deletaItemPorOId");
    }

    @Override
    public void alteraItem(UUID oidItem, ItemAlteracaoRequest itemAlteracaoRequest) {
        log.info("[start] ItemApplicationService - alteraItem");
        Item item = itemRepository.buscaItemPorOId(oidItem);
        item.alteraItem(itemAlteracaoRequest);
        itemRepository.salvaItem(item);
        log.info("[finish] ItemApplicationService - alteraItem");
    }

    @Override
    public List<ItemListResponse> buscaTodosItens() {
        log.info("[start] LacamentoApplicationService - buscaTodosItens");
        List<Item> itens = itemRepository.buscaTodosItens();
        log.info("[finish] LacamentoApplicationService - buscaTodosItens");
        return ItemListResponse.converte(itens);
    }
}
