package com.lincros.apilancamentoitem.item.application.api.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Builder
@Value
public class ItemResponse {
    private UUID oid;
}
