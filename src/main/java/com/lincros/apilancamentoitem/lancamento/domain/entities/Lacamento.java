package com.lincros.apilancamentoitem.lancamento.domain.entities;


import com.lincros.apilancamentoitem.lancamento.application.api.controller.requests.LacamentoRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "lacamentos")
public class Lacamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "oid", updatable = false, unique = true, nullable = false)
    private UUID oid;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_inicial")
    private LocalDate dtInicial;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "dt_final")
    private LocalDate dtFinal;

    @Column(name = "vl_total", precision = 8, scale = 2)
    private BigDecimal vlTotal;

    @Column(name = "observacao", length = 1000)
    private String observacao;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public Lacamento(LacamentoRequest lacamentoRequest) {
        this.dtInicial = lacamentoRequest.getDtInicial();
        this.dtFinal = lacamentoRequest.getDtFinal();
        this.vlTotal = lacamentoRequest.getVlTotal();
        this.observacao = lacamentoRequest.getObservacao();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
