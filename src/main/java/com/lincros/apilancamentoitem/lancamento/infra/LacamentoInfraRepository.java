package com.lincros.apilancamentoitem.lancamento.infra;

import com.lincros.apilancamentoitem.handler.APIException;
import com.lincros.apilancamentoitem.lancamento.application.repository.LacamentoRepository;
import com.lincros.apilancamentoitem.lancamento.domain.entities.Lacamento;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LacamentoInfraRepository implements LacamentoRepository {

    private final LacamentoSpringDataJPARepository lacamentoSpringDataJPARepository;

    @Override
    public Lacamento salvaLacamento(Lacamento lacamento) {
        log.info("[start] LacamentoInfraRepository - salvaLacamento ");
        lacamentoSpringDataJPARepository.save(lacamento);
        log.info("[finish] LacamentoInfraRepository - salvaLacamento ");
        return lacamento;
    }

    @Override
    public Lacamento buscaLacamentoPorOId(UUID oidLacamento) {
        log.info("[start] LacamentoInfraRepository - buscaLacamentoPorOId ");
        var lacamentoPorOId = lacamentoSpringDataJPARepository.findById(oidLacamento)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "LAÇAMENTO NÃO ENCONTRADO!"));
        log.info("[finish] LacamentoInfraRepository - buscaLacamentoPorOId ");
        return lacamentoPorOId;
    }

    @Override
    public List<Lacamento> buscaTodosLancamentos() {
        log.info("[start] LacamentoInfraRepository - buscaTodosLancamentos ");
        var lacamentos = lacamentoSpringDataJPARepository.findAll();
        log.info("[finish] LacamentoInfraRepository - buscaTodosLancamentos ");
        return lacamentos;
    }

    @Override
    public void deletaLacamento(Lacamento lacamento) {
        log.info("[start] LacamentoInfraRepository - deletaLacamento ");
        lacamentoSpringDataJPARepository.delete(lacamento);
        log.info("[finish] LacamentoInfraRepository - deletaLacamento ");
    }
}
