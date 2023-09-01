package com.lincros.apilancamentoitem.item.application.api.controller;

import com.lincros.apilancamentoitem.item.application.api.requests.ItemAlteracaoRequest;
import com.lincros.apilancamentoitem.item.application.api.requests.ItemRequest;
import com.lincros.apilancamentoitem.item.application.api.response.ItemDetalhadoListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemListResponse;
import com.lincros.apilancamentoitem.item.application.api.response.ItemResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/itens")
public interface ItemAPi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ItemResponse salvaItem(@Valid @RequestBody ItemRequest itemRequest);

    @GetMapping(value = "/{oidItem}")
    @ResponseStatus(code = HttpStatus.OK)
    ItemDetalhadoListResponse buscaItemPorOId(@PathVariable UUID oidItem);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ItemListResponse> buscaTodosItens();

    @DeleteMapping(value = "/{oidItem}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaItemPorOId(@PathVariable UUID oidItem);

    @PatchMapping(value = "/{oidItem}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraItem(@PathVariable UUID oidItem,
                    @Valid @RequestBody ItemAlteracaoRequest itemAlteracaoRequest);
}
