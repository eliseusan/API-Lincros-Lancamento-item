package com.lincros.apilancamentoitem.lancamento.application.api.responses;

import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class LacamentoListResponse {
    private UUID oid;
    private LocalDate dtInicial;
    private LocalDate dtFinal;
    private BigDecimal vlTotal;
    private String observacao;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public LacamentoListResponse(Lacamento lacamento) {
        this.oid = lacamento.getOid();
        this.dtInicial = lacamento.getDtInicial();
        this.dtFinal = lacamento.getDtFinal();
        this.vlTotal = lacamento.getVlTotal();
        this.observacao = lacamento.getObservacao();
        this.dataHoraDoCadastro = lacamento.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = lacamento.getDataHoraDaUltimaAlteracao();
    }
    public static List<LacamentoListResponse> converte(List<Lacamento> lacamentos) {
        return lacamentos.stream()
                .map(LacamentoListResponse::new)
                .collect(Collectors.toList());
    }
}
