package com.lincros.apilancamentoitem.lancamento.application.api.responses;

import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Value
public class LacamentoDetalhadoListResponse {
    private UUID oid;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private BigDecimal vlTotal;
    private String observacao;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public LacamentoDetalhadoListResponse(Lacamento lacamento) {
        this.oid = lacamento.getOid();
        this.dtInicial = lacamento.getDtInicial();
        this.dtFinal = lacamento.getDtFinal();
        this.vlTotal = lacamento.getVlTotal();
        this.observacao = lacamento.getObservacao();
        this.dataHoraDoCadastro = lacamento.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = lacamento.getDataHoraDaUltimaAlteracao();
    }
}
