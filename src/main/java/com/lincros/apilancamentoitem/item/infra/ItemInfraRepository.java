package com.lincros.apilancamentoitem.item.infra;

import com.lincros.apilancamentoitem.handler.APIException;
import com.lincros.apilancamentoitem.item.application.repository.ItemRepository;
import com.lincros.apilancamentoitem.item.domain.entities.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ItemInfraRepository implements ItemRepository {

    private final ItemSpringDataJPARepository itemSpringDataJPARepository;

    @Override
    public Item salvaItem(Item item) {
        log.info("[start] ItemInfraRepository - salvaItem ");
        itemSpringDataJPARepository.save(item);
        log.info("[finish] ItemInfraRepository - salvaItem ");
        return item;
    }

    @Override
    public Item buscaItemPorOId(UUID oidItem) {
        log.info("[start] ItemInfraRepository - buscaItemPorOId ");
        var itemPorOId = itemSpringDataJPARepository.findById(oidItem)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "ITEM NÃO ENCONTRADO!"));
        log.info("[finish] ItemInfraRepository - buscaItemPorOId ");
        return itemPorOId;
    }

    @Override
    public void deletaItem(Item item) {
        log.info("[start] ItemInfraRepository - deletaLacamento ");
        itemSpringDataJPARepository.delete(item);
        log.info("[finish] ItemInfraRepository - deletaLacamento ");
    }

    @Override
    public List<Item> buscaTodosItens() {
        log.info("[start] ItemInfraRepository - buscaTodosItens ");
        var itens = itemSpringDataJPARepository.findAll();
        log.info("[finish] ItemInfraRepository - buscaTodosItens ");
        return itens;
    }
}
