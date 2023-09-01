package com.lincros.apilancamentoitem.item.domain.entities;

import com.lincros.apilancamentoitem.item.application.api.requests.ItemAlteracaoRequest;
import com.lincros.apilancamentoitem.item.application.api.requests.ItemRequest;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "oid", updatable = false, unique = true, nullable = false)
    private UUID oid;
    @Column(name = "descricao", length = 255)
    private String descricao;
    @Column(name = "valor", precision = 8, scale = 2)
    private BigDecimal valor;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Item(ItemRequest itemRequest) {
        this.descricao = itemRequest.getDescricao();
        this.valor = itemRequest.getValor();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void alteraItem(ItemAlteracaoRequest itemAlteracaoRequest) {
        this.descricao = itemAlteracaoRequest.getDescricao();
        this.valor = itemAlteracaoRequest.getValor();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}
